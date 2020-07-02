package dataBaseA;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AskPopup extends JComponent implements ActionListener {

	private JFrame popUp; 
	private JButton yesButton, noButton;
	private int callingType; 
	
	public AskPopup(int calling) {
		callingType = calling;
				
		popUp = new JFrame ("계정 탈퇴");
		popUp.getContentPane().setBackground(Color.WHITE);
		popUp.setBackground(Color.WHITE);
		popUp.getContentPane().setForeground(Color.WHITE);
		popUp.getContentPane().setLayout(null);
		
		JLabel catIcon = new JLabel(" ");
		catIcon.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/KakaoTalk_Photo_2020-07-01-16-19-10.png"));
		catIcon.setBounds(66, 20, 118, 48);
		popUp.getContentPane().add(catIcon);
		
		JLabel reactionLabel = new JLabel("정말로 탈퇴해요?");
		reactionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		reactionLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", reactionLabel.getFont().getStyle(), 15));
		reactionLabel.setBounds(45, 80, 167, 16);
		popUp.getContentPane().add(reactionLabel);
		
		yesButton = new JButton("네");
		yesButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", yesButton.getFont().getStyle(), yesButton.getFont().getSize()));
		yesButton.setBounds(41, 117, 75, 30);
		popUp.getContentPane().add(yesButton);
		
		noButton = new JButton("아니요");
		noButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", yesButton.getFont().getStyle(), yesButton.getFont().getSize()));
		noButton.setBounds(137, 117, 75, 30);
		popUp.getContentPane().add(noButton);
		popUp.setSize(250, 187);
		popUp.setLocation(500, 300);
		
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		
		popUp.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(noButton)) {
			popUp.dispose();
			new MainFrame();
		}
		else if(e.getSource().equals(yesButton)) {
			if(callingType == 1) {
				popUp.dispose();
				DBConnection.getInstance().deleteUserInfo();
				new LoginFrame();
				new ClearPopup("탈퇴");
			}
			else if(callingType == 0) {
				popUp.dispose();
				DBConnection.getInstance().deleteUserInfo();
//				new MasterFrame();
				new ClearPopup("삭제");
			}
			
		}
	}
}

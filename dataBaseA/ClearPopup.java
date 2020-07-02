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

public class ClearPopup extends JComponent {

	private JFrame popUp; 
	
	public ClearPopup(String did) {
		popUp = new JFrame (did);
		popUp.getContentPane().setBackground(Color.WHITE);
		popUp.setBackground(Color.WHITE);
		popUp.getContentPane().setForeground(Color.WHITE);
		popUp.getContentPane().setLayout(null);
		
		JLabel catIcon = new JLabel(" ");
		catIcon.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/Aybp43Q2_400x400.jpg"));
		catIcon.setBounds(42, 46, 51, 50);
		popUp.getContentPane().add(catIcon);
		
		JLabel InfoMessageLabel = new JLabel(did+" 성공!");
		InfoMessageLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", InfoMessageLabel.getFont().getStyle(), InfoMessageLabel.getFont().getSize()));
		InfoMessageLabel.setBounds(104, 63, 105, 19);
		popUp.getContentPane().add(InfoMessageLabel);
		
		JLabel reactionLabel = new JLabel("으와아앙");
		reactionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if (did=="탈퇴") {
			reactionLabel.setText("으아앙 잘가요");
		}
		else if(did=="로그아웃") {
			reactionLabel.setText("담에 또 놀러와오");
		}
		reactionLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", reactionLabel.getFont().getStyle(), 15));
		reactionLabel.setBounds(42, 23, 167, 16);
		popUp.getContentPane().add(reactionLabel);
		popUp.setSize(250, 150);
		popUp.setLocation(500, 300);
		
		popUp.setVisible(true);
		auto_exit();
		
	}
	
	public void auto_exit() {
		Timer timer = new Timer(1500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				quit();
			}

		});
		timer.start();
	}
	
	private void quit() {
		popUp.dispose();
	}
}

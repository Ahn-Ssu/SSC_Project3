package dataBaseA;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

public class MainFrame extends JComponent implements ActionListener {

	private JFrame mainFrame;
	private UserInfo nowInfo = new UserInfo();
	private JTextField profMessageBox;
	private JButton fixButton ;
	private JLabel nowMessageLabel;
	private JMenuItem logout;
	private JMenuItem fixInfo;
	private JMenuItem exitAccount;
	
	
	
	
	public MainFrame() {
		nowInfo = DBConnection.getInstance().getNowInfo();
		
		mainFrame = new JFrame("안녕요! "+ nowInfo.userNick);
		mainFrame.getContentPane().setBackground(Color.WHITE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setVisible(true);
		mainFrame.setSize(650, 535);
		mainFrame.setLocation(300, 150);
		
		JLabel welcomeIcon = new JLabel(" ");
		welcomeIcon.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/Aybp43Q2_400x400.jpg"));
		welcomeIcon.setBounds(23, 16, 50, 50);
		mainFrame.getContentPane().add(welcomeIcon);
		
		JLabel welcomeLabel = new JLabel("어서와요, " + nowInfo.userNick);
		welcomeLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", welcomeLabel.getFont().getStyle(), 16));
		welcomeLabel.setBounds(82, 33, 270, 16);
		mainFrame.getContentPane().add(welcomeLabel);
		
		JLabel myInfoLabel = new JLabel("< 내 정보 >");
		myInfoLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", myInfoLabel.getFont().getStyle() | Font.BOLD, 14));
		myInfoLabel.setBounds(53, 90, 87, 16);
		mainFrame.getContentPane().add(myInfoLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", lblNewLabel_1.getFont().getStyle(), lblNewLabel_1.getFont().getSize()));
		lblNewLabel_1.setBounds(40, 190, 61, 16);
		mainFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("별명");
		label.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", label.getFont().getStyle(), label.getFont().getSize()));
		label.setBounds(40, 240, 61, 16);
		mainFrame.getContentPane().add(label);
		
		JLabel myBDayLable = new JLabel("생일");
		myBDayLable.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", myBDayLable.getFont().getStyle(), myBDayLable.getFont().getSize()));
		myBDayLable.setBounds(40, 290, 61, 16);
		mainFrame.getContentPane().add(myBDayLable);
		
		JLabel myContactLabel = new JLabel("연락처");
		myContactLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", myContactLabel.getFont().getStyle(), myContactLabel.getFont().getSize()));
		myContactLabel.setBounds(40, 340, 61, 16);
		mainFrame.getContentPane().add(myContactLabel);
		
		JLabel myQuestionLabel = new JLabel("질문");
		myQuestionLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", myQuestionLabel.getFont().getStyle(), myQuestionLabel.getFont().getSize()));
		myQuestionLabel.setBounds(40, 390, 61, 16);
		mainFrame.getContentPane().add(myQuestionLabel);
		
		JLabel myQnswerLabel = new JLabel("답변");
		myQnswerLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", myQnswerLabel.getFont().getStyle(), myQnswerLabel.getFont().getSize()));
		myQnswerLabel.setBounds(40, 440, 61, 16);
		mainFrame.getContentPane().add(myQnswerLabel);
		
		JLabel myMessageLabel = new JLabel("상태메세지");
		myMessageLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", myMessageLabel.getFont().getStyle(), myMessageLabel.getFont().getSize()));
		myMessageLabel.setBounds(40, 140, 87, 16);
		mainFrame.getContentPane().add(myMessageLabel);
		
		nowMessageLabel = new JLabel("설정한 프로필메세지가 없어요");
		if(nowInfo.userComment !=null)
		if(!nowInfo.userComment.equals("null"))
		if(!nowInfo.userComment.equals("NULL"))
			nowMessageLabel.setText(nowInfo.userComment);
		nowMessageLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nowMessageLabel.getFont().getStyle(), nowMessageLabel.getFont().getSize()));
		nowMessageLabel.setBounds(140, 137, 333, 22);
		mainFrame.getContentPane().add(nowMessageLabel);
		
		profMessageBox = new JTextField();
		profMessageBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", profMessageBox.getFont().getStyle(), profMessageBox.getFont().getSize()));
		profMessageBox.setBounds(136, 135, 216, 26);
		mainFrame.getContentPane().add(profMessageBox);
		profMessageBox.setVisible(false);
		profMessageBox.setColumns(10);
		
		JLabel nowMyIDLabel = new JLabel(nowInfo.userID);
		nowMyIDLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nowMyIDLabel.getFont().getStyle(), nowMyIDLabel.getFont().getSize()));
		nowMyIDLabel.setBounds(142, 190, 210, 16);
		mainFrame.getContentPane().add(nowMyIDLabel);
		
		JLabel nowMyNick = new JLabel(nowInfo.userNick);
		nowMyNick.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nowMyIDLabel.getFont().getStyle(), nowMyIDLabel.getFont().getSize()));
		nowMyNick.setBounds(142, 240, 210, 16);
		mainFrame.getContentPane().add(nowMyNick);
		
		JLabel nowMyBdayLabel = new JLabel(nowInfo.userBMonth + "월, " + nowInfo.userBDay +"일");
		nowMyBdayLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nowMyIDLabel.getFont().getStyle(), nowMyIDLabel.getFont().getSize()));
		nowMyBdayLabel.setBounds(142, 290, 210, 16);
		mainFrame.getContentPane().add(nowMyBdayLabel);
		
		
		JLabel nowMyQuestionLabel = new JLabel();
		if(nowInfo.userQuestion == 1) {
			nowMyQuestionLabel.setText("제일 낮은 성적을 기록한 수업은??");
		}
		else if(nowInfo.userQuestion == 2) {
			nowMyQuestionLabel.setText("외할머니의 성함은??");
		}
		else if(nowInfo.userQuestion == 3) {
			nowMyQuestionLabel.setText("지금 사용 중인 핸드폰 모델은??");
		}
		
		nowMyQuestionLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nowMyIDLabel.getFont().getStyle(), nowMyIDLabel.getFont().getSize()));
		nowMyQuestionLabel.setBounds(142, 390, 210, 16);
		mainFrame.getContentPane().add(nowMyQuestionLabel);
		
		JLabel nowMyAnswerLabel = new JLabel(nowInfo.userAnswer);
		nowMyAnswerLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nowMyIDLabel.getFont().getStyle(), nowMyIDLabel.getFont().getSize()));
		nowMyAnswerLabel.setBounds(142, 440, 210, 16);
		mainFrame.getContentPane().add(nowMyAnswerLabel);
		
		JLabel nowMyContactLabel = new JLabel(nowInfo.userContact);
		nowMyContactLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nowMyIDLabel.getFont().getStyle(), nowMyIDLabel.getFont().getSize()));
		nowMyContactLabel.setBounds(142, 340, 210, 16);
		mainFrame.getContentPane().add(nowMyContactLabel);
		
		fixButton = new JButton("수정");
		fixButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", fixButton.getFont().getStyle(), fixButton.getFont().getSize()));
		fixButton.setBounds(467, 135, 81, 29);
		mainFrame.getContentPane().add(fixButton);
		
		JLabel catIcom = new JLabel(" ");
		catIcom.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/KakaoTalk_Photo_2020-06-30-14-37-45.png"));
		catIcom.setBounds(467, 307, 177, 165);
		mainFrame.getContentPane().add(catIcom);
		
		JMenuBar menuBar = new JMenuBar();
		mainFrame.setJMenuBar(menuBar);
		
		JMenu accountEdit = new JMenu("계정 관리 ");
		accountEdit.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", accountEdit.getFont().getStyle(), accountEdit.getFont().getSize()));
		menuBar.add(accountEdit);
		
		fixInfo = new JMenuItem("내 정보 수정");
		fixInfo.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", fixInfo.getFont().getStyle(), fixInfo.getFont().getSize()));
		accountEdit.add(fixInfo);
		
		logout = new JMenuItem("로그아웃");
		logout.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", logout.getFont().getStyle(), logout.getFont().getSize()));
		accountEdit.add(logout);
		
		exitAccount = new JMenuItem("회원 탈퇴");
		exitAccount.setForeground(UIManager.getColor("CheckBox.select"));
		exitAccount.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", exitAccount.getFont().getStyle(), exitAccount.getFont().getSize()));
		accountEdit.add(exitAccount);
		
		exitAccount.addActionListener(this);
		fixButton.addActionListener(this);
		fixInfo.addActionListener(this);
		logout.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "수정") {
			nowMessageLabel.setVisible(false);
			profMessageBox.setVisible(true);
			profMessageBox.requestFocus();
			fixButton.setText("적용");
		}
		else if (e.getActionCommand() == "적용"){
			nowMessageLabel.setVisible(true);
			profMessageBox.setVisible(false);
			nowInfo.userComment = profMessageBox.getText();
			DBConnection.getInstance().setComment(nowInfo.userComment);
			nowMessageLabel.setText(nowInfo.userComment);
			fixButton.setText("수정");
		}
		else if(e.getSource().equals(logout)) {
			new LoginFrame();
			new ClearPopup("로그아웃");
			mainFrame.dispose();
		}
		else if(e.getSource().equals(fixInfo)) {
			mainFrame.dispose();
			new InfoFixFrame(1);
		}
		else if(e.getSource().equals(exitAccount)) {
			new AskPopup(1);
			mainFrame.dispose();
		}
			
		
	}
}

package dataBaseA;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoFixFrame extends JComponent  implements ActionListener {

	// 로그인 창에서 회원가입을 눌렀을 떄, 무한하게 회원가입 창을 띄우는 것이 아니고 한번만 띄우게 하기 위해서 싱글톤으로 설
	private static InfoFixFrame instance;
	// 창을 꺼버리거나, 취소를 눌러서 창을 종료하는 경우 사용할 변수 
	private static boolean isOff;
	
	private JFrame infoFix = new JFrame("Info Fix / 정보 수정");
	private JPasswordField PWBox;
	private JTextField phoneBox;
	private JTextField answerBox;
	private JTextField nicknameBox;
	private JComboBox monthBox;
	private JComboBox dayBox;
	private JComboBox questionBox;
	private JButton PWButton;
	private JButton nickButton;
	private static int callingType;
	
	public InfoFixFrame(int calling) {
		callingType = calling;
		infoFix.getContentPane().setBackground(Color.WHITE);
		infoFix.setSize(441, 562);
		infoFix.getContentPane().setLayout(null);
		infoFix.setLocation(100, 50);
		
		infoFix.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				isOff= true; 
			}
		});
		
		JLabel titleLabel = new JLabel("이번엔 어떻게 적을거예요?");
		titleLabel.setBounds(70, 41, 245, 44);
		titleLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", titleLabel.getFont().getStyle(), 20));
		infoFix.getContentPane().add(titleLabel);
		
		JLabel mainCatIcon = new JLabel(" ");
		mainCatIcon.setBounds(273, 21, 184, 139);
		mainCatIcon.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/tree_ico_my_adorable_cats-240x240.png"));
		infoFix.getContentPane().add(mainCatIcon);
		
		PWBox = new JPasswordField();
		PWBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", PWBox.getFont().getStyle(), PWBox.getFont().getSize()));
		PWBox.setColumns(10);
		PWBox.setBounds(140, 158, 165, 26);
		PWBox.setEchoChar('*');
		infoFix.getContentPane().add(PWBox);
		
		JLabel PWLabel = new JLabel("PW /  비밀번호");
		PWLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", PWLabel.getFont().getStyle(), PWLabel.getFont().getSize()));
		PWLabel.setBounds(40, 163, 96, 16);
		infoFix.getContentPane().add(PWLabel);
		
		JLabel lblBd = new JLabel("B.D / 생일");
		lblBd.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", lblBd.getFont().getStyle(), lblBd.getFont().getSize()));
		lblBd.setBounds(40, 276, 86, 16);
		infoFix.getContentPane().add(lblBd);
		
		 monthBox = new JComboBox();
		monthBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", monthBox.getFont().getStyle(), 12));
		monthBox.setToolTipText("월");
		monthBox.setModel(new DefaultComboBoxModel(new String[] {"  1월", "  2월", "  3월", "  4월", "  5월", "  6월", "  7월", "  8월", "  9월", "10월", "11월", "12월"}));
		monthBox.setMaximumRowCount(12);
		monthBox.setBounds(140, 271, 81, 27);
		infoFix.getContentPane().add(monthBox);
		
		dayBox = new JComboBox();
		dayBox.setModel(new DefaultComboBoxModel(new String[] {"  1일", "  2일", "  3일", "  4일", "  5일", "  6일", "  7일", "  8일", "  9일", "10일", "11일", "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일", "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"}));
		dayBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", dayBox.getFont().getStyle(), dayBox.getFont().getSize()));
		dayBox.setToolTipText("월");
		dayBox.setMaximumRowCount(31);
		dayBox.setBounds(224, 271, 81, 27);
		infoFix.getContentPane().add(dayBox);
		
		phoneBox = new JTextField();
		phoneBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", phoneBox.getFont().getStyle(), phoneBox.getFont().getSize()));
		phoneBox.setColumns(10);
		phoneBox.setBounds(140, 322, 165, 26);
		infoFix.getContentPane().add(phoneBox);
		
		JLabel PhoneLabel = new JLabel("Phone / 연락처");
		PhoneLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", PhoneLabel.getFont().getStyle(), PhoneLabel.getFont().getSize()));
		PhoneLabel.setBounds(40, 327, 96, 16);
		infoFix.getContentPane().add(PhoneLabel);
		
		JLabel lblNewLabel = new JLabel("12자 이내, 영어 숫자 조합");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBackground(new Color(238, 238, 238));
		lblNewLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", lblNewLabel.getFont().getStyle(), 10));
		lblNewLabel.setBounds(150, 182, 143, 16);
		infoFix.getContentPane().add(lblNewLabel);
		
		JLabel phoneOptionLabel = new JLabel("- 제외, 01051611257");
		phoneOptionLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", phoneOptionLabel.getFont().getStyle(), 10));
		phoneOptionLabel.setForeground(Color.LIGHT_GRAY);
		phoneOptionLabel.setBackground(SystemColor.window);
		phoneOptionLabel.setBounds(150, 346, 143, 16);
		infoFix.getContentPane().add(phoneOptionLabel);
		
		JLabel answerLabel = new JLabel("Answer / 답");
		answerLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", answerLabel.getFont().getStyle(), answerLabel.getFont().getSize()));
		answerLabel.setBounds(40, 409, 96, 16);
		infoFix.getContentPane().add(answerLabel);
		
		answerBox = new JTextField();
		answerBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", answerBox.getFont().getStyle(), answerBox.getFont().getSize()));
		answerBox.setColumns(10);
		answerBox.setBounds(140, 403, 165, 26);
		infoFix.getContentPane().add(answerBox);
		
		questionBox = new JComboBox();
		questionBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", questionBox.getFont().getStyle(), 9));
		questionBox.setModel(new DefaultComboBoxModel(new String[] {"제일 낮은 성적을 기록한 수업은??", "외할머니의 성함은??", "지금 사용 중인 핸드폰 모델은??"}));
		questionBox.setBounds(140, 372, 165, 27);
		infoFix.getContentPane().add(questionBox);
		
		JButton cancelButton = new JButton("Cancel / 취소");
		cancelButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", cancelButton.getFont().getStyle(), cancelButton.getFont().getSize()));
		cancelButton.setBounds(97, 485, 117, 29);
		infoFix.getContentPane().add(cancelButton);
		
		JButton confirmButton = new JButton("Confirm / 확인");
		confirmButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", confirmButton.getFont().getStyle(), confirmButton.getFont().getSize()));
		confirmButton.setBounds(244, 485, 117, 29);
		infoFix.getContentPane().add(confirmButton);
		
		JLabel flowerIcon = new JLabel(" ");
		flowerIcon.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/KakaoTalk_Photo_2020-06-30-14-38-06.png"));
		flowerIcon.setBounds(30, 462, 66, 44);
		infoFix.getContentPane().add(flowerIcon);
		
		nicknameBox = new JTextField();
		nicknameBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nicknameBox.getFont().getStyle(), nicknameBox.getFont().getSize()));
		nicknameBox.setColumns(10);
		nicknameBox.setBounds(140, 211, 165, 26);
		infoFix.getContentPane().add(nicknameBox);
		
		JLabel nicknameLabel = new JLabel("Nickname / 별명");
		nicknameLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nicknameLabel.getFont().getStyle(), nicknameLabel.getFont().getSize()));
		nicknameLabel.setBounds(40, 216, 96, 16);
		infoFix.getContentPane().add(nicknameLabel);
		
		JLabel nickOptionLabel = new JLabel("2글자 이상, 형식 자율");
		nickOptionLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nickOptionLabel.getFont().getStyle(), 10));
		nickOptionLabel.setForeground(Color.LIGHT_GRAY);
		nickOptionLabel.setBackground(SystemColor.window);
		nickOptionLabel.setBounds(150, 236, 143, 16);
		infoFix.getContentPane().add(nickOptionLabel);
		
		JLabel questionLabel = new JLabel("Question / 질문");
		questionLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", questionLabel.getFont().getStyle(), questionLabel.getFont().getSize()));
		questionLabel.setBounds(40, 375, 96, 16);
		infoFix.getContentPane().add(questionLabel);
		
		PWButton = new JButton("확인");
		PWButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", PWButton.getFont().getStyle(), PWButton.getFont().getSize()));
		PWButton.setBounds(317, 157, 95, 29);
		infoFix.getContentPane().add(PWButton);
		
		 nickButton = new JButton("확인");
		nickButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", nickButton.getFont().getStyle(), nickButton.getFont().getSize()));
		nickButton.setBounds(317, 210, 95, 29);
		infoFix.getContentPane().add(nickButton);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/KakaoTalk_Photo_2020-07-01-16-19-19.png"));
		lblNewLabel_1.setBounds(276, 395, 192, 139);
		infoFix.getContentPane().add(lblNewLabel_1);
		

		
		cancelButton.addActionListener(this);
		confirmButton.addActionListener(this);
		PWButton.addActionListener(this);
		nickButton.addActionListener(this);
		infoFix.setVisible(true);
	}

//	public static InfoFixFrame getInstance() {
//		if (instance == null)
//			instance = new InfoFixFrame(callingType);
//		if(isOff) {
//			instance = new InfoFixFrame(callingType);
//			isOff = false;
//		}
//		return instance;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// "중복 확인" "Cancel / 취소" "Confirm / 확인"
		
		 if(e.getSource().equals(PWButton)) {
			String checkTarget = PWBox.getText();
			if(checkTarget.length()<5) {
				PWButton.setText("너무 짧아요");
				if(checkTarget.length()==0)
					PWButton.setText("입력해줘여");
				PWBox.requestFocus();
			}
			else if(checkTarget.length()>12) {
				PWButton.setText("너무 길어오");
				PWBox.requestFocus();
			}
			else {
				PWButton.setText("사용 가능!");
				PWButton.setEnabled(false);
				PWBox.setEnabled(false);
			}
		}
		else if(e.getSource().equals(nickButton)) {
			System.out.println("중복 확인");
			System.out.println("is There the nick? : "+ DBConnection.getInstance().isThereNick(nicknameBox.getText()) );
			
			String checkTarget = nicknameBox.getText();

			if(checkTarget.length()<2) {
				nickButton.setText("너무 짧아요");
				if(checkTarget.length()==0)
					nickButton.setText("입력해줘여");
				nicknameBox.requestFocus();
			}
			else if(checkTarget.length()>30) {
				nickButton.setText("너무 길어오");
				nicknameBox.requestFocus();
			}
			else if(DBConnection.getInstance().isThereNick(nicknameBox.getText())) {
				if(nicknameBox.getText().equals(DBConnection.getInstance().getNowInfo().userNick)) {
					nickButton.setText("사용 가능!");
					nickButton.setEnabled(false);
					nicknameBox.setEnabled(false);
				}
				else {
					nicknameBox.requestFocus();
					nickButton.setText("있대요...");
				}
				
			}
			else {
				nickButton.setText("사용 가능!");
				nickButton.setEnabled(false);
				nicknameBox.setEnabled(false);
			}
		}
		else if(e.getActionCommand() == "Cancel / 취소") {
			System.out.println("Cancel / 취소");
			isOff= true;
			infoFix.dispose();
		}
		else if(e.getActionCommand()== "Confirm / 확인") {
			System.out.println("Confirm / 확인");
			
			if( PWButton.getText() != "사용 가능!") {
				PWBox.requestFocus();
				System.out.println("back PW");
			}
			else if( nickButton.getText() != "사용 가능!") {
				nicknameBox.requestFocus();
				System.out.println("back nick");
			}
			else if(phoneBox.getText().length()==0) {
				phoneBox.requestFocus();
				System.out.println("back phone");
			}
			else if(answerBox.getText().length()==0) {
				answerBox.requestFocus();
				System.out.println("back phone");
			}
			else {
				DBConnection.getInstance().changeInfo(new UserInfo(
						null,
						PWBox.getText(),
						nicknameBox.getText(),
						monthBox.getSelectedIndex()+1,
						dayBox.getSelectedIndex()+1,
						phoneBox.getText(),
						questionBox.getSelectedIndex()+1,
						answerBox.getText(),
						null));
				
				if(callingType == 1) {
					new MainFrame();
				}
				else if(callingType ==0) {
//					new MasterFrame();
				}
				
				new ClearPopup("정보 수정"); 
				infoFix.dispose();
			}
			
			
//			System.out.println(IDBox.getText());
//			System.out.println(PWBox.getText());
//			System.out.println(nicknameBox.getText());
//			System.out.println(monthBox.getSelectedIndex() + 1);
//			System.out.println(dayBox.getSelectedIndex() + 1);
//			System.out.println(phoneBox.getText());
//			System.out.println(questionBox.getSelectedIndex() + 1);
//			System.out.println(answerBox.getText());
			
		}
	}
}

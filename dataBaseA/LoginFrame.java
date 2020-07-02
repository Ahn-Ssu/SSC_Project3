package dataBaseA;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

public class LoginFrame extends JComponent implements ActionListener{

	private JFrame login = new JFrame("Log in / 로그인");
	private JTextField IDTextBox;
	private JPasswordField PWTextBox;
	private JButton loginButton;
	private JLabel IDCheckLabel;
	private JLabel PWCheckLabel;
	
	public LoginFrame()  {
		login.getContentPane().setBackground(Color.WHITE);
		login.getContentPane().setLayout(null);
		login.setSize(441, 314);
		login.setLocation(500, 250);

		login.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		IDTextBox = new JTextField();
		IDTextBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", IDTextBox.getFont().getStyle(), IDTextBox.getFont().getSize()));
		IDTextBox.setBounds(131, 141, 130, 26);
		login.getContentPane().add(IDTextBox);
		IDTextBox.setColumns(10);
		
		PWTextBox = new JPasswordField();
		PWTextBox.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", PWTextBox.getFont().getStyle(), PWTextBox.getFont().getSize()));
		PWTextBox.setColumns(10);
		PWTextBox.setBounds(131, 179, 130, 26);
		PWTextBox.setEchoChar('*');
		login.getContentPane().add(PWTextBox);
		
		JLabel IDLable = new JLabel("ID / 아이디");
		IDLable.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", IDLable.getFont().getStyle(), IDLable.getFont().getSize()));
		IDLable.setBounds(34, 144, 98, 22);
		login.getContentPane().add(IDLable);
		
		JLabel PWLabel = new JLabel("PW / 비밀번호");
		PWLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", PWLabel.getFont().getStyle(), PWLabel.getFont().getSize()));
		PWLabel.setBounds(34, 182, 98, 22);
		login.getContentPane().add(PWLabel);
		
		loginButton = new JButton("Log in / 로그인");
		loginButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", loginButton.getFont().getStyle(), loginButton.getFont().getSize()));
		loginButton.setBounds(273, 179, 129, 29);
		login.getContentPane().add(loginButton);
		
		JButton signinButton = new JButton("Sign in / 회원가입");
		signinButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", signinButton.getFont().getStyle(), signinButton.getFont().getSize()));
		signinButton.setBounds(273, 141, 129, 29);
		login.getContentPane().add(signinButton);
		
		JLabel titleLabel = new JLabel("안녕하세오 반가와오");
		titleLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", titleLabel.getFont().getStyle(), 20));
		titleLabel.setBounds(75, 53, 230, 42);
		login.getContentPane().add(titleLabel);
		
		JLabel catIcon = new JLabel("");
		catIcon.setIcon(new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/고양잉.png"));
		catIcon.setBounds(227, -19, 261, 217);
		login.getContentPane().add(catIcon);
		
		IDCheckLabel = new JLabel("아아디 확인해줘여");
		IDCheckLabel.setForeground(UIManager.getColor("CheckBox.select"));
		IDCheckLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", IDCheckLabel.getFont().getStyle(), 11));
		IDCheckLabel.setBounds(141, 165, 141, 16);
		IDCheckLabel.setVisible(false);
		login.getContentPane().add(IDCheckLabel);
		
		PWCheckLabel = new JLabel("비밀번호 확인해줘여");
		PWCheckLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", PWCheckLabel.getFont().getStyle(), 11));
		PWCheckLabel.setForeground(UIManager.getColor("Button.select"));
		PWCheckLabel.setBounds(141, 203, 141, 16);
		PWCheckLabel.setVisible(false);
		login.getContentPane().add(PWCheckLabel);
		
		login.setVisible(true);
		
		loginButton.addActionListener(this);
		signinButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Sign in / 회원가입") {
			System.out.println("Sign in / 회원가입");
			SigninFrame.getInstance(1);
		}
		else if( e.getSource().equals(loginButton)) {
			System.out.println("로그인");
			System.out.println(DBConnection.getInstance().isThereID(IDTextBox.getText()));
			// 1) 아이디 존재 여부 체크
			if(!DBConnection.getInstance().isThereID(IDTextBox.getText())) {
				IDTextBox.requestFocus();
				IDCheckLabel.setVisible(true);
				PWCheckLabel.setVisible(false);
			}
			else {
				// 아이디 정보가 있으면 저장된 정보 불러옴 
				DBConnection.getInstance().getUserInfo(IDTextBox.getText());
				
				System.out.println(PWTextBox.getText());
				
				//아이디랑 비밀번호가 매치가 안되면
				if(!DBConnection.getInstance().isRight(PWTextBox.getText())){
					IDCheckLabel.setVisible(false);
					PWTextBox.requestFocus();
					PWCheckLabel.setVisible(true);
				}
				else {
					System.out.println("Login!");
					if(IDTextBox.getText().equals("master")) {
						new MasterFrame();
					}
					else {
						new MainFrame();
					}
					
					
					new ClearPopup("로그인");
					login.dispose();
				}
			}
			
		}
		
	}
}

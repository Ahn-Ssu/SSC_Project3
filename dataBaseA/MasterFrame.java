package dataBaseA;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class MasterFrame extends JComponent implements ActionListener {

	private JFrame masterFrame;
	private UserInfo nowInfo = new UserInfo();
	private JMenuItem logout;
	private JMenuItem fixInfo;
	private JMenuItem exitAccount;
	private JTable showTable;
	private JButton userDeleteButton;
	private JButton userAddButton;
	private JButton infoFixButton;
	private JButton refresh;
	private JRadioButton brithDayRadioButton;
	private JRadioButton nicknameRadioButton;
	private JRadioButton IDRadioButton;
	private ButtonGroup group = new ButtonGroup();
	private JScrollPane scrollPane = new JScrollPane();

	private ArrayList<String[]> allData;
	private String[][] dataSet;
	private String[] header = { "userID", "userPW", "userNick", "userBrithDay", "userContact" };

	public MasterFrame() {
		nowInfo = DBConnection.getInstance().getNowInfo();

		masterFrame = new JFrame("관리자님 안녕요!");
		masterFrame.getContentPane().setBackground(Color.WHITE);
		masterFrame.getContentPane().setLayout(null);
		masterFrame.setVisible(true);
		masterFrame.setSize(650, 538);
		masterFrame.setLocation(300, 150);

		JLabel welcomeLabel = new JLabel("어서오세요 관리자님");
		welcomeLabel.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", welcomeLabel.getFont().getStyle(), 16));
		welcomeLabel.setBounds(376, 30, 270, 16);
		masterFrame.getContentPane().add(welcomeLabel);

		JLabel catIcom = new JLabel(" ");
		catIcom.setIcon(
				new ImageIcon("/Users/suhyun/eclipse-workspace/javaDB/KakaoTalk_Photo_2020-07-01-16-19-29.png"));
		catIcom.setBounds(515, 12, 131, 107);
		masterFrame.getContentPane().add(catIcom);

		scrollPane.setBounds(23, 120, 602, 354);
		masterFrame.getContentPane().add(scrollPane);
		callData(0);

		userDeleteButton = new JButton("유저 삭제");
		userDeleteButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", userDeleteButton.getFont().getStyle(),
				userDeleteButton.getFont().getSize()));
		userDeleteButton.setBounds(23, 79, 84, 29);
		masterFrame.getContentPane().add(userDeleteButton);

		userAddButton = new JButton("유저 추가");
		userAddButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", userDeleteButton.getFont().getStyle(),
				userDeleteButton.getFont().getSize()));
		userAddButton.setBounds(23, 38, 84, 29);
		masterFrame.getContentPane().add(userAddButton);

		infoFixButton = new JButton("유저 정보 변경");
		infoFixButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", userDeleteButton.getFont().getStyle(),
				userDeleteButton.getFont().getSize()));
		infoFixButton.setBounds(119, 38, 117, 29);
		masterFrame.getContentPane().add(infoFixButton);

		brithDayRadioButton = new JRadioButton("생일 기준");
		brithDayRadioButton
				.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", brithDayRadioButton.getFont().getStyle(), 11));
		brithDayRadioButton.setBounds(436, 81, 90, 23);
		masterFrame.getContentPane().add(brithDayRadioButton);

		nicknameRadioButton = new JRadioButton("닉네임 기준");
		nicknameRadioButton
				.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", brithDayRadioButton.getFont().getStyle(), 11));
		nicknameRadioButton.setBounds(342, 81, 184, 23);
		masterFrame.getContentPane().add(nicknameRadioButton);

		IDRadioButton = new JRadioButton("아이디 기준");
		IDRadioButton.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", brithDayRadioButton.getFont().getStyle(), 11));
		IDRadioButton.setBounds(248, 81, 278, 23);
		masterFrame.getContentPane().add(IDRadioButton);

		group.add(IDRadioButton);
		group.add(brithDayRadioButton);
		group.add(nicknameRadioButton);

		refresh = new JButton("정렬 및 최신화");
		refresh.setFont(
				new Font("DX\uACBD\uD544\uACE0\uB515B", refresh.getFont().getStyle(), refresh.getFont().getSize()));
		refresh.setBounds(119, 79, 116, 29);
		masterFrame.getContentPane().add(refresh);

		JMenuBar menuBar = new JMenuBar();
		masterFrame.setJMenuBar(menuBar);

		JMenu accountEdit = new JMenu("계정 관리 ");
		accountEdit.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", accountEdit.getFont().getStyle(),
				accountEdit.getFont().getSize()));
		menuBar.add(accountEdit);

		fixInfo = new JMenuItem("내 정보 수정");
		fixInfo.setEnabled(false);
		fixInfo.setFont(
				new Font("DX\uACBD\uD544\uACE0\uB515B", fixInfo.getFont().getStyle(), fixInfo.getFont().getSize()));
		accountEdit.add(fixInfo);

		logout = new JMenuItem("로그아웃");
		logout.setFont(
				new Font("DX\uACBD\uD544\uACE0\uB515B", logout.getFont().getStyle(), logout.getFont().getSize()));
		accountEdit.add(logout);

		exitAccount = new JMenuItem("회원 탈퇴");
		exitAccount.setEnabled(false);
		exitAccount.setForeground(UIManager.getColor("CheckBox.select"));
		exitAccount.setFont(new Font("DX\uACBD\uD544\uACE0\uB515B", exitAccount.getFont().getStyle(),
				exitAccount.getFont().getSize()));
		accountEdit.add(exitAccount);

//		fixInfo.addActionListener(this);
		logout.addActionListener(this);
		refresh.addActionListener(this);
		exitAccount.addActionListener(this);
		userDeleteButton.addActionListener(this);
		userAddButton.addActionListener(this);
		infoFixButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 선택하면 0 - n 까지 인덱스 리턴, 선택이 안되어 있으면 -1 리턴
		System.out.println(showTable.getSelectedRow());
		String selectedUserID;

		// 배열의 행이 선택 된 경우에만 버튼이 수행하게 처리
		if (showTable.getSelectedRow() > -1) {
			selectedUserID = dataSet[showTable.getSelectedRow()][0];
			System.out.println(selectedUserID);
		}

		if (e.getSource().equals(logout)) {
			new LoginFrame();
			new ClearPopup("로그아웃");
			masterFrame.dispose();
		} // userAddButton userDeleteButton permissonButton infoFixButton refresh

		else if (e.getSource().equals(userAddButton)) {
			SigninFrame.getInstance(0);
		} else if (e.getSource().equals(refresh)) { // 새로 불러오되, 라디오버튼이 선택 된 경우에정
			System.out.println(group.getSelection());

			if (group.getSelection() == null) {
				System.out.println("Default non-sort");
				callData(0);
			} else if (IDRadioButton.isSelected()) {
				System.out.println("ID SORT");
				callData(1);
			} else if (brithDayRadioButton.isSelected()) {
				System.out.println("BrithDay SORT");
				callData(2);
			} else if (nicknameRadioButton.isSelected()) {
				System.out.println("Nickname SORT");
				callData(3);
			}
			
			group.clearSelection();
			
		} else if (showTable.getSelectedRow() > -1) {

			selectedUserID = dataSet[showTable.getSelectedRow()][0];
			System.out.println(selectedUserID);
			DBConnection.getInstance().setUserID(selectedUserID);

			if (e.getSource().equals(userDeleteButton)) {
				new AskPopup(0);
			} else if (e.getSource().equals(infoFixButton)) {
				String selectedUserNick = dataSet[showTable.getSelectedRow()][2];
				DBConnection.getInstance().setUserNick(selectedUserNick);
				new InfoFixFrame(0);
			}
		}

//		else if(e.getSource().equals(exitAccount)) {
//			new AskPopup();
//			masterFrame.dispose();
//		}
//		else if(e.getSource().equals(fixInfo)) {
//			masterFrame.dispose();
//			new InfoFixFrame();
//		}

	}

	private void analyze() {
		dataSet = new String[allData.size()][5];
		int i = 0;

		for (String[] carrier : allData) {
			dataSet[i] = carrier;
			i++;
		}
	}

	private void callData(int readType) {
		if (readType == 0) {
			allData = new ArrayList<>(DBConnection.getInstance().fullRead());
		} 
		else if (readType == 1) {
			allData = new ArrayList<>(DBConnection.getInstance().IDOrderRead()); 
		}
		else if (readType == 2) {
			allData = new ArrayList<>(DBConnection.getInstance().dayOrderRead());
		}
		else if (readType == 3) {
			allData = new ArrayList<>(DBConnection.getInstance().nickOrderRead());
		}

		analyze();

		showTable = new JTable(dataSet, header);

		showTable.setFont(
				new Font("DX\uACBD\uD544\uACE0\uB515B", showTable.getFont().getStyle(), showTable.getFont().getSize()));
		scrollPane.setViewportView(showTable);

		DefaultTableModel model = new DefaultTableModel(dataSet, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		showTable.setModel(model);
		showTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}
}

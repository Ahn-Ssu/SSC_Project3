package dataBaseA;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

	private static DBConnection instance;
	
	public static DBConnection getInstance() {
		if(instance == null) 
			instance = new DBConnection();
		return instance;
	}
	
	private Connection con;
	private Statement statement;
	private ResultSet result;
	
	private UserInfo nowInfo = new UserInfo();
	private ArrayList<String []> allData = new ArrayList<>();
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userInfo", "root", "4851");
			statement = con.createStatement();
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 오류 : " + e.getMessage());
		}
		
		
	}
	
	public boolean isThereID(String targetID) {
		try {
			
			String SQL = "SELECT * FROM info WHERE userID='"+targetID+"'";
			result = statement.executeQuery(SQL);
			
			if(result.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("아이디 검색 오류 : " + e.getMessage());
		}
		return false;
	}
	
	public boolean isThereNick(String targetNick) {
		try {
			String SQL = "SELECT * FROM info WHERE userNick='"+targetNick+"'";
			result = statement.executeQuery(SQL);
			
			if(result.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("닉네임 검색 오류 : " + e.getMessage());
		}
		return false;
	}
//	INSERT INTO 테이블이름
//	   VALUES (데이터값1, 데이터값2, 데이터값3, ...)


	public void addNew(UserInfo userInfo) {
		
		try {
			String SQL = String.format("INSERT IGNORE INTO info values (\"%s\", \"%s\", \"%s\", %d, %d, \"%s\", %d, \"%s\", \"%s\")", 
					userInfo.userID,
					userInfo.userPW,
					userInfo.userNick,
					userInfo.userBMonth,
					userInfo.userBDay,
					userInfo.userContact,
					userInfo.userQuestion,
					userInfo.userAnswer,
					userInfo.userComment);
		 statement.executeUpdate(SQL);
			
		} catch (Exception e) {
			System.out.println("데이터베이스 추가 오류 : " + e.getMessage());
		}
	}
	
	public void getUserInfo(String TargetID) {
		try {
			String SQL = "SELECT * FROM info WHERE userID= '" +TargetID+ "'";
			result = statement.executeQuery(SQL);
			
			if(result.next()) {
				nowInfo.userID = TargetID;
				nowInfo.userPW = result.getString("userPW");
				nowInfo.userNick = result.getString("userNick");
				nowInfo.userBMonth = Integer.valueOf(result.getString("userBMonth"));
				nowInfo.userBDay = Integer.valueOf(result.getString("userBDay"));;
				nowInfo.userContact = result.getString("userContact");
				nowInfo.userQuestion = Integer.valueOf(result.getString("userQuestion"));;
				nowInfo.userAnswer = result.getString("userAnswer");
				nowInfo.userComment = result.getString("userComment");
			}
		} catch (Exception e) {
			System.out.println("정보 가져오기  오류 : " + e.getMessage());
		}

	}
	
	public boolean isRight(String targetPW) {
		return targetPW.equals(nowInfo.userPW);
	}

	public UserInfo getNowInfo() {
		return nowInfo;
	}
	
	public void changeInfo(UserInfo newInfo) {
		String IDtemp = nowInfo.userID;
		String CommentTemp = nowInfo.userComment;
		nowInfo = newInfo;
		nowInfo.userID = IDtemp;
		nowInfo.userComment = CommentTemp;
		
		//UPDATE sample SET name='HEEE', date='2019-04-26' WHERE no=2;
//		String SQL = String.format("INSERT IGNORE INTO info values (\"%s\", \"%s\", \"%s\", %d, %d, \"%s\", %d, \"%s\")", 

		try {
			String SQL = String.format("UPDATE info SET  userPW=\"%s\", userNick=\"%s\", userBMonth=%d,userBDay=%d, userContact=\"%s\", userQuestion=%d, userAnswer=\"%s\", userComment=\"%s\" where userID =\"%s\" ",
						nowInfo.userPW,
						nowInfo.userNick,
						nowInfo.userBMonth,
						nowInfo.userBDay,
						nowInfo.userContact,
						nowInfo.userQuestion,
						nowInfo.userAnswer,
						nowInfo.userComment,
						nowInfo.userID);
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("정보 수정하기 오류 : " + e.getMessage());
		}

	}
	
	public void setComment(String comment) {
		nowInfo.userComment = comment;
		
		try {
			String SQL = String.format("UPDATE info SET  userComment=\"%s\" where userID =\"%s\" ",
						nowInfo.userComment,
						nowInfo.userID);
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("정보 수정하기 오류 : " + e.getMessage());
		}
	}
	
	public void deleteUserInfo() {
		//delete from info where userID = '정슬구';
		
		try {
			String SQL = String.format("delete from info where userID = \"%s\"",nowInfo.userID);
			statement.executeUpdate(SQL);
		} catch (SQLException e) {
			System.out.println("정보 삭제 오류 : " + e.getMessage());
		}
		
		
	}
	
	public ArrayList<String[]> fullRead () {
		try {
			String SQL = "SELECT * FROM info";
			result = statement.executeQuery(SQL);
			allData.clear();
			
			while(result.next()) {
				String[] temp = new String[5];
				if(result.getString("userID").equals( "master"))
					continue;
				
				temp[0] = result.getString("userID");
				temp[1] = result.getString("userPW");
				temp[2] = result.getString("userNick");
				temp[3] = result.getString("userBMonth")+"월 "+result.getString("userBDay")+"일";
				temp[4] = result.getString("userContact");
//				temp[5] = ;
//				temp[6] = result.getString("userQuestion");
//				temp[7] = result.getString("userAnswer");
//				temp[8] = result.getString("userComment");
				
				allData.add(temp);
			}
		} catch (Exception e) {
			System.out.println("전체 정보 가져오기 오류 : " + e.getMessage());
		}
		
		return allData;
	}
	
	//for admin 
	public void setUserID(String targetID) {
		nowInfo.userID = targetID;
	}

	public void setUserNick(String selectedUserNick) {
		nowInfo.userNick = selectedUserNick;
		
	}
	//SELECT * FROM info ORDER BY userID;
	public ArrayList<String[]> IDOrderRead() {
		try {
			String SQL = "SELECT * FROM info ORDER BY userID";
			result = statement.executeQuery(SQL);
			allData.clear();
			
			while(result.next()) {
				String[] temp = new String[5];
				if(result.getString("userID").equals( "master"))
					continue;
				
				temp[0] = result.getString("userID");
				temp[1] = result.getString("userPW");
				temp[2] = result.getString("userNick");
				temp[3] = result.getString("userBMonth")+"월 "+result.getString("userBDay")+"일";
				temp[4] = result.getString("userContact");
//				temp[5] = ;
//				temp[6] = result.getString("userQuestion");
//				temp[7] = result.getString("userAnswer");
//				temp[8] = result.getString("userComment");
				
				allData.add(temp);
			}
		} catch (Exception e) {
			System.out.println("전체 정보 가져오기 오류 : " + e.getMessage());
		}
		
		return allData;
	}

	public ArrayList<String[]> dayOrderRead() {
		try {
			String SQL = "SELECT * FROM info ORDER BY userBMonth,userBDay";
			result = statement.executeQuery(SQL);
			allData.clear();
			
			while(result.next()) {
				String[] temp = new String[5];
				if(result.getString("userID").equals( "master"))
					continue;
				
				temp[0] = result.getString("userID");
				temp[1] = result.getString("userPW");
				temp[2] = result.getString("userNick");
				temp[3] = result.getString("userBMonth")+"월 "+result.getString("userBDay")+"일";
				temp[4] = result.getString("userContact");
//				temp[5] = ;
//				temp[6] = result.getString("userQuestion");
//				temp[7] = result.getString("userAnswer");
//				temp[8] = result.getString("userComment");
				
				allData.add(temp);
			}
		} catch (Exception e) {
			System.out.println("전체 정보 가져오기 오류 : " + e.getMessage());
		}
		
		return allData;
	}

	public ArrayList<String[]> nickOrderRead() {
		try {
			String SQL = "SELECT * FROM info ORDER BY userNick";
			result = statement.executeQuery(SQL);
			allData.clear();
			
			while(result.next()) {
				String[] temp = new String[5];
				if(result.getString("userID").equals( "master"))
					continue;
				
				temp[0] = result.getString("userID");
				temp[1] = result.getString("userPW");
				temp[2] = result.getString("userNick");
				temp[3] = result.getString("userBMonth")+"월 "+result.getString("userBDay")+"일";
				temp[4] = result.getString("userContact");
//				temp[5] = ;
//				temp[6] = result.getString("userQuestion");
//				temp[7] = result.getString("userAnswer");
//				temp[8] = result.getString("userComment");
				
				allData.add(temp);
			}
		} catch (Exception e) {
			System.out.println("전체 정보 가져오기 오류 : " + e.getMessage());
		}
		
		return allData;
	}
	
	
}

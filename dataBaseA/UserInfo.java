package dataBaseA;

public class UserInfo {

	String userID;
	String userPW;
	String userNick;
	int userBMonth;
	int userBDay;
	String userContact;
	int userQuestion;
	String userAnswer;
	String userComment;

	public UserInfo(String userID,
	  String userPW,
	  String userNick,
	  int userBMonth,
	  int userBDay,
	  String userContact,
	  int userQuestion,
	  String userAnswer, String userComment) {
	
		
		 this.userID = userID;
		 this.userPW =userPW;
		 this.userNick=userNick;
		 this.userBMonth=userBMonth;
		 this.userBDay=userBDay;
		 this.userContact=userContact;
		 this.userQuestion=userQuestion;
		 this.userAnswer=userAnswer;
		 this.userComment = userComment;
	}

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

}

package kr.or.ddit.user.model;

public class UserVo {
	private String userName;	//사용자 이름
	private String pass;		
	private String userId;
	
	//default 생성자
	public UserVo() {
		
	}
	
	public UserVo(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
}

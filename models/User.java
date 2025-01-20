package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private int userCode;
	private String userName;
	private Date userBirthday;
	private String userPhone;
	SimpleDateFormat parser=new SimpleDateFormat("DD/MM/yyyy");

	public User() {
		super();
	}

	public User(int userCode, String userName, Date userBirthday, String userPhone) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userBirthday = userBirthday;
		this.userPhone = userPhone;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		
		return "User [userCode=" + userCode + ", userName=" + userName + ", userBirthday=" + parser.format(userBirthday)
				+ ", userPhone=" + userPhone + "]";
	}

}

package users;

import java.util.Date;
import java.util.List;

import models.Book;
import models.User;

public class UserService {

	public static User createUser(int userCode, String userName, Date userBirthday, String userPhone) {
		User user = new User(userCode, userName, userBirthday, userPhone);
		return user;
	}

	public static User updateUser(int userCode, User user, List<User> listUser) {

		for (User itemUser : listUser) {
			if (itemUser.getUserCode() == userCode) {
				if (itemUser.getUserName() != null) {
					itemUser.setUserName(user.getUserName());
				}
				if (itemUser.getUserBirthday() != null) {
					itemUser.setUserBirthday(user.getUserBirthday());
				}
				if (itemUser.getUserPhone() != null) {
					itemUser.setUserPhone(user.getUserPhone());
				}
				return itemUser;
			}
		}

		return null;
	}

	public static Boolean deleteUser(int userCode, List<User> listUser) {
		int index = -1;
		for (int i = 0; i < listUser.size(); i++) {
			User itemUser = listUser.get(i);
			if (itemUser.getUserCode() == userCode) {
				index = i;
				break;
			}
		}
		if (index >= 0) {
			listUser.remove(index);
			return true;
		}

		return false;
	}
	
	public static User searchUser(int userCode, String name, List<User> listUser) {
		User user = null;
		for (int i = 0; i < listUser.size(); i++) {
			User itemUser = listUser.get(i);
			if (userCode > 0 && itemUser.getUserCode() == userCode) {
				user = itemUser;
				break;
			}
			if (name != null && !name.isEmpty() && itemUser.getUserName().equals(name)) {
				user = itemUser;
				break;
			}
		}

		return user;
	}

	public static void main(String[] args) {

	}

}

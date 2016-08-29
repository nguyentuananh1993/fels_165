package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;

public class UserBusinessImpl implements UserBusiness {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findByUserId(Integer user_id) throws Exception {
		try {
			return getUserDAO().findByUserId(user_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User findByUsername(String username) throws Exception {
		try {
			return getUserDAO().findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void signUp(User user) {
		try {
			getUserDAO().signUp(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User validateEmail(String email) throws Exception {
		try {
			return getUserDAO().validateEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User logIn(String username, String password) throws Exception {
		try {
			return getUserDAO().logIn(username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void editProfile(User user) throws Exception {
		try {
			getUserDAO().editProfile(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Override
	public List<User> listAllUsers() throws Exception {
		try {
			return getUserDAO().listAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<User> findByKeyWord (String key) throws Exception {
		try {
			return (List<User>) getUserDAO().findByKeyWord(key);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	@Override
	public boolean deleteUser(Integer user_id) throws Exception {
		try {
			return getUserDAO().deleteUser(user_id);	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean deleteAllUser() throws Exception {
		try {
			return getUserDAO().deleteAllUser();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		// TODO Auto-generated method stub
	}


}
package framgiavn.project01.web.business;

import framgiavn.project01.web.model.User;

public interface UserBusiness {
	
	public User findByUserId(Integer user_id) throws Exception;

	public User findByUsername(String username) throws Exception;
	
	public void signUp(User user) throws Exception;

	public User validateEmail(String email) throws Exception;

	public User logIn(String username, String password) throws Exception;

	public void editProfile(User user) throws Exception;
}
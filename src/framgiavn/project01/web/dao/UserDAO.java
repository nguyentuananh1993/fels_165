package framgiavn.project01.web.dao;

import java.util.List;

<<<<<<< 157a197d9eeb52fb4cdc4ecd57e3f92c84d05f90
import framgiavn.project01.web.model.Category;
=======

import framgiavn.project01.web.model.Category;

>>>>>>> Follow User
import framgiavn.project01.web.model.User;

public interface UserDAO {
	public User findByUserId(Integer user_id) throws Exception;

	public User findByUsername(String username) throws Exception;
	
	public void signUp(User user);

	public User validateEmail(String email) throws Exception;

	public User logIn(String username, String password) throws Exception;

	public void editProfile(User user);

	public List<User> listAllUsers() throws Exception;
	
	public boolean deleteUser(Integer user_id) throws Exception;
	
	public boolean deleteAllUser() throws Exception;


	public List<User> findByKeyWord(String key) throws Exception;

}
package framgiavn.project01.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import framgiavn.project01.web.business.ActivityBusiness;
import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.business.RelationshipBusiness;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.Relationship;
import framgiavn.project01.web.model.Category;

public class UserAction extends ActionSupport implements SessionAware, ServletContextAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private Logit2 log = Logit2.getInstance(UserAction.class);
	private UserBusiness userBusiness = null;
	private User user = null;
	private String passwordConfirm;
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String email;
	private String username;
	private String password;
	private String key;
	private RelationshipBusiness relationshipBusiness;
	private SessionMap<String, Object> session;
	private ServletContext context;
	private List<User> userList;
	private String isRelated = "false";
	private ActivityBusiness activityBusiness;
	private List<Activity> listActivity;
	private List<Category> listCategory = new ArrayList<Category>();
	private CategoryBusiness categoryBusiness;
	private LessonBusiness lessonBusiness;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public ActivityBusiness getActivityBusiness() {
		return activityBusiness;
	}

	public void setActivityBusiness(ActivityBusiness activityBusiness) {
		this.activityBusiness = activityBusiness;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public List<Activity> getListActivity() {
		return listActivity;
	}

	public void setListActivity(List<Activity> listActivity) {
		this.listActivity = listActivity;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public CategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}

	public void setCategoryBusiness(CategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public LessonBusiness getLessonBusiness() {
		return lessonBusiness;
	}

	public void setLessonBusiness(LessonBusiness lessonBusiness) {
		this.lessonBusiness = lessonBusiness;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public RelationshipBusiness getRelationshipBusiness() {
		return relationshipBusiness;
	}

	public void setRelationshipBusiness(RelationshipBusiness relationshipBusiness) {
		this.relationshipBusiness = relationshipBusiness;
	}

	public String isRelated() {
		return isRelated;
	}

	public void setRelated(String isRelated) {
		this.isRelated = isRelated;
	}
	
	public String findByUserId() {
		try {
			user = userBusiness.findByUserId(user.getUser_id());
			session.put("user_viewed", user.getUsername());
			User currentUser = (User) ActionContext.getContext().getSession().get("user");
			if(isRelated(currentUser.getUser_id(), user.getUser_id()))
				isRelated = "true";
			else
				isRelated = "false";
			session.put("isRelated", isRelated);
			listActivity = activityBusiness.showActivity(user.getUser_id());
			for (int i = 0; i < listActivity.size(); i++) {
				Activity a = listActivity.get(i);
				int category_id = lessonBusiness.getCategoryIdByLessonId(a.getTarget_id());
				Category c = categoryBusiness.findCategoryById(category_id);
				listCategory.add(i, c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String findByUsername() {
		try {
			user = userBusiness.findByUsername(user.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String signUp() {
		try {
			userBusiness.signUp(user);
			validateSignUp();
			user = userBusiness.findByUsername(user.getUsername());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public void validateSignUp() {
		if (user != null) {
			if (user.getEmail() == null || user.getEmail().trim().equals("")) {
				addFieldError("user.email", "Email is required");
			} else {
				User oldUser = null;
				try {
					oldUser = userBusiness.validateEmail(user.getEmail());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (oldUser != null) {
					addFieldError("user.email", "Email already exist.");
				}
			}
			if (user.getUsername() == null || user.getUsername().trim().equals("")) {
				addFieldError("user.username", "Username is required");
			} else {
				User oldUser = null;
				try {
					oldUser = userBusiness.findByUsername(user.getUsername());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (oldUser != null) {
					addFieldError("user.username", "Username already exist.");
				}
			}
			if (user.getPassword() == null || user.getPassword().trim().equals("")) {
				addFieldError("user.password", "Password can not be empty");
			} else if (user.getPassword().length() < 8) {
				addFieldError("user.password", "Password must have at least 8 characters");
			} else if (!user.getPassword().equals(this.passwordConfirm)) {
				addFieldError("passwordConfirm", "Password is not matched");
			}
		}
	}

	public String logIn() throws Exception {
		try {
			user = userBusiness.logIn(user.getUsername(), user.getPassword());
			if (user != null) {
				session.put("user", user);
				session.put("username", user.getUsername());
				session.put("user_viewed", user.getUsername());
				return SUCCESS;
			} else {
				System.out.println("ERROR1");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ERROR2");
		return ERROR;
	}

	public String signOut() {
		if (session != null) {
			session.invalidate();
		}
		return SUCCESS;
	}


	public String changePassword() throws Exception {
		if ((password == null) || (passwordConfirm == null)) {
			return ERROR;
		}
		if (password.length() < 8) {
			addFieldError("user.password", "Password must have at least 8 characters");
			return ERROR;
		} else if (!password.equals(passwordConfirm)) {
			addFieldError("passwordConfirm", "Password is not matched");
			return ERROR;
		}
		User user = (User) ActionContext.getContext().getSession().get("user");
		user.setPassword(password);
		userBusiness.editProfile(user);
		return SUCCESS;
	}

	public String editProfile() throws Exception {
		if ((username == null) || (email == null)) {
			user = (User) ActionContext.getContext().getSession().get("user");
			return ERROR;
		}
		try {
			User user = (User) ActionContext.getContext().getSession().get("user");
			System.out.println(user.getUsername());
			String destPath = context.getRealPath("/") + "images\\";
			System.out.println(destPath);
			String dest = user.getUser_id() + ".jpg";
			if (myFile != null) {
				File destFile = new File(destPath, dest);
				FileUtils.copyFile(myFile, destFile);
				user.setAvatar(destPath + user.getUser_id() + ".jpg");
			} else {
				System.out.println("Myfile == Null? Why?");
			}
			if (email.trim().equals(user.getEmail())) {
				;
			} else {
				user.setEmail(email);
			}
			if (username.trim().equals(user.getUsername())) {
				;
			} else {
				user.setUsername(username);
			}
			userBusiness.editProfile(user);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String showProfile() throws Exception {
		String name = (String) ActionContext.getContext().getSession().get("user_viewed");
		User currentUser = (User) ActionContext.getContext().getSession().get("user");
		User user_viewed = userBusiness.findByUsername(name);
		user = user_viewed;
		if(isRelated(currentUser.getUser_id(), user_viewed.getUser_id()))
			isRelated = "true";
		else
			isRelated = "false";
		session.put("isRelated", isRelated);
		try {
			listActivity = activityBusiness.showActivity(user.getUser_id());
			for (int i = 0; i < listActivity.size(); i++) {
				Activity a = listActivity.get(i);
				int category_id = lessonBusiness.getCategoryIdByLessonId(a.getTarget_id());
				Category c = categoryBusiness.findCategoryById(category_id);
				listCategory.add(i, c);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String showCurrentProfile() throws Exception {
		user = (User) ActionContext.getContext().getSession().get("user");

		session.put("username", user.getUsername());
		session.put("user_viewed", user.getUsername());
		try {
			listActivity = activityBusiness.showActivity(user.getUser_id());
			for (int i = 0; i < listActivity.size(); i++) {

				Activity a = listActivity.get(i);
				int category_id = lessonBusiness.getCategoryIdByLessonId(a.getTarget_id());
				Category c = categoryBusiness.findCategoryById(category_id);
				listCategory.add(i, c);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String findByKeyWord() {
		try {
			userList = userBusiness.findByKeyWord(this.key);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String createRelationship() {
		try {
			Relationship r = new Relationship();
			String name = (String) ActionContext.getContext().getSession().get("user_viewed");
			User currentUser = (User) ActionContext.getContext().getSession().get("user");
			User user_viewed = userBusiness.findByUsername(name);
			user = user_viewed;
			r.setFollower_id(currentUser.getUser_id());
			r.setFollowing_id(user_viewed.getUser_id());
			int relationship_id = relationshipBusiness.createRelationship(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String deleteRelationship() throws Exception {
		try {
			String name = (String) ActionContext.getContext().getSession().get("user_viewed");
			User currentUser = (User) ActionContext.getContext().getSession().get("user");
			User user_viewed = userBusiness.findByUsername(name);
			user = user_viewed;
			int follower_id = currentUser.getUser_id();
			int following_id = user_viewed.getUser_id();
			Relationship re = relationshipBusiness.deleteById(follower_id, following_id);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean isRelated(int follower_id, int following_id) throws Exception {
		Relationship re = relationshipBusiness.findRelationshipById(follower_id, following_id);
		if (re != null)
			return true;
		else
			return false;
	}

	public String homePage() {
		System.out.println("open homepage");
		return SUCCESS;
	}
	
	public String about() {
		System.out.println("about page");
		return SUCCESS;
	}


}
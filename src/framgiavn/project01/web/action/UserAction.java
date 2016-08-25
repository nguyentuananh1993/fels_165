package framgiavn.project01.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import framgiavn.project01.web.business.ActivityBusiness;
import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.Lesson;
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
	private SessionMap<String, Object> session;
	private ServletContext context;
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

	public String findByUserId() {
		try {
			user = userBusiness.findByUserId(user.getUser_id());
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
				return SUCCESS;
			} else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ERROR;
	}

	public String signOut() {
		if (session != null) {
			session.invalidate();
		}
		return SUCCESS;
	}

	public String editProfile() throws Exception {
		try {
			User user = (User) ActionContext.getContext().getSession().get("user");
			System.out.println(user.getUsername());
			String destPath = context.getRealPath("/") + "images\\";
			System.out.println(destPath);
			String dest = user.getUser_id() + ".jpg";
			File destFile = new File(destPath, dest);
			FileUtils.copyFile(myFile, destFile);
			user.setAvatar(destPath + user.getUser_id() + ".jpg");
			user.setEmail(email);
			user.setUsername(username);
			userBusiness.editProfile(user);
			validateSignUp();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String showProfile() {
		user = (User) ActionContext.getContext().getSession().get("user");
		try {
			listActivity = activityBusiness.showActivity(user.getUser_id());
			for(int i = 0; i < listActivity.size(); i++){
				Activity a = listActivity.get(i);
				int category_id = lessonBusiness.getCategoryIdByLessonId(a.getTarget_id());
				Category c = categoryBusiness.findCategoryById(category_id);
				listCategory.add(i, c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String homePage() {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return SUCCESS;
	}

}
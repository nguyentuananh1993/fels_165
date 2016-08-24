package framgiavn.project01.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;

public class AdminAction extends ActivityAction implements SessionAware, ServletContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserBusiness userBusiness = null;
	private ServletContext context;
	private List<User> listUsers;
	private SessionMap<String, Object> session;
	private User user;
	
	public String execute(){
	   return ERROR;
	}
	
	public List<User> getListUsers() {
		return listUsers;
	}
	
	public void userLogIn() {
		
	}
	
	public void userLogOut() {
		
	}
	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}
	@Override
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	public SessionMap<String, Object> getSession() {
		return session;
	}
	
	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}
	
	private boolean checkLogIn() {
		User userLogin = (User)ActionContext.getContext().getSession().get("user");
		if(userLogin != null && userLogin.getIsAdmin()) {
			return true;
		}
		return false;
	}
	
	public String adminLogIn() {
		try {
			User loginUser = userBusiness.logIn(user.getUsername(), user.getPassword());
			if (loginUser != null && loginUser.getIsAdmin()) {
				session.put("user", loginUser);
				return SUCCESS;
			} else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("admin login");
		return ERROR;
	}
	
	public String adminUserList() throws Exception {
		if (!checkLogIn()) {
			return ERROR;
		}
		
		try {
			setListUsers(userBusiness.listAllUsers());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String adminHomePage() {
		if (!checkLogIn()) {
			return ERROR;
		}
		System.out.println("admin home page");
		return SUCCESS;
	}
	public String adminDeleteUser() {
		try {
			if (userBusiness.deleteUser(user.getUser_id())) {
				return "finish";
			}
			return ERROR;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}

	public String adminDeleteAll() {
		try {
			if (userBusiness.deleteAllUser()) {
				return "finish";
			}
			return ERROR;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}


}

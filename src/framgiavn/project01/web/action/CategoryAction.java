package framgiavn.project01.web.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.ServletContext;
import org.springframework.web.context.ServletContextAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.UserBusiness;

public class CategoryAction extends ActionSupport implements SessionAware, ServletContextAware{
	
	private ServletContext context;
	private UserBusiness userBusiness = null;
	private static final long serialVersionUID = 1L;
	private Category category;
	private CategoryBusiness categoryBusiness;
	private CategoryAction categoryAction;
	private List<Category> listCategory;
	private SessionMap<String, Object> session;
	private User user;
	
	public User getUser() {
		return user;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryAction getCategoryAction() {
		return categoryAction;
	}

	public void setCategoryAction(CategoryAction categoryAction) {
		this.categoryAction = categoryAction;
	}
	
	private boolean checkLogIn() {
		User userLogin = (User)ActionContext.getContext().getSession().get("user");
		if(userLogin != null && userLogin.getIsAdmin()) {
			return true;
		}
		return false;
	}
	
	public void setUser(User user) {
		this.user = user;
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
	
 	public String listAllCategory() throws Exception {
		try {
			listCategory = categoryBusiness.listAllCategory();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
 	
 	public String adminCategoryList() throws Exception {
		if (!checkLogIn()) {
			return ERROR;
		}
 		return listAllCategory();
 	}
 	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.context = arg0;
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
	
	public String adminCategoryEdit() {
		if (!checkLogIn()) {
			return ERROR;
		}
		
		try {
			category = categoryBusiness.findCategoryById(category.getCategory_id());
			return SUCCESS;
		}catch(Exception e ) {
			return ERROR;
		}
		
	}
	
	public String actionAdminCategoryEdit() {
		if (!checkLogIn()) {
			return ERROR;
		}
		
		try {
			Date date = new Date();
			category.setUpdated_at(date);
			categoryBusiness.editCategory(category);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String adminCategoryDelete() {
		if (!checkLogIn()) {
			return ERROR;
		}
		
		try {
			if(categoryBusiness.deleteCategoryById(category.getCategory_id())) {
				return "finish";
			}
			return ERROR;
		}catch (Exception e) {
			return ERROR;
		}
	}
	
	public String adminCategoryAdd() {
		if (!checkLogIn()) {
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String actionAdminCategoryAdd() {
		if (!checkLogIn()) {
			return ERROR;
		}
		
		try {
			categoryBusiness.addCategory(category);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String adminCategoryDeleteAll() {
		if (!checkLogIn()) {
			return ERROR;
		}
		
		try {
			categoryBusiness.deleteAllCategory();
			return "finish";
		} catch (Exception e) {
			return ERROR;
		}
	}
}

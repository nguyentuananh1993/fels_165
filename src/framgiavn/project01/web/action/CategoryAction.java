package framgiavn.project01.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.business.CategoryBusiness;

public class CategoryAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	private CategoryBusiness categoryBusiness;
	private CategoryAction category;
	private List<Category> listCategory;
	private SessionMap<String, Object> session;
	public CategoryAction getCategory() {
		return category;
	}
	public void setCategory(CategoryAction category) {
		this.category = category;
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
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) arg0;
	}

}

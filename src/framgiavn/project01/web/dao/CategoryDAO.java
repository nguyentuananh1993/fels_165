package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Category;

public interface CategoryDAO {

	public int findCategoryIdByName(String name) throws Exception;

	public List<Category> listAllCategory() throws Exception;
	
	public Category findCategoryById(Integer category_id) throws Exception;
	
	public void editCategory(Category category) throws Exception;
	
	public boolean deleteCategoryById(Integer category_id) throws Exception;
	
	public boolean deleteAllCategory() throws Exception;
	
	public void addCategory(Category category) throws Exception;
	
}

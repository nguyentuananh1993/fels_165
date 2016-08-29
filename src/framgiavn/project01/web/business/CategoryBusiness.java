package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Category;

public interface CategoryBusiness {

	public List<Category> listAllCategory() throws Exception;

	public int findCategoryIdByName(String name) throws Exception;
	public Category findCategoryById(Integer category_id) throws Exception;
	public void editCategory(Category category) throws Exception;
	public boolean deleteCategoryById(Integer category_id) throws Exception;
	public boolean deleteAllCategory() throws Exception;
	void addCategory(Category category) throws Exception;
	

}

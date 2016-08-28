package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Category;

public interface CategoryBusiness {

	public List<Category> listAllCategory() throws Exception;

	public int findCategoryIdByName(String name) throws Exception;

	public Category findCategoryById(int category_id) throws Exception;

}

package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.Category;

public interface CategoryDAO {

	public int findCategoryIdByName(String name) throws Exception;

	public List<Category> listAllCategory() throws Exception;

	public Category findCategoryById(int category_id) throws Exception;

}

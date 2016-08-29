package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.model.Category;

public class CategoryBusinessImpl implements CategoryBusiness {
	
	private CategoryDAO categoryDAO;

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public List<Category> listAllCategory() throws Exception{
		try {
			return categoryDAO.listAllCategory();
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public int findCategoryIdByName(String name) throws Exception{
		try {
			return categoryDAO.findCategoryIdByName(name);
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Category findCategoryById(int category_id) throws Exception{
		try {
			return categoryDAO.findCategoryById(category_id);
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}

}

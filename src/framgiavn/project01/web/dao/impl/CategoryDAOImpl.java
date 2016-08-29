package framgiavn.project01.web.dao.impl;


import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.ulti.Logit2;

public class CategoryDAOImpl extends HibernateDaoSupport implements CategoryDAO {
	private static final Logit2 log = Logit2.getInstance(CategoryDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public int findCategoryIdByName(String name) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Category.SelectCategoryByName");
			query.setParameter("name", name);
			Category category = (Category) query.uniqueResult();
			return category.getCategory_id();
		} catch (RuntimeException re) {
			log.error ("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<Category> listAllCategory() throws Exception {
		try {
			Query query = getSession().getNamedQuery("Category.SelectAll");
			return (List<Category>) query.list();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public Category findCategoryById(int category_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Category.SelectCategoryById");
			query.setParameter("category_id", category_id);
			Category category = (Category) query.uniqueResult();
			return category;
		} catch (RuntimeException re) {
			log.error ("get failed", re);
			throw re;
		}
	}

	@Override
	public void editCategory(Category category) throws Exception {
		getHibernateTemplate().update(category);
	}

	@Override
	public boolean deleteCategoryById(Integer category_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Category.findById");
			query.setParameter("category_id", category_id);
			Category category = (Category)query.uniqueResult();
			getSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAllCategory() throws Exception {
		try {
			Query query = getSession().getNamedQuery("Category.listAllCategory");
			List<Category> categories = (List<Category>) query.list();
			for(Category category : categories) {
				getSession().delete(category);
			}
			System.out.println("in dellete all category");
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void addCategory(Category category) throws Exception {
		getHibernateTemplate().save(category);
	}
}

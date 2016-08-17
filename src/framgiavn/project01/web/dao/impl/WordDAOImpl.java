package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.dao.WordDAO;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.ulti.Logit2;

public class WordDAOImpl extends HibernateDaoSupport implements WordDAO {
	private static final Logit2 log = Logit2.getInstance(WordDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public List<Word> wordFilterByCategory(String name) throws Exception {
		try {
			CategoryDAO categoryDAO = null;
			int category_id = categoryDAO.findCategoryIdByName(name);
			Query query = getSession().getNamedQuery("Word.SelectWordByCategoryId");
			query.setParameter("category_id", category_id);
			return (List<Word>) query.list();
		} catch (Exception e) {
			log.error("Filter by category failed", e);
			throw e;
		}
	}

	@Override
	public List<Word> wordFilterByLearnedWord() {
		return null;

	}

	@Override
	public List<Word> wordFilterByNotLearnedWord() {
		return null;

	}

	@Override
	public List<Word> showAllWord() {
		return null;

	}

}

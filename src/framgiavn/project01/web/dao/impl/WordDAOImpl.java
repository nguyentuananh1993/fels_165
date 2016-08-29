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
	public List<Word> wordFilterByCategory(int category_id) throws Exception {
		try {
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
	public List<Word> listAllWord() throws Exception {
		try {
			Query query = getSession().getNamedQuery("Word.listAllWord");
			return (List<Word>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Word findById(Integer word_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Word.findById");
			query.setParameter("word_id", word_id);
			return (Word) query.uniqueResult();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Word editWord(Word word) throws Exception {
		getHibernateTemplate().update(word);
		return null;
	}

	@Override
	public boolean deleteWordById(Integer word_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Word.findById");
			query.setParameter("word_id", word_id);
			Word word = (Word)query.uniqueResult();
			getSession().delete(word);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAllWord() throws Exception {
		try {
			Query query = getSession().getNamedQuery("Word.listAllWord");
			List<Word> words = (List<Word>)query.list();
			for(Word word : words) {
				getSession().delete(word);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void addWord(Word word) throws Exception {
		getHibernateTemplate().save(word);
	}
}

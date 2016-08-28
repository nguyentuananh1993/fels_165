package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.WordAnswerDAO;
import framgiavn.project01.web.model.WordAnswer;
import framgiavn.project01.web.ulti.Logit2;

public class WordAnswerDAOImpl extends HibernateDaoSupport implements WordAnswerDAO{

	private static final Logit2 log = Logit2.getInstance(WordAnswerDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public WordAnswer selectCorrectAnswer(int word_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("WordAnswer.SelectCorrectAnswer");
			query.setParameter("word_id", word_id);
			return (WordAnswer) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<WordAnswer> getWordAnswerByWordId(int word_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("WordAnswer.SelectWordAnswerByWordId");
			query.setParameter("word_id", word_id);
			List<WordAnswer> list = (List<WordAnswer>) query.list();
			return (List<WordAnswer>) query.list();
		} catch (RuntimeException e) {
			log.error("Get word answer by word_id failed", e);
			throw e;
		}
	}
}

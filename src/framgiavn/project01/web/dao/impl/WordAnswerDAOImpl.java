package framgiavn.project01.web.dao.impl;


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
}

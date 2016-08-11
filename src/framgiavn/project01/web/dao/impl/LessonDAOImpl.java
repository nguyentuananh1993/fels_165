package framgiavn.project01.web.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.LessonDAO;
import framgiavn.project01.web.ulti.Logit2;

public class LessonDAOImpl extends HibernateDaoSupport implements LessonDAO {
	
	private static final Logit2 log = Logit2.getInstance(LessonDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

}

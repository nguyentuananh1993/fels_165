package framgiavn.project01.web.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.LessonWordDAO;
import framgiavn.project01.web.ulti.Logit2;

public class LessonWordDAOImpl extends HibernateDaoSupport implements LessonWordDAO {
	private static final Logit2 log = Logit2.getInstance(LessonWordDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

}

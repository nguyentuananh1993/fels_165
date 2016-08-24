package framgiavn.project01.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.LessonDAO;
import framgiavn.project01.web.model.Lesson;
import framgiavn.project01.web.ulti.Logit2;
import net.sf.ehcache.hibernate.HibernateUtil;

public class LessonDAOImpl extends HibernateDaoSupport implements LessonDAO {
	
	private static final Logit2 log = Logit2.getInstance(LessonDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	public int saveLesson(Lesson lesson){
		int id = 0;
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(lesson);
			id = lesson.getLesson_id();
			trans.commit();
		} catch(HibernateException he) {
			
		}
		return id;
	}
}

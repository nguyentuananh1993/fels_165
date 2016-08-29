package framgiavn.project01.web.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.ActivityDAO;
import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.ulti.Logit2;

public class ActivityDAOImpl extends HibernateDaoSupport implements ActivityDAO {
	private static final Logit2 log = Logit2.getInstance(ActivityDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}
	@Override
	public void saveActivity(Activity activity) {
		getHibernateTemplate().save(activity);
	}
	
	@Override
	public List<Activity> showActivity(int user_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Activity.selectActivityByUserId");
			query.setParameter("user_id", user_id);
			return (List<Activity>) query.list();
		} catch (RuntimeException re) {
			log.error("Get failed", re);
			throw re;
		}
	}
}

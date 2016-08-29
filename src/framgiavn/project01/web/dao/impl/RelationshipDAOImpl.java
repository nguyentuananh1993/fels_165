package framgiavn.project01.web.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.RelationshipDAO;
import framgiavn.project01.web.model.Relationship;
import framgiavn.project01.web.ulti.Logit2;

public class RelationshipDAOImpl extends HibernateDaoSupport implements RelationshipDAO {
	private static final Logit2 log = Logit2.getInstance(RelationshipDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public int createRelationship(Relationship relationship) {
		int id = 0;
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		try {
			session.save(relationship);
			id = relationship.getRelationship_id();
			trans.commit();
		} catch (HibernateException he) {

		}
		return id;
	}

	@Override
	public Relationship deleteRelationshipById(int follower_id, int following_id) throws Exception {
		try {
		Query query = getSession().getNamedQuery("Relationship.SelectById");
		query.setParameter("follower_id", follower_id);
		query.setParameter("following_id", following_id);
		Relationship re = (Relationship) query.uniqueResult();
		if (re != null) {
			getHibernateTemplate().delete(re);
		}
		return re;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public Relationship findRelationshipById(int follower_id, int following_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Relationship.SelectById");
			query.setParameter("follower_id", follower_id);
			query.setParameter("following_id", following_id);
			Relationship re = (Relationship) query.uniqueResult();
			return re;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

package framgiavn.project01.web.dao.impl;

import java.util.List;

//import org.apache.activemq.transaction.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Transaction;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Logit2;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	public static final String NAME = "customerName";

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public User findByUserId(Integer user_id) throws Exception {
		return findByUserId(user_id, false);
	}

	public User findByUserId(Integer user_id, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByUserId");
			if (lock)
				query.setLockMode("User", LockMode.UPGRADE);
			query.setParameter("user_id", user_id);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public User findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByUsername");
			query.setParameter("username", username);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void signUp(User user) {
		user.setAvatar("/images/default-avatar.jpg");
		getHibernateTemplate().save(user);
		
	}

	@Override
	public User validateEmail(String email) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByEmail");
			query.setParameter("email", email);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public User logIn(String username, String password) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.LogIn");
			query.setParameter("username", username);
			query.setParameter("password", password);
			return (User) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public void editProfile(User user) {
		user.setAvatar("/images/"+user.getUser_id()+".jpg");
		getHibernateTemplate().update(user);
	}

	@Override
	public List<User> listAllUsers() throws Exception {
		try {
			System.out.println("helloworld from list all user");
			Query query = getSession().getNamedQuery("User.SelectAll");
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			return list;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	@Override
	public List<User> findByKeyWord (String key) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.SelectUserByKeyWord");
			query.setParameter("key", '%'+key+'%');
			return (List<User>) query.list();

		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}



	@Override
	public boolean deleteUser(Integer user_id) throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.DeleteByUserId");
			query.setParameter("user_id", user_id);
			User deleteUser = (User)query.list().get(0);
			getSession().delete(deleteUser);
			return true;
		} catch(RuntimeException re) {
			throw re;
		}
	}

	@Override
	public boolean deleteAllUser() throws Exception {
		try {
			Query query = getSession().getNamedQuery("User.DeleteAllUser");
			query.setParameter("is_admin", false);
			@SuppressWarnings("unchecked")
			List<User> deleteUsers = (List<User>)query.list();
			for (User deleteUser : deleteUsers){
				getSession().delete(deleteUser);
			}
			return true;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
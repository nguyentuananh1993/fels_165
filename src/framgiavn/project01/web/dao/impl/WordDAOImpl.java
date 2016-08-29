package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;

import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.dao.WordDAO;
import framgiavn.project01.web.model.User;
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
			System.out.println("Size : "+ query.list().size());
			return (List<Word>) query.list();
		} catch (Exception e) {
			log.error("Filter by category failed", e);
			throw e;
		}
	}

	@Override
	public List<Word> wordFilterByLearnedWord(int category_id){
		try {
			String hql = "select distinct word from Word word"
						+" where word.category_id  = :category_id and word.word_id in (select distinct lessonword.word_id from LessonWord lessonword"
						+" where lessonword.lesson_word_id in (select distinct lesson.lesson_id from Lesson lesson where lesson.user_id= :user_id))";
			Query query;
			User user = (User) ActionContext.getContext().getSession().get("user");
			System.out.println("Query :" + hql);
			
			query = getSession().createQuery(hql).setParameter("category_id", category_id).setParameter("user_id", user.getUser_id());
			System.out.println("User_id current: "+ user.getUser_id());
			System.out.println("Category"+ category_id);
			System.out.println("Query 1:" + hql);
			System.out.println("Size : "+ query.list().size());
			return (List<Word>) query.list();
		} catch (Exception e) {
			log.error("Filter by category failed", e);
			throw e;
		}
	}

	@Override
	public List<Word> wordFilterByNotLearnedWord(int category_id) {
		try {
			String hql = "select distinct word from Word word"
						+" where word.category_id  = :category_id and word.word_id not in (select distinct lessonword.word_id from LessonWord lessonword"
						+" where lessonword.lesson_word_id in (select distinct lesson.lesson_id from Lesson lesson where lesson.user_id= :user_id))";
			Query query;
			User user = (User) ActionContext.getContext().getSession().get("user");
			System.out.println("Query :" + hql);
			
			query = getSession().createQuery(hql).setParameter("category_id", category_id).setParameter("user_id", user.getUser_id());
			System.out.println("User_id current: "+ user.getUser_id());
			System.out.println("Category"+ category_id);
			System.out.println("Query 1:" + hql);
			System.out.println("Size : "+ query.list().size());
			return (List<Word>) query.list();
		} catch (Exception e) {
			log.error("Filter by category failed", e);
			throw e;
		}

	}

	@Override
	public List<Word> showAllWord() {
		return null;

	}

}

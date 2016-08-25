package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.dao.LessonDAO;
import framgiavn.project01.web.model.Lesson;

public class LessonBusinessImpl implements LessonBusiness {
	private LessonDAO lessonDAO;

	public LessonDAO getLessonDAO() {
		return lessonDAO;
	}

	public void setLessonDAO(LessonDAO lessonDAO) {
		this.lessonDAO = lessonDAO;
	}

	@Override
	public int saveLesson(Lesson lesson) throws Exception {
		int id = 0;
		try {
			id = lessonDAO.saveLesson(lesson);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return id;
	}

	@Override
	public int getCategoryIdByLessonId(int lesson_id) throws Exception{
		try {
			return lessonDAO.getCategoryIdByLessonId(lesson_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}

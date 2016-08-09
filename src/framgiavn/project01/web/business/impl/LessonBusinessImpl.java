package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.dao.LessonDAO;

public class LessonBusinessImpl implements LessonBusiness {
	private LessonDAO lessonDAO;

	public LessonDAO getLessonDAO() {
		return lessonDAO;
	}

	public void setLessonDAO(LessonDAO lessonDAO) {
		this.lessonDAO = lessonDAO;
	}

}

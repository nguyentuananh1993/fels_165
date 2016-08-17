package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.LessonWordBusiness;
import framgiavn.project01.web.dao.LessonWordDAO;

public class LessonWordBusinessImpl implements LessonWordBusiness{
	private LessonWordDAO lessonWordDAO;

	public LessonWordDAO getLessonWordDAO() {
		return lessonWordDAO;
	}

	public void setLessonWordDAO(LessonWordDAO lessonWordDAO) {
		this.lessonWordDAO = lessonWordDAO;
	}

}

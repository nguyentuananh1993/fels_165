package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.LessonWordBusiness;
import framgiavn.project01.web.dao.LessonWordDAO;
import framgiavn.project01.web.model.Lesson;
import framgiavn.project01.web.model.LessonWord;

public class LessonWordBusinessImpl implements LessonWordBusiness{
	private LessonWordDAO lessonWordDAO;

	public LessonWordDAO getLessonWordDAO() {
		return lessonWordDAO;
	}

	public void setLessonWordDAO(LessonWordDAO lessonWordDAO) {
		this.lessonWordDAO = lessonWordDAO;
	}

	@Override
	public void saveLessonWord(LessonWord lessonWord) throws Exception{
		try{
		lessonWordDAO.saveLessonWord(lessonWord);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

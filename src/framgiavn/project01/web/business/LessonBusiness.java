package framgiavn.project01.web.business;

import framgiavn.project01.web.model.Lesson;

public interface LessonBusiness {

	public int saveLesson(Lesson lesson) throws Exception;

	public int getCategoryIdByLessonId(int lesson_id) throws Exception;

}

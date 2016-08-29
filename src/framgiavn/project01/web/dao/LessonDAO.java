package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.Lesson;

public interface LessonDAO {
	public int saveLesson(Lesson lesson);

	public int getCategoryIdByLessonId(int lesson_id) throws Exception;

}

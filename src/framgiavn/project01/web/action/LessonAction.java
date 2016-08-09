package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.model.Lesson;

public class LessonAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private LessonBusiness lessonBusiness = null;
	private Lesson lesson = null;
	public LessonBusiness getLessonBusiness() {
		return lessonBusiness;
	}
	public void setLessonBusiness(LessonBusiness lessonBusiness) {
		this.lessonBusiness = lessonBusiness;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
}

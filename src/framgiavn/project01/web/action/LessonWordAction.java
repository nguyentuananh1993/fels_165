package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.LessonWordBusiness;
import framgiavn.project01.web.model.LessonWord;

public class LessonWordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private LessonWordBusiness lessonWordBusiness = null;
	private LessonWord lessonWord = null;
	
	public LessonWordBusiness getLessonWordBusiness() {
		return lessonWordBusiness;
	}
	public void setLessonWordBusiness(LessonWordBusiness lessonWordBusiness) {
		this.lessonWordBusiness = lessonWordBusiness;
	}
	public LessonWord getLessonWord() {
		return lessonWord;
	}
	public void setLessonWord(LessonWord lessonWord) {
		this.lessonWord = lessonWord;
	}
}

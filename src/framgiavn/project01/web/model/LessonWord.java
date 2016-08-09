package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;

public class LessonWord implements Serializable {
	private static final long serialVersionUID = 1L;

	private int lesson_word_id;
	private int lesson_id;
	private int word_id;
	private int word_answer_id;
	private Date created_at;
	private Date updated_at;

	public int getLesson_word_id() {
		return lesson_word_id;
	}
	public void setLesson_word_id(int lesson_word_id) {
		this.lesson_word_id = lesson_word_id;
	}
	public int getLesson_id() {
		return lesson_id;
	}
	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}
	public int getWord_id() {
		return word_id;
	}
	public void setWord_id(int word_id) {
		this.word_id = word_id;
	}
	public int getWord_answer_id() {
		return word_answer_id;
	}
	public void setWord_answer_id(int word_answer_id) {
		this.word_answer_id = word_answer_id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}

package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.iterators.EntrySetMapIterator;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.ActivityBusiness;
import framgiavn.project01.web.business.LessonBusiness;
import framgiavn.project01.web.business.LessonWordBusiness;
import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.Lesson;
import framgiavn.project01.web.model.LessonWord;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public class LessonAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private LessonBusiness lessonBusiness = null;
	private Lesson lesson = new Lesson();
	private WordBusiness wordBusiness = null;
	private WordAnswerBusiness wordAnswerBusiness = null;
	private SessionMap<String, Object> session = null;
	private int count = 0;
	private Word word = null;
	private List<WordAnswer> listAnswer = null;
	private int category_id;
	private WordAnswer answer = null;
	private List<Word> question = new ArrayList<Word>();
	private List<WordAnswer> choice = new ArrayList<WordAnswer>();
	private List<Boolean> result = new ArrayList<Boolean>();
	private LessonWordBusiness lessonWordBusiness = null;
	private ActivityBusiness activityBusiness = null;
	
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

	public WordBusiness getWordBusiness() {
		return wordBusiness;
	}

	public void setWordBusiness(WordBusiness wordBusiness) {
		this.wordBusiness = wordBusiness;
	}

	public WordAnswerBusiness getWordAnswerBusiness() {
		return wordAnswerBusiness;
	}

	public void setWordAnswerBusiness(WordAnswerBusiness wordAnswerBusiness) {
		this.wordAnswerBusiness = wordAnswerBusiness;
	}

	public SessionMap<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public List<WordAnswer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<WordAnswer> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public WordAnswer getAnswer() {
		return answer;
	}

	public void setAnswer(WordAnswer answer) {
		this.answer = answer;
	}

	public List<Word> getQuestion() {
		return question;
	}

	public void setQuestion(List<Word> question) {
		this.question = question;
	}

	public List<WordAnswer> getChoice() {
		return choice;
	}

	public void setChoice(List<WordAnswer> choice) {
		this.choice = choice;
	}

	public List<Boolean> getResult() {
		return result;
	}

	public void setResult(List<Boolean> result) {
		this.result = result;
	}

	public LessonWordBusiness getLessonWordBusiness() {
		return lessonWordBusiness;
	}

	public void setLessonWordBusiness(LessonWordBusiness lessonWordBusiness) {
		this.lessonWordBusiness = lessonWordBusiness;
	}

	public ActivityBusiness getActivityBusiness() {
		return activityBusiness;
	}

	public void setActivityBusiness(ActivityBusiness activityBusiness) {
		this.activityBusiness = activityBusiness;
	}


	public String learnLesson() {
		category_id = getCategory_id();
		session.put("category_id", category_id);
		System.out.println("anhnt debugger");
		try {
			List<Word> wordList = null;
			if (session.get("count") == null) {
				session.put("count", count);
			}
			if(session.get("question") == null) {
				session.put("question", question);
			}
			if(session.get("choice") == null) {
				session.put("choice", choice);
			}
			if(session.get("result") == null) {
				session.put("result", result);
			}
			System.out.println("hello" + (Integer) session.get("count"));
			count = (int) session.get("count");
			if (count % 20 == 0) {
				wordList = this.wordBusiness.initWordList((int) session.get("category_id"));
				User user = (User) session.get("user");
				session.put("wordList", wordList);
			}
			wordList = ((List<Word>) session.get("wordList"));
			this.word = wordList.get(count % 20);
			question = (List<Word>) session.get("question");
			question.add(word);
			session.put("question", question);
			this.listAnswer = wordAnswerBusiness.getWordAnswerByWordId(this.word.getWord_id());
			
			WordAnswer correctAnswer = null;
			
			if(answer != null && answer.getWord_id() != 0){
				correctAnswer = wordAnswerBusiness.selectCorrectAnswer(answer.getWord_id());
				choice = (List<WordAnswer>) session.get("choice");
				choice.add(answer);
				session.put("answer", answer);
			}
			if (correctAnswer != null && correctAnswer.getWord_answer_id() == answer.getWord_answer_id()) {
				result = (List<Boolean>) session.get("result");
				result.add(true);
				session.put("result", result);
			}
			else {
				List<Boolean> result = (List<Boolean>) session.get("result");
				result.add(false);
				session.put("result", result);
			}
			if(count % 20 == 0 && count != 0){
				return "finish";
			}
			count++;
			session.put("count", count);
			session.put("word", this.word);
			session.put("listAnswer", this.listAnswer);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String endLearning() {
		try {
			question = (List<Word>) session.get("question");
			choice = (List<WordAnswer>) session.get("choice");
			result = (List<Boolean>) session.get("result");
			int n = (int)session.get("category_id");
			this.setCategory_id(n);
			category_id = n;
/*			int res = 0;
			for(int i = 0; i < result.size(); i++){
				if(result.get(i) == true)
					res++;
			}
			lesson.setCategory_id((int)session.get("category_id"));
			lesson.setUser_id(((User)session.get("user")).getUser_id());
			lesson.setResult(res);
			int id = lessonBusiness.saveLesson(lesson);
			System.out.println(id);
			LessonWord lessonWord = new LessonWord();
			for(int i = 0; i < choice.size(); i++) {
				lessonWord.setLesson_id(id);
				lessonWord.setWord_id(question.get(i).getWord_id());
				lessonWord.setWord_answer_id(choice.get(i).getWord_answer_id());
				lessonWordBusiness.saveLessonWord(lessonWord);
			}
			
			Activity activity = new Activity();
			activity.setTarget_id(id);
			activity.setUser_id(((User)session.get("user")).getUser_id());
			activity.setAction_type("LEARN");
			activityBusiness.saveActivity(activity);

*/			session.remove("count");
			session.remove("word");
			session.remove("listAnswer");
			session.remove("question");
			session.remove("choice");
			session.remove("result");
			session.remove("category_id");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

}

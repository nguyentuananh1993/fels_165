package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.model.WordAnswer;

public class WordAnswerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private WordAnswerBusiness wordAnswerBusiness = null;
	private WordAnswer wordAnswer = null;
	
	public WordAnswerBusiness getWordAnswerBusiness() {
		return wordAnswerBusiness;
	}
	public void setWordAnswerBusiness(WordAnswerBusiness wordAnswerBusiness) {
		this.wordAnswerBusiness = wordAnswerBusiness;
	}
	public WordAnswer getWordAnswer() {
		return wordAnswer;
	}
	public void setWordAnswer(WordAnswer wordAnswer) {
		this.wordAnswer = wordAnswer;
	}

}

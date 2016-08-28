package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.WordAnswer;

public interface WordAnswerBusiness {

	public WordAnswer selectCorrectAnswer(int word_id) throws Exception;

	public List<WordAnswer> getWordAnswerByWordId(int word_id) throws Exception;

}

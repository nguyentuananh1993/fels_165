package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.WordAnswer;

public interface WordAnswerDAO {

	public WordAnswer selectCorrectAnswer(int word_id) throws Exception;

	public List<WordAnswer> getWordAnswerByWordId(int word_id) throws Exception;

}

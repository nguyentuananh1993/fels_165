package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.WordAnswer;

public interface WordAnswerDAO {

	public WordAnswer selectCorrectAnswer(int word_id) throws Exception;

}

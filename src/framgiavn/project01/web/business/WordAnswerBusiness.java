package framgiavn.project01.web.business;

import framgiavn.project01.web.model.WordAnswer;

public interface WordAnswerBusiness {

	WordAnswer selectCorrectAnswer(int word_id) throws Exception;

}

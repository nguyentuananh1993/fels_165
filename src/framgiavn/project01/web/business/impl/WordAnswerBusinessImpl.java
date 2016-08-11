package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.dao.WordAnswerDAO;
import framgiavn.project01.web.model.WordAnswer;

public class WordAnswerBusinessImpl implements WordAnswerBusiness {

	private WordAnswerDAO wordAnswerDAO;

	public WordAnswerDAO getWordAnswerDAO() {
		return wordAnswerDAO;
	}

	public void setWordAnswerDAO(WordAnswerDAO wordAnswerDAO) {
		this.wordAnswerDAO = wordAnswerDAO;
	}

	@Override
	public WordAnswer selectCorrectAnswer (int word_id) throws Exception {
		try {
			return getWordAnswerDAO().selectCorrectAnswer(word_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}


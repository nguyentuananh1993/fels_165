package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.dao.WordDAO;
import framgiavn.project01.web.model.Word;

public class WordBusinessImpl implements WordBusiness{
	private WordDAO wordDAO;

	public WordDAO getWordDAO() {
		return wordDAO;
	}

	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;
	}

	@Override
	public List<Word> wordFilterByCategory(String name) throws Exception {
		try {
			return getWordDAO().wordFilterByCategory(name);
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}

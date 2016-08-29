package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.dao.WordDAO;
import framgiavn.project01.web.model.Word;

public class WordBusinessImpl implements WordBusiness{
	private WordDAO wordDAO;
	private CategoryDAO categoryDAO;
	private int category_id;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public WordDAO getWordDAO() {
		return wordDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;
	}

	@Override
	public List<Word> wordFilterByCategory(String name) throws Exception {
		try {
			category_id = categoryDAO.findCategoryIdByName(name);
			return wordDAO.wordFilterByCategory(category_id);
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Word> listAllWord() throws Exception {
		try {
			return wordDAO.listAllWord();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Word findById(Integer word_id) throws Exception {
		try {
			return wordDAO.findById(word_id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Word editWord(Word word) throws Exception {
		try {
			getWordDAO().editWord(word);
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	@Override
	public boolean deleteWordById(Integer word_id) throws Exception {
		try {
			getWordDAO().deleteWordById(word_id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAllWord() throws Exception {
		try {
			getWordDAO().deleteAllWord();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void addWord(Word word) throws Exception {
		try {
			getWordDAO().addWord(word);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

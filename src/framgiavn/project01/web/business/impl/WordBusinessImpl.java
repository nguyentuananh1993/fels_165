package framgiavn.project01.web.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import bsh.org.objectweb.asm.Type;
import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.dao.CategoryDAO;
import framgiavn.project01.web.dao.WordDAO;
import framgiavn.project01.web.model.Word;

public class WordBusinessImpl implements WordBusiness {
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
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public List<Word> initWordList(int category_id) throws Exception {
		try {
			List<Word> list;
			list = wordDAO.wordFilterByCategory(category_id);
			List<Word> result = new ArrayList<Word>();
			for (int i = 0; i < 20; i++) {
				int randomIndex = (int) (Math.random() * list.size());
				Word word = list.get(randomIndex);
				result.add(i, word);
			}
			return result;
		} catch (Exception e) {	e.printStackTrace();
		throw e;
	}
}
	public List<Word> wordFilter(String name, int type) throws Exception {
		try {
			category_id = categoryDAO.findCategoryIdByName(name);
			if (type == 1) {
				return wordDAO.wordFilterByLearnedWord(category_id);
			}
			if (type == 2) {
				return wordDAO.wordFilterByNotLearnedWord(category_id);
			}
			if (type == 3) {
				return wordDAO.wordFilterByCategory(category_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}
}

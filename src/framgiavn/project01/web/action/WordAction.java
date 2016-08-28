package framgiavn.project01.web.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public class WordAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private WordBusiness wordBusiness = null;
	private List<Word> listWord = null;
	private Word word;
	private String category = "Newbie";
	private SessionMap session = null;
	private List<Category> listCategory = null;
	private CategoryBusiness categoryBusiness = null;
	private Map<Word, WordAnswer> mapWord = null;
	private WordAnswerBusiness wordAnswerBusiness = null;

	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public CategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}

	public void setCategoryBusiness(CategoryBusiness categoryBusiness) {
		this.categoryBusiness = categoryBusiness;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public WordAnswerBusiness getWordAnswerBusiness() {
		return wordAnswerBusiness;
	}

	public void setWordAnswerBusiness(WordAnswerBusiness wordAnswerBusiness) {
		this.wordAnswerBusiness = wordAnswerBusiness;
	}

	public WordBusiness getWordBusiness() {
		return wordBusiness;
	}

	public void setWordBusiness(WordBusiness wordBusiness) {
		this.wordBusiness = wordBusiness;
	}

	public List<Word> getListWord() {
		return listWord;
	}

	public void setListWord(List<Word> listWord) {
		this.listWord = listWord;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<Word, WordAnswer> getMapWord() {
		return mapWord;
	}

	public void setMapWord(Map<Word, WordAnswer> mapWord) {
		this.mapWord = mapWord;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap) session;
	}

	public boolean compare(String a, String b) {

		return a.equals(b);
	}

	public String findWordByCategory() {
		Word word;
		WordAnswer wordAnswer;
		Iterator listWordIterator;
		mapWord = new HashMap<Word, WordAnswer>();
		try {
			listCategory = categoryBusiness.listAllCategory();
			if (category == null || category.equals("")) {
				return SUCCESS;
			} else {
				System.out.println(category);
				listWord = wordBusiness.wordFilterByCategory(category);
				listWordIterator = listWord.iterator();
				while (listWordIterator.hasNext()) {
					word = (Word) listWordIterator.next();
					wordAnswer = wordAnswerBusiness.selectCorrectAnswer(word.getWord_id());
					mapWord.put(word, wordAnswer);
				}
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String adminWordList() {
		try {
			listWord = wordBusiness.listAllWord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String adminWordEdit() {
		try {
			word = wordBusiness.findById(word.getWord_id());
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String actionAdminWordEdit() {
		try {
			wordBusiness.editWord(word);
			if(word.getContent() == null){
				return ERROR;
			} else {
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String adminWordDelete() {
		try {
			if(wordBusiness.deleteWordById(word.getWord_id())) {
				return "finish";
			}
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	public String adminWordAdd() {
		return SUCCESS;
	}
	public String actionAdminWordAdd() {
		try {
			if(validateAddWord(word)) {
				wordBusiness.addWord(word);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public boolean validateAddWord(Word word) {
		if(word.getContent() == null || word.getCategory_id() == 0) {
			return false;
		}
		return true;
	}
	public String adminUserDeleteAll() {
		try {
			wordBusiness.deleteAllWord();
			return "finish";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}

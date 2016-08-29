package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.context.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.CategoryBusiness;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.business.WordAnswerBusiness;
import framgiavn.project01.web.business.WordBusiness;
import framgiavn.project01.web.model.Category;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.model.Word;
import framgiavn.project01.web.model.WordAnswer;

public class WordAction extends ActionSupport implements SessionAware, ServletContextAware {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private WordBusiness wordBusiness = null;
	private List<Word> listWord = null;
	private Word word;
	private UserBusiness userBusiness;
	private String category = "Newbie";
	private SessionMap<String, Object> session;
	private List<Category> listCategory = null;
	private CategoryBusiness categoryBusiness = null;
	private Map<Word, WordAnswer> mapWord = null;
	private WordAnswerBusiness wordAnswerBusiness = null;
	private List<String> typefilter;
	private static final String L = "Leaned";
	private static final String UL = "Not Leaned";
	private static final String A = "All";
	private int typeCurrent = 3;
	private int typePre = 3;

	public int getTypeCurrent() {
		return typeCurrent;
	}

	public void setTypeCurrent(int typeCurrent) {
		this.typeCurrent = typeCurrent;
	}

	public int getTypePre() {
		return typePre;
	}

	public void setTypePre(int typePre) {
		this.typePre = typePre;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.context = arg0;
	}

	public SessionMap<String, Object> getSession() {
		return session;
	}

	public void setSession(SessionMap<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

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

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	private boolean checkLogIn() {
		User userLogin = (User) ActionContext.getContext().getSession().get("user");
		if (userLogin != null && userLogin.getIsAdmin()) {
			return true;
		}
		return false;
	}

	public String findWordByCategory() {
		Word word;
		WordAnswer wordAnswer = null;
		Iterator listWordIterator;
		mapWord = new HashMap<Word, WordAnswer>();
		typefilter = new ArrayList<>();
		typefilter.add(L);
		typefilter.add(UL);
		typefilter.add(A);
		try {
			listCategory = categoryBusiness.listAllCategory();
			if (category == null || category.equals("")) {
				return SUCCESS;
			} else {
				System.out.println(category);
				System.out.println("Type : " + typeCurrent);
				listWord = wordBusiness.wordFilter(category, typeCurrent);
				listWordIterator = listWord.iterator();
				while (listWordIterator.hasNext()) {
					word = (Word) listWordIterator.next();
					wordAnswer = wordAnswerBusiness.selectCorrectAnswer(word.getWord_id());
					mapWord.put(word, wordAnswer);
				}
				this.setTypePre(typeCurrent);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String showWord() {
		try {
			listCategory = categoryBusiness.listAllCategory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String adminWordList() {
		if (!checkLogIn()) {
			return ERROR;
		}
		try {
			listWord = wordBusiness.listAllWord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String adminWordAdd() {
		if (!checkLogIn()) {
			return ERROR;
		}
		return SUCCESS;
	}

	public String adminWordEdit() {
		if (!checkLogIn()) {
			return ERROR;
		}
		try {
			word = wordBusiness.findById(word.getWord_id());
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public String actionAdminWordEdit() {
		if (!checkLogIn()) {
			return ERROR;
		}
		try {
			wordBusiness.editWord(word);
			if (word.getContent() == null) {
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
		if (!checkLogIn()) {
			return ERROR;
		}
		try {
			if (wordBusiness.deleteWordById(word.getWord_id())) {
				return "finish";
			}
			return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String actionAdminWordAdd() {
		if (!checkLogIn()) {
			return ERROR;
		}
		try {
			if (validateAddWord(word)) {
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
		if (word.getContent() == null || word.getCategory_id() == 0) {
			return false;
		}
		return true;
	}

	public String adminUserDeleteAll() {
		if (!checkLogIn()) {
			return ERROR;
		}
		try {
			wordBusiness.deleteAllWord();
			return "finish";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public String findWord() {
		Word word;
		WordAnswer wordAnswer;
		Iterator listWordIterator;
		mapWord = new HashMap<Word, WordAnswer>();
		typefilter = new ArrayList<>();
		typefilter.add(L);
		typefilter.add(UL);
		typefilter.add(A);
		try {
			listCategory = categoryBusiness.listAllCategory();
			if (category == null || category.equals("")) {
				return SUCCESS;
			} else {
				System.out.println(category);
				System.out.println("Type : " + typeCurrent);
				listWord = wordBusiness.wordFilter(category, typeCurrent);
				listWordIterator = listWord.iterator();
				while (listWordIterator.hasNext()) {
					word = (Word) listWordIterator.next();
					wordAnswer = wordAnswerBusiness.selectCorrectAnswer(word.getWord_id());
					mapWord.put(word, wordAnswer);
				}
				this.setTypePre(typeCurrent);
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}

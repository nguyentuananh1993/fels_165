package framgiavn.project01.web.business;


import java.util.List;

import framgiavn.project01.web.model.Word;

public interface WordBusiness {

	public List<Word> wordFilterByCategory(String name) throws Exception;

	public List<Word> initWordList(int category_id) throws Exception;

}

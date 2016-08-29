package framgiavn.project01.web.business;


import java.util.List;

import framgiavn.project01.web.model.Word;

public interface WordBusiness {

	List<Word> wordFilterByCategory(String name) throws Exception;
	List<Word> listAllWord() throws Exception;
	Word findById(Integer word_id) throws Exception;
	Word editWord(Word word) throws Exception;
	boolean deleteWordById(Integer word_id) throws Exception;
	boolean deleteAllWord() throws Exception;
	void addWord(Word word) throws Exception;
}

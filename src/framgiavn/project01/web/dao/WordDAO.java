package framgiavn.project01.web.dao;


import java.util.List;

import framgiavn.project01.web.model.Word;

public interface WordDAO {

	public List<Word> wordFilterByLearnedWord(int category_id);
	public List<Word> wordFilterByNotLearnedWord(int category_id);
	public List<Word> wordFilterByCategory(int category_id) throws Exception;
	public List<Word> listAllWord() throws Exception;
	public Word findById(Integer word_id) throws Exception;
	public Word editWord(Word word) throws Exception;
	public boolean deleteWordById(Integer word_id) throws Exception;
	public boolean deleteAllWord() throws Exception;
	public void addWord(Word word) throws Exception;
}

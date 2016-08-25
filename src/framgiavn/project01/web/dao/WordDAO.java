package framgiavn.project01.web.dao;


import java.util.List;

import framgiavn.project01.web.model.Word;

public interface WordDAO {

	public List<Word> wordFilterByLearnedWord(int category_id);

	public List<Word> wordFilterByNotLearnedWord(int category_id);

	public List<Word> showAllWord();

	public List<Word> wordFilterByCategory(int category_id) throws Exception;
	
	
}

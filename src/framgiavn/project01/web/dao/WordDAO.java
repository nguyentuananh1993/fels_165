package framgiavn.project01.web.dao;


import java.util.List;

import framgiavn.project01.web.model.Word;

public interface WordDAO {

	public List<Word> wordFilterByLearnedWord();

	public List<Word> wordFilterByNotLearnedWord();

	public List<Word> showAllWord();

	public List<Word> wordFilterByCategory(String name) throws Exception;

}

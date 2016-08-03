package framgiavn.project01.web.business;


import java.util.List;

import framgiavn.project01.web.model.Word;

public interface WordBusiness {

	List<Word> wordFilterByCategory(String name) throws Exception;

}

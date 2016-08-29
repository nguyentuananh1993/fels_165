package framgiavn.project01.web.dao;


import java.util.List;

import framgiavn.project01.web.model.Activity;

public interface ActivityDAO {

	public void saveActivity(Activity activity);

	public List<Activity> showActivity(int user_id) throws Exception;

}

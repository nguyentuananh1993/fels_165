package framgiavn.project01.web.business;

import java.util.List;
import framgiavn.project01.web.model.Activity;

public interface ActivityBusiness {

	public void saveActivity(Activity activity) throws Exception;

	public List<Activity> showActivity(int user_id) throws Exception;

}

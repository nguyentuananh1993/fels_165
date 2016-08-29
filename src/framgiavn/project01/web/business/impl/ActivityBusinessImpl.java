package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.ActivityBusiness;
import framgiavn.project01.web.dao.ActivityDAO;
import framgiavn.project01.web.model.Activity;
import framgiavn.project01.web.model.Lesson;

public class ActivityBusinessImpl implements ActivityBusiness {
	
	private ActivityDAO activityDAO;

	public ActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

	@Override
	public void saveActivity(Activity activity) throws Exception{
		try{
		activityDAO.saveActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override 
	public List<Activity> showActivity(int user_id) throws Exception{
		try{
			return activityDAO.showActivity(user_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

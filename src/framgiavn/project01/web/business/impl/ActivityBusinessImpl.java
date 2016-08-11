package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.ActivityBusiness;
import framgiavn.project01.web.dao.ActivityDAO;

public class ActivityBusinessImpl implements ActivityBusiness {
	
	private ActivityDAO activityDAO;

	public ActivityDAO getActivityDAO() {
		return activityDAO;
	}

	public void setActivityDAO(ActivityDAO activityDAO) {
		this.activityDAO = activityDAO;
	}

}

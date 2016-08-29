package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.ActivityBusiness;
import framgiavn.project01.web.model.Activity;


public class ActivityAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ActivityBusiness activityBusiness = null;
	private Activity activity = null;

	public ActivityBusiness getActivityBusiness() {
		return activityBusiness;
	}
	public void setActivityBusiness(ActivityBusiness activityBusiness) {
		this.activityBusiness = activityBusiness;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}

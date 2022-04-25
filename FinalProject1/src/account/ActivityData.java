package account;

import java.time.LocalDateTime;

public class ActivityData {
	private ActivityName activityName;
	private Double balanceChange ;//{+deposit, -withdra}
	private LocalDateTime timeStamp;
	private String info;
	

	
	public ActivityName getActivityName() {
		return activityName;
	}
	public void setActivityName(ActivityName activityName) {
		this.activityName = activityName;
	}
	public Double getBalanceChange() {
		return balanceChange;
	}
	public void setBalanceChange(Double balanceChange) {
		this.balanceChange = balanceChange;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	@Override
	public String toString() {
		return "ActivityData [activityName=" + activityName + ", balanceChange=" + balanceChange + ", timeStamp="
				+ timeStamp + ", info=" + info + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

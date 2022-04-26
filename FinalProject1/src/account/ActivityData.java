package account;

import java.time.LocalDateTime;

public class ActivityData {
	private ActivityName activityName;
	private Double balanceChange ;//{+deposit, -withdraw}
	private LocalDateTime timeStamp;
	private String info;
	

	
	public ActivityData(ActivityName activityName, Double balanceChange, LocalDateTime timeStamp, String info) {
		this.activityName = activityName;
		this.balanceChange = balanceChange;
		this.timeStamp = timeStamp;
		this.info = info;
	}
	
	
	
	
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

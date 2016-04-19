package edu.mum.mumscrum.databean;

import edu.mum.mumscrum.datalayer.model.Userstory;

public class ProgressRecordDataBean {

	private Userstory userstory;

	private long startStopFlag;

	public Userstory getUserstory() {
		return userstory;
	}

	public void setUserstory(Userstory userstory) {
		this.userstory = userstory;
	}

	public long getStartStopFlag() {
		return startStopFlag;
	}

	public void setStartStopFlag(long startStopFlag) {
		this.startStopFlag = startStopFlag;
	}

}

package edu.mum.mumscrum.databean;

public class BurndownChartDataBean {
	private DateDataBean dateObj;
	private double actualEffort;
	private double estimatedEffort;

	public BurndownChartDataBean(DateDataBean dateObj, double actualEffort,
			double estimatedEffort) {
		this.dateObj = dateObj;
		this.actualEffort = actualEffort;
		this.estimatedEffort = estimatedEffort;
	}

	public DateDataBean getDateObj() {
		return dateObj;
	}

	public void setDateObj(DateDataBean dateObj) {
		this.dateObj = dateObj;
	}

	public double getActualEffort() {
		return actualEffort;
	}

	public void setActualEffort(double actualEffort) {
		this.actualEffort = actualEffort;
	}

	public double getEstimatedEffort() {
		return estimatedEffort;
	}

	public void setEstimatedEffort(double estimatedEffort) {
		this.estimatedEffort = estimatedEffort;
	}

}

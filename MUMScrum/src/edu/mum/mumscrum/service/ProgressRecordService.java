package edu.mum.mumscrum.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.mum.mumscrum.databean.BurndownChartDataBean;
import edu.mum.mumscrum.databean.DateDataBean;
import edu.mum.mumscrum.databean.ProgressRecordDataBean;
import edu.mum.mumscrum.datalayer.dao.ProgressRecordDAO;
import edu.mum.mumscrum.datalayer.model.ProgressRecord;

public class ProgressRecordService {

	private ProgressRecordDAO progressRecordDAO;

	public ProgressRecordService() {
		progressRecordDAO = ProgressRecordDAO.getInstance();
	}

	public List<BurndownChartDataBean> getBurndownChartDataBySprintId(String id) {
		// get all finalized progress Records by sprint, sorted ascending by id
		List<ProgressRecord> progressRecords = progressRecordDAO
				.getAllFinalizedProgressRecordsBySprintId(id);
		List<BurndownChartDataBean> burndownChartDataList = new ArrayList<BurndownChartDataBean>();
		DateDataBean prevDateDataObject = new DateDataBean();
		DateDataBean currDateDataObject;
		long prevUserStoryId = -1;
		long currUserStoryId;
		double actualTime = 0.0;
		double estimatedTime = 0.0;
		// loop through progress records to prepare burndown chart data
		for (int i = 0; i < progressRecords.size(); i++) {
			ProgressRecord progressRecord = progressRecords.get(i);
			// set current date data object with date data from progress
			// record
			currDateDataObject = prepareDateDataObject(progressRecord);
			// check if this progress record date isn't the same as the
			// previous's one, then add new record to the list and reset
			// data
			if (!prevDateDataObject.equals(currDateDataObject)) {
				if (i != 0) {
					BurndownChartDataBean burndownChartDataObject = new BurndownChartDataBean(
							prevDateDataObject, actualTime, estimatedTime);
					burndownChartDataList.add(burndownChartDataObject);
				}

				// reset data for new day calculations
				actualTime = 0;
				estimatedTime = 0;
				prevDateDataObject = currDateDataObject;
			}
			// calculate estimation time from user story
			currUserStoryId = progressRecord.getUserstory().getId();
			if (estimatedTime == 0 || prevUserStoryId != currUserStoryId) {
				prevUserStoryId = currUserStoryId;
				estimatedTime += progressRecord.getUserstory().getEstTimeEff();
			}
			// set actual time in hours by subtracting start time from stop
			// time
			actualTime += (progressRecord.getStopTime() - progressRecord
					.getStartTime()) / (60 * 60 * 1000);
			// if 'i' at last element, then add new record to the list
			if (i == progressRecords.size() - 1) {
				BurndownChartDataBean burndownChartDataObject = new BurndownChartDataBean(
						currDateDataObject, actualTime, estimatedTime);
				burndownChartDataList.add(burndownChartDataObject);
			}
		}
		return burndownChartDataList;
	}

	private DateDataBean prepareDateDataObject(ProgressRecord progressRecord) {
		DateDataBean currDateDataBean;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(progressRecord.getStartTime()));
		int currDayVal = cal.get(Calendar.DAY_OF_MONTH);
		int currMonthVal = cal.get(Calendar.MONTH) + 1; // month iteration
														// starts with 0
		int currYearVal = cal.get(Calendar.YEAR);
		currDateDataBean = new DateDataBean(currDayVal, currMonthVal,
				currYearVal);
		return currDateDataBean;
	}

	public ProgressRecord getProgressRecordById(String id) {
		return progressRecordDAO.getProgressRecordById(id);
	}

	/*
	 * to be delete on lunching the app
	 */
	public void updateStartTime(ProgressRecord pr, long flagid) {
		System.out.println(flagid + " if stm ");

		if (flagid == 0)
			progressRecordDAO.updateStartTime(pr);

	}

	// /////delete

	public ProgressRecordDataBean ckeckFlagStatus(ProgressRecordDataBean pr) {
		long flagid = pr.getStartStopFlag(); // flagId
		Date date = new Date();
		long curtime = date.getTime();// get current time
		progressRecordDAO.startEndTimeEstm(pr, flagid, curtime);
		return pr;
	}
}

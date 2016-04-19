package edu.mum.mumscrum.datalayer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the PROGRESS_RECORD database table.
 * 
 */
@Entity
@Table(name = "PROGRESS_RECORD")
@NamedQuery(name = "ProgressRecord.findAll", query = "SELECT p FROM ProgressRecord p")
public class ProgressRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROGRESS_RECORD_SEQ", sequenceName = "PROGRESS_RECORD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGRESS_RECORD_SEQ")
	private long id;

	private long flag;

	@Column(name = "START_TIME")
	private long startTime;

	@Column(name = "STOP_TIME")
	private long stopTime;

	// bi-directional many-to-one association to Sprint
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPR_ID")
	private Sprint sprint;

	// bi-directional many-to-one association to Userstory
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USID")
	private Userstory userstory;

	public ProgressRecord() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFlag() {
		return this.flag;
	}

	public void setFlag(long flag) {
		this.flag = flag;
	}

	public long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Userstory getUserstory() {
		return this.userstory;
	}

	public void setUserstory(Userstory userstory) {
		this.userstory = userstory;
	}

}
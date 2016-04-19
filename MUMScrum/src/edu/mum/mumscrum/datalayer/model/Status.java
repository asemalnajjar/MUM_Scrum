package edu.mum.mumscrum.datalayer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the STATUS database table.
 * 
 */
@Entity
@NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "STATUS_ID")
	private long statusId;

	@Column(name = "STATUS_DESC")
	private String statusDesc;

	public Status() {
	}

	public long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

}
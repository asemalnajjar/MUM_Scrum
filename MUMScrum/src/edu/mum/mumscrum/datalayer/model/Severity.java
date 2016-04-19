package edu.mum.mumscrum.datalayer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the SEVERITY database table.
 * 
 */
@Entity
@NamedQuery(name = "Severity.findAll", query = "SELECT s FROM Severity s")
public class Severity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SEVERITY_ID")
	private long severityId;

	@Column(name = "SEVERITY_DESC")
	private String severityDesc;

	public Severity() {
	}

	public long getSeverityId() {
		return this.severityId;
	}

	public void setSeverityId(long severityId) {
		this.severityId = severityId;
	}

	public String getSeverityDesc() {
		return this.severityDesc;
	}

	public void setSeverityDesc(String severityDesc) {
		this.severityDesc = severityDesc;
	}

}
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

/**
 * The persistent class for the SPRINT database table.
 * 
 */
@Entity
@NamedQuery(name = "Sprint.findAll", query = "SELECT s FROM Sprint s")
public class Sprint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SPRINT_SEQ", sequenceName = "SPRINT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPRINT_SEQ")
	private long id;

	@Column(name = "EST_TIME")
	private long estTime;

	@Column(name = "SPR_NAME")
	private String sprName;

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	// bi-directional many-to-one association to Release
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RELS_ID")
	private Release release;

	public Sprint() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEstTime() {
		return this.estTime;
	}

	public void setEstTime(long estTime) {
		this.estTime = estTime;
	}

	public String getSprName() {
		return this.sprName;
	}

	public void setSprName(String sprName) {
		this.sprName = sprName;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Release getRelease() {
		return this.release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

}
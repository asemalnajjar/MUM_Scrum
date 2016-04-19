package edu.mum.mumscrum.datalayer.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
 * The persistent class for the USERSTORY database table.
 * 
 */
@Entity
@NamedQuery(name = "Userstory.findAll", query = "SELECT u FROM Userstory u")
public class Userstory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USERSTORY_SEQ", sequenceName = "USERSTORY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERSTORY_SEQ")
	private long id;

	@Column(name = "EST_TIME_EFF")
	private long estTimeEff;

	@Column(name = "US_DESC")
	private String usDesc;

	@Column(name = "US_NAME")
	private String usName;

	@Column (name = "US_STATUS")
	private long usStatus;
	

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRD_ID")
	private Product product;

	@Override
	public String toString() {
		return "Userstory [id=" + id + ", estTimeEff=" + estTimeEff + ", usDesc=" + usDesc + ", usName=" + usName
				+ ", employee=" + employee + ", product=" + product + ", release=" + release + ", severity=" + severity
				+ ", sprint=" + sprint + "]";
	}

	// bi-directional many-to-one association to Release
	@ManyToOne( cascade= CascadeType.PERSIST , fetch = FetchType.LAZY)
	@JoinColumn(name = "RELS_ID")
	private Release release;
	
	// bi-directional many-to-one association to Severity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEV_ID")
	private Severity severity;

	// bi-directional many-to-one association to Sprint
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "SPR_ID")
	private Sprint sprint;

	public Userstory() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEstTimeEff() {
		return this.estTimeEff;
	}

	public void setEstTimeEff(long estTimeEff) {
		this.estTimeEff = estTimeEff;
	}

	public String getUsDesc() {
		return this.usDesc;
	}

	public void setUsDesc(String usDesc) {
		this.usDesc = usDesc;
	}

	public String getUsName() {
		return this.usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}
	
	public long getUsStatus() {
		return this.usStatus;
	}

	public void setUsStatus(long usStatus) {
		this.usStatus = usStatus;
	}
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getReleaseid() {
		return this.release.getId();
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public Severity getSeverity() {
		return this.severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

}
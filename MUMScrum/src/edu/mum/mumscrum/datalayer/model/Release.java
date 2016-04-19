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
 * The persistent class for the "RELEASE" database table.
 * 
 */
@Entity
@Table(name = "\"RELEASE\"")
@NamedQuery(name = "Release.findAll", query = "SELECT r FROM Release r")
public class Release implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "RELEASE_SEQ", sequenceName = "RELEASE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELEASE_SEQ")
	private long id;

	@Column(name = "RELS_DATE")
	private String relsDate;

	@Column(name = "RELS_DESC")
	private String relsDesc;

	@Column(name = "RELS_NAME")
	private String relsName;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRD_ID")
	private Product product;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Release() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRelsDate() {
		return this.relsDate;
	}

	public void setRelsDate(String relsDate) {
		this.relsDate = relsDate;
	}

	public String getRelsDesc() {
		return this.relsDesc;
	}

	public void setRelsDesc(String relsDesc) {
		this.relsDesc = relsDesc;
	}

	public String getRelsName() {
		return this.relsName;
	}

	public void setRelsName(String relsName) {
		this.relsName = relsName;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return " id=" + id + ", relsDate=" + relsDate + ", relsDesc=" + relsDesc + ", relsName=" + relsName;
		// + ", product=" + product + "]";
	}

}
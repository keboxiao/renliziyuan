package com.po;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Areas entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "areas", catalog = "waibao")
public class Areas implements java.io.Serializable {

	// Fields

	private Short id;
	private String area;

	// Constructors

	/** default constructor */
	public Areas() {
	}

	public Areas(Short id) {
		this.id = id;
	}
	
	/** full constructor */
	public Areas(String area) {
		this.area = area;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	@Column(name = "area", length = 20)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
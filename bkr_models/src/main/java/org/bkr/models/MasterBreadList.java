package org.bkr.models;
// Generated 09 26, 18 5:30:50 PM by Hibernate Tools 5.2.11.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MasterBreadList generated by hbm2java
 */
@Entity
@Table(name = "master_bread_list")
public class MasterBreadList implements java.io.Serializable {

	private Long id;
	private String breadName;
	private BigDecimal price;
//	private Set<Templates> templateDetailses = new HashSet<>();

	public MasterBreadList() {
	}

	public MasterBreadList(long id) {
		this.id=id;
	}
	
//	public MasterBreadList(String breadName, Long price, Set<Templates> templateDetailses) {
//		this.breadName = breadName;
//		this.price = price;
//		this.templateDetailses = templateDetailses;
//	}
	
	public MasterBreadList(String breadName, BigDecimal price) {
		this.breadName = breadName;
		this.price = price;
	}
	
	public MasterBreadList(Long id,String breadName, BigDecimal price) {
		this.breadName = breadName;
		this.price = price;
		this.id=id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "bread_name", length = 100)
	public String getBreadName() {
		return this.breadName;
	}

	public void setBreadName(String breadName) {
		this.breadName = breadName;
	}

	@Column(name = "price", precision = 10, scale = 2)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "masterBreadList")
//	public Set<Templates> getTemplateDetailses() {
//		return this.templateDetailses;
//	}
//
//	public void setTemplateDetailses(Set<Templates> templateDetailses) {
//		this.templateDetailses = templateDetailses;
//	}

}

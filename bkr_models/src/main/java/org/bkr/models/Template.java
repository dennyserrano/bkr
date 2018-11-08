package org.bkr.models;
// Generated 09 26, 18 5:30:50 PM by Hibernate Tools 5.2.11.Final

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
 * Templates generated by hbm2java
 */
@Entity
@Table(name = "templates")
public class Template implements java.io.Serializable {

	private Long id;
	private String name;
	private boolean active;
	private Set<TemplateDetail> templateDetails = new HashSet<>();

	public Template() {
	}

	public Template(long id)
	{
		this.id=id;
	}
	
	public Template(String name, Set<TemplateDetail> templateDetailses) {
		this.name = name;
		this.templateDetails = templateDetailses;
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

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "template")
	public Set<TemplateDetail> getTemplateDetails() {
		return this.templateDetails;
	}

	public void setTemplateDetails(Set<TemplateDetail> templateDetails) {
		this.templateDetails = templateDetails;
	}

	@Column(name = "active", length = 1)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}

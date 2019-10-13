package com.wyh.springbootspringdatajpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_project")
public class ProjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "f_id")
	private Long id;
	
	@Column(name = "f_project_code")
	private String projectCode;
	
	@Column(name = "f_project_name")
	private String projectName;

	@OneToMany(mappedBy = "project")
	private List<AccountEntity> accounts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", projectCode=" + projectCode + ", projectName=" + projectName + "]";
	}
	
	
	
}

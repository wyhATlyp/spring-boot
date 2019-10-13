package com.wyh.springbootspringdatajpa.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_account")
public class AccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "f_id")
	private Long id;
	
	@Column(name = "f_account")
	private String account;
	
	@Column(name = "f_chinese")
	private String chinese;
	
	@Column(name = "f_password")
	private String password;
	
	@Column(name = "f_create_time")
	private Timestamp createTime;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "f_project_id")
	private ProjectEntity project;
	
	@ManyToMany(mappedBy = "accounts", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<RoleEntity> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "AccountEntity [id=" + id + ", account=" + account + ", chinese=" + chinese + ", password=" + password
				+ ", createTime=" + createTime + "]";
	}
	
}

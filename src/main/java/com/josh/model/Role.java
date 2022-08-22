package com.josh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name="roleId")
	private int roleid;//Primary key for User table.
	@Column(name="role")
	private String role;
	@Column(name="id")
	private String userRoleId;;

}

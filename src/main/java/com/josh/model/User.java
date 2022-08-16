package com.josh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Usertable")
public class User {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private int userId;//Primary key for User table.
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="contact")
	private String contact;
	@Column(name="ssn")
	private String ssn;
	@Column(name="role")
	private String role;

}

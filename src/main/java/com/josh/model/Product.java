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
@Table(name = "Product")
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productid")
	private int ProductId;//Primary key for User table.
	@Column(name="Productname")
	private String ProductName;
	@Column(name="description")
	private String description;
	@Column(name="price")
	private double price;
	@Column(name="weight")
	private double weight;
	@Column(name="quantity")
	private int quantity;
	@Column(name="image")
	private String imageURL;

	}



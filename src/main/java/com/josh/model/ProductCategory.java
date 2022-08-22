package com.josh.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductCategory {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categoryId")
	private long categoryId;
	@Column(nullable=false, length=45, updatable=true)
	private String category;
	@OneToMany(mappedBy="productCategory")
	@JsonIgnore
	private Set<Product> products;// HAS A

	
}
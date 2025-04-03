package com.cafeShop.cafe.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_img")
	private String img;
	
	@Column(name="product_des")
	private String description;
	
	@Column(name="product_price")
	private BigDecimal price;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category category;
//	@JsonIgnore
//	private Category category;

	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Suger> sugers;
}

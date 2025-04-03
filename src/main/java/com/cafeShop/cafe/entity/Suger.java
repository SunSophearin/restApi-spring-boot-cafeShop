package com.cafeShop.cafe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="suger")
public class Suger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="suger_id")
	private Long id;
	@Column(name="suger")
	private String type;
	
	@ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    @JsonIgnore
    private Product product;
}

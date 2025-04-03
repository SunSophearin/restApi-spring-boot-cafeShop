package com.cafeShop.cafe.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ProductDTO {
	private Long categoryId;
	
	private String name;
	
	private String img;
	
	private String description;
	
	private BigDecimal price;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<SugerDTO> sugers;
}

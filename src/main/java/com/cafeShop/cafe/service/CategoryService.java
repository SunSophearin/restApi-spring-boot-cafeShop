package com.cafeShop.cafe.service;

import java.util.List;

import com.cafeShop.cafe.dto.CategoryDTO;
import com.cafeShop.cafe.entity.Category;

public interface CategoryService {
	Category create(CategoryDTO categoryDTO);
	Category getByID(Long id);
	List<Category> getAll();
}

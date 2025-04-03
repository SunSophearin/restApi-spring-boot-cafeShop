package com.cafeShop.cafe.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cafeShop.cafe.dto.CategoryDTO;
import com.cafeShop.cafe.entity.Category;
import com.cafeShop.cafe.mapper.CategoryMapper;
import com.cafeShop.cafe.repository.CategoryRepository;
import com.cafeShop.cafe.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	@Override
	public Category create(CategoryDTO categoryDTO) {
		Category category = categoryMapper.toCategory(categoryDTO);
		return categoryRepository.save(category);
	}
	@Override
	public Category getByID(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
}

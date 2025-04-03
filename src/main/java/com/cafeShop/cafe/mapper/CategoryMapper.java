package com.cafeShop.cafe.mapper;

import org.mapstruct.Mapper;

import com.cafeShop.cafe.dto.CategoryDTO;
import com.cafeShop.cafe.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	Category toCategory(CategoryDTO categoryDTO);
	CategoryDTO toCategoryDTO(Category category);
}

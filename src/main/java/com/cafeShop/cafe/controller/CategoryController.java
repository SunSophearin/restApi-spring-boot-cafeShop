package com.cafeShop.cafe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafeShop.cafe.dto.CategoryDTO;
import com.cafeShop.cafe.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/categorys")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@PostMapping("/add_category")
	public ResponseEntity<?> create(@RequestBody CategoryDTO categoryDTO){
		return ResponseEntity.ok(categoryService.create(categoryDTO));
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getByid(@PathVariable Long id){
		return ResponseEntity.ok(categoryService.getByID(id));
	}
	@GetMapping()
	public ResponseEntity<?> getByid(){
		return ResponseEntity.ok(categoryService.getAll());
	}
}

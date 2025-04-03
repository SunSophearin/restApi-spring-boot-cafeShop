package com.cafeShop.cafe.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cafeShop.cafe.dto.ProductDTO;
import com.cafeShop.cafe.entity.Product;
import com.cafeShop.cafe.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	@PostMapping("/add_product")
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO){
		Product product = productService.create(productDTO);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		ProductDTO productDTO = productService.getById(id);
		return ResponseEntity.ok(productDTO);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(productService.getAll());
	}
	
	@PostMapping("/{id}/image")
	public ResponseEntity<?> saveImage(@PathVariable Long id, @RequestParam MultipartFile file ) throws IllegalStateException, IOException{
		if(file.isEmpty()) {
			return new ResponseEntity<>("Please Select file To Upload",HttpStatus.BAD_REQUEST);
		}
		if(!file.getContentType().startsWith("image")) {
			return new ResponseEntity<>("Please Upload only Image",HttpStatus.BAD_REQUEST);
		}
		Product saveImage = productService.saveImage(id, file);
		return ResponseEntity.ok(saveImage);
	}
	
	@PostMapping("/add_product_with_img")
	public ResponseEntity<?> createProductWithImg(
			@RequestParam String productDTO,@RequestParam MultipartFile file) 
			throws IllegalStateException, IOException{
		if(file.isEmpty()) {
			return new ResponseEntity<>("Please Select file To Upload",HttpStatus.BAD_REQUEST);
		}
		if(!file.getContentType().startsWith("image")) {
			return new ResponseEntity<>("Please Upload only Image",HttpStatus.BAD_REQUEST);
		}
		
		ProductDTO productDTO2=convertToProductDto(productDTO);
		Product product = productService.createProductWithImg(productDTO2, file);
		return ResponseEntity.ok(product);
	}
	 private ProductDTO convertToProductDto(String peoductDtoObj) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.readValue(peoductDtoObj, ProductDTO.class);
	    }
}

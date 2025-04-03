package com.cafeShop.cafe.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cafeShop.cafe.dto.ProductDTO;
import com.cafeShop.cafe.entity.Product;

public interface ProductService {
	Product create(ProductDTO productDTO);
	ProductDTO getById(Long id);
	List<Product> getAll();
	Product saveImage(Long id, MultipartFile file)throws IllegalStateException, IOException;
	Product createProductWithImg(ProductDTO productDTO, MultipartFile file)throws IllegalStateException, IOException;
}

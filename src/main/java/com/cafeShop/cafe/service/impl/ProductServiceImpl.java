package com.cafeShop.cafe.service.impl;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cafeShop.cafe.dto.ProductDTO;
import com.cafeShop.cafe.entity.Product;
import com.cafeShop.cafe.exception.ResoureExceptionNotFound;
import com.cafeShop.cafe.mapper.ProductMapper;
import com.cafeShop.cafe.repository.ProductRepository;
import com.cafeShop.cafe.service.GenerateFileService;
import com.cafeShop.cafe.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	private final GenerateFileService generateFileService;
	
	@Value("${app.basePath}")
	private String basePath;
	
	
	@Override
	public Product create(ProductDTO productDTO) {
		return productRepository.save(productMapper.toProduct(productDTO));
	}

	@Override
	public ProductDTO getById(Long id) {
		 Product product = productRepository.findById(id).orElseThrow(()->new ResoureExceptionNotFound("Product", id));
		 ProductDTO productDTO = productMapper.toProductDTO(product);
//		ProductDTO productDTO = new ProductDTO();
//		BeanUtils.copyProperties(product,productDTO);
		 return productDTO;

	}

	@Override
	public List<Product> getAll() {
//		List<Product> products = productRepository.findAll();
//		 return products.stream()
//                 .map(pd->productMapper.toProductDTO(pd)).toList();
		return productRepository.findAll();
	}

	@Override
	public Product saveImage(Long id, MultipartFile file) throws IllegalStateException, IOException {
		String newFileName = generateFileService.genarateFileToString(file.getOriginalFilename());
		
		String desfinationPath=basePath+newFileName;
		
		file.transferTo(new File(desfinationPath));
		
		ProductDTO productDTO = getById(id);
		productDTO.setImg(newFileName);
		
		return productRepository.save(productMapper.toProduct(productDTO));
	}

	@Override
	public Product createProductWithImg(ProductDTO productDTO, MultipartFile file)
			throws IllegalStateException, IOException {
		String newFileName = generateFileService.genarateFileToString(file.getOriginalFilename());
		String desfinationPath=basePath+newFileName;
		file.transferTo(new File(desfinationPath));
		
		Product product = productMapper.toProduct(productDTO);
		if(productDTO.getImg()!=null) {
			product.setImg(newFileName);
		}
		return productRepository.save(product);
	}

}
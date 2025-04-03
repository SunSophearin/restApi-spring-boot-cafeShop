package com.cafeShop.cafe.mapper;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.cafeShop.cafe.dto.ProductDTO;
import com.cafeShop.cafe.entity.Product;
import com.cafeShop.cafe.entity.Suger;
import com.cafeShop.cafe.service.CategoryService;

@Mapper(componentModel = "spring", uses = {CategoryService.class})
public interface  ProductMapper {

    @Mapping(target = "category", source = "categoryId")
    Product toProduct(ProductDTO productDTO);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDTO toProductDTO(Product product);

    @AfterMapping
    default void afterToProduct(ProductDTO productDTO, @MappingTarget Product product) {

        // Map sugers if not null
        if (productDTO.getSugers() != null) {
            List<Suger> sugers = productDTO.getSugers().stream()
                    .map(sugerDTO -> {
                        Suger suger = new Suger();
                        suger.setType(sugerDTO.getType());
                        suger.setProduct(product);
                        return suger;
                    })
                    .collect(Collectors.toList());
            product.setSugers(sugers);
        }
//        if(productDTO.getImg()!=null && !productDTO.getImg().isEmpty()&&) {
//        	
//        }
    }
}
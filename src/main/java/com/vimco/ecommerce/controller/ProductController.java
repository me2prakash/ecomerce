package com.vimco.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vimco.ecommerce.common.ApiResponse;
import com.vimco.ecommerce.dto.product.ProductDto;
import com.vimco.ecommerce.model.Category;
import com.vimco.ecommerce.service.CategoryService;
import com.vimco.ecommerce.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	public ResponseEntity<List<ProductDto>> getProducts(){
		List<ProductDto> body = productService.listProducts();
		return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
	}
	
	  @PostMapping("/add")
	    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
	        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
	        if (!optionalCategory.isPresent()) {
	            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
	        }
	        Category category = optionalCategory.get();
	        productService.addProduct(productDto, category);
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
	    }

	    @PostMapping("/update/{productID}")
	    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Integer productID, @RequestBody @Valid ProductDto productDto) {
	        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
	        if (!optionalCategory.isPresent()) {
	            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
	        }
	        Category category = optionalCategory.get();
	        productService.updateProduct(productID, productDto, category);
	        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
	    }

}

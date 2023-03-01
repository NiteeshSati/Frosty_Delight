package com.app.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.repository.CategoryRepo;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepository ProductRepo;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Product addProductsByCategory(long id,Product product) {
		
		Category category = categoryRepo.findById(id);
		
		category.addProduct(product);
		
		 return ProductRepo.save(product);
		
	}
	
}
	
	

	
	 
	


package org.jsp.amazon_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jsp.amazon_api.dto.Amazon;
import org.jsp.amazon_api.reposiroty.AmazonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AmazonService {
	
	@Autowired
	AmazonRepository repository;

	  public ResponseEntity<Object> saveProduct(Amazon amazon) {

		repository.save(amazon);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", amazon);
		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

   	 public ResponseEntity<Object> saveProducts(List<Amazon> amazon) {
 
		repository.saveAll(amazon);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", amazon);

		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	  public ResponseEntity<Object> fetchAllProducts() {
		List<Amazon> list = repository.findAll();
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found");

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	    public ResponseEntity<Object> fetchById(int id) {
		Optional<Amazon> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found with Id: "+id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", optional.get());
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	    public ResponseEntity<Object> fetchByPriceGreater(double price) {
		List<Amazon> list = repository.findByPriceGreaterThanEqual(price);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found Price Greater Than: "+price);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	    		public ResponseEntity<Object> fetchBySize(String size) {
		List<Amazon> list = repository.findBySize(size);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found with Name :"+size);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	    	 public ResponseEntity<Object> fetchByQuantity(int quantity) {
			Optional<Amazon> optional = repository.findByQuantity(quantity);
			if(optional.isEmpty()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("error", "No Products Found with Id: "+quantity);
				return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
			}else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("message", "Products Found");
				map.put("data", optional.get());
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			}
		}
	

	    	 public ResponseEntity<Object> fetchByDiscount(String discount) {
			List<Amazon> list = repository.findByDiscount(discount);
			if (list.isEmpty()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("error", "No Products Found with Name :"+discount);
				return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("message", "Products Found");
				map.put("data", list);
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			}
    	}

	   public ResponseEntity<Object> updateProduct(Amazon amazon) {
		repository.save(amazon);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Updated Success");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	   public ResponseEntity<Object> updateProduct(int id, Amazon amazon) {
		Optional<Amazon> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Product Found with Id: "+id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			
			Amazon existingProduct = optional.get();
			if(amazon.getProduct_name()!=null)
				existingProduct.setProduct_name(amazon.getProduct_name());
			
			if(amazon.getQuantity()!=0)
				existingProduct.setQuantity(amazon.getQuantity());
			
			if(amazon.getPrice()!=0)
				existingProduct.setPrice(amazon.getPrice());
			
			if(amazon.getSize()!=null)
				existingProduct.setSize(amazon.getSize());
			
			if(amazon.getDiscount()!=null)
				existingProduct.setDiscount(amazon.getDiscount());
			
			repository.save(existingProduct);
			map.put("message", "Product Updated Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	
	   public ResponseEntity<Object> deleteById(int id) {
		Optional<Amazon> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Product Found with Id: "+id);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			repository.deleteById(id);
			map.put("message", "Product Deleted Success");
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}
	
	
}
		
	
		
	
		
 

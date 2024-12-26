package org.jsp.amazon_api.controller;

import java.util.List;

import org.jsp.amazon_api.dto.Amazon;
import org.jsp.amazon_api.service.AmazonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmazonController {
 
		
		@Autowired
		AmazonService service;
		
		
		@PostMapping("/products")
		public ResponseEntity<Object> saveProduct(@RequestBody Amazon amazon){
			return service.saveProduct(amazon);
		}
  
		
		@PostMapping("/products/many")
		public ResponseEntity<Object> saveProducts(@RequestBody List<Amazon> amazon){
			return service.saveProducts(amazon);
		}
		
		
		@GetMapping("/products")
		public ResponseEntity<Object> fetchAllProducts(){
			return service.fetchAllProducts();
		}
		
		
		@GetMapping("/products/{id}")
		public ResponseEntity<Object> fetchById(@PathVariable int id){
			return service.fetchById(id);
		}
		
		
		
		@GetMapping("/products/price/greater/{price}")
		public ResponseEntity<Object> fetchByPriceGreater(@PathVariable double price){
			return service.fetchByPriceGreater(price);
		}
		
		
		@GetMapping("/products/size/{size}")
		public ResponseEntity<Object> fetchBySize(@PathVariable String size){
			return service.fetchBySize(size);
		}
		
		//Fetch Product By Quantity
		@GetMapping("/products/quantity/{quantity}")
		public ResponseEntity<Object> fetchByQuantity(@PathVariable int quantity){
		return service.fetchByQuantity(quantity);
		}
		
		
		@GetMapping("/products/discount/{discount}")
		public ResponseEntity<Object> fetchByDiscount(@PathVariable String discount){
		return service.fetchByDiscount(discount);
			}
		
		
		@PutMapping("/products")
		public ResponseEntity<Object> updateRecord(@RequestBody Amazon amazon){
			return service.updateProduct(amazon);
		}
			
		
		@PatchMapping("/products/{id}")
		public ResponseEntity<Object> updateRecord(@PathVariable int id,@RequestBody Amazon product){
			return service.updateProduct(id,product);
		}
		
		
		@DeleteMapping("/products/{id}")
		public ResponseEntity<Object> deleteById(@PathVariable int id){
			return service.deleteById(id);
		}
  	}

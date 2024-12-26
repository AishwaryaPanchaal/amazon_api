package org.jsp.amazon_api.reposiroty;

import java.util.List;
import java.util.Optional;

import org.jsp.amazon_api.dto.Amazon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmazonRepository extends JpaRepository<Amazon, Integer>{

	List<Amazon> findByPriceGreaterThanEqual(double price);

	List<Amazon> findBySize(String size);

	Optional<Amazon> findByQuantity(int quantity);

	List<Amazon> findByDiscount(String discount);

		}

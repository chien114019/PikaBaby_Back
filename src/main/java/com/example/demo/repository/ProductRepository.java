package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.SupplierProduct;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNameContainingIgnoreCase(String name);
	
	@Query("SELECT sp FROM SupplierProduct sp JOIN FETCH sp.supplier JOIN FETCH sp.product")
	List<SupplierProduct> findAllWithDetails();
	
	List<Product> findByPublishedTrue();

	List<Product> findByDeletedFalse();

	Optional<Product> findById(Integer id);
	
	@Query("SELECT p FROM Product p WHERE p.deleted = :deleted AND LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Product> searchAvailable(@Param("keyword") String keyword, @Param("deleted") Boolean deleted);

	
	List<Product> findAllByPublishedTrueAndAge1True();

	List<Product> findAllByPublishedTrueAndAge2True();

	List<Product> findAllByPublishedTrueAndAge3True();

	List<Product> findAllByPublishedTrueAndAge4True();

	List<Product> findAllByPublishedTrueAndAge5True();
}

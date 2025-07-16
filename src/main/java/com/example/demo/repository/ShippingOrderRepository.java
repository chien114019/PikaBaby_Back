package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.SalesOrder;
import com.example.demo.model.ShippingOrder;

public interface ShippingOrderRepository extends JpaRepository<ShippingOrder, Integer> {
	ShippingOrder findBySalesOrder(SalesOrder order);
	
	@Query("""
			SELECT so FROM ShippingOrder so
			WHERE so.salesOrder.customer.name LIKE :keyword
			""")
	List<ShippingOrder> searchCustomerName(@Param("keyword") String keyword);
}
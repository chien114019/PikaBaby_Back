package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}



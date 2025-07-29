package com.example.accounts.repository;

import com.example.accounts.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerRepo extends JpaRepository<Customers,Integer> {
    Optional<Customers> findByContactNo(String contactNo);
}

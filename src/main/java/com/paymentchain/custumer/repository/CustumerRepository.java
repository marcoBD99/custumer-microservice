package com.paymentchain.custumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentchain.custumer.entities.Custumer;

public interface CustumerRepository extends JpaRepository<Custumer,Long>{
    
    
}
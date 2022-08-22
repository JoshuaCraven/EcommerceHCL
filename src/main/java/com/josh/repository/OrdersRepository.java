package com.josh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.josh.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}

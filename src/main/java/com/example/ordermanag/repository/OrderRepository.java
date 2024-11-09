package com.example.ordermanag.repository;

import com.example.ordermanag.entities.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

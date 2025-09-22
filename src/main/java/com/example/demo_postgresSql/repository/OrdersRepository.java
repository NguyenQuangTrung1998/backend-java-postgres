package com.example.demo_postgresSql.repository;

import com.example.demo_postgresSql.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
    List<Orders> findByCustomer_CusId(Long cusId);
}

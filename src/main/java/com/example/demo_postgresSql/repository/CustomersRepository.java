package com.example.demo_postgresSql.repository;

import com.example.demo_postgresSql.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {
@Query(value = """
        SELECT * FROM customers
        """,nativeQuery = true)
    List<Customers> getList();

}

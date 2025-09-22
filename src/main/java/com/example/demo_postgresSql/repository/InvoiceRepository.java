package com.example.demo_postgresSql.repository;

import com.example.demo_postgresSql.entity.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoices, Long> {
    @Query(value = """
            SELECT * FROM invoices inv WHERE inv.cus_id = :cusId
            """,nativeQuery = true)
    List<Invoices> getInvoicesByCustomer(@Param("cusId") Long cusId);

    Invoices findByOrder_OrsId(Long ordId);
}

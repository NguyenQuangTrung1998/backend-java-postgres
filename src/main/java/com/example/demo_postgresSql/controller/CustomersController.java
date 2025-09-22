package com.example.demo_postgresSql.controller;

import com.example.demo_postgresSql.dto.CustomerDto;
import com.example.demo_postgresSql.entity.Customers;
import com.example.demo_postgresSql.entity.Invoices;
import com.example.demo_postgresSql.entity.Orders;
import com.example.demo_postgresSql.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @GetMapping
    public List<Customers> getAllCustomers() {
        return customersService.getList();
    }

    @GetMapping("/{id}")
    public Customers getDetail(@PathVariable Long id) {
        return customersService.detail(id);
    }

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return customersService.getOrders();
    }

    @GetMapping("/{id}/orders")
    public List<Orders> getOrdersByCus(@PathVariable Long id) {
        return customersService.getOrdersByCusId(id);
    }

    @GetMapping("/invoices")
    public List<Invoices> fetchInvoices() {
        return customersService.getInvoices();
    }

    @GetMapping("/{orsId}/invoices")
    public Invoices fetchInvoiceByOrd(@PathVariable Long orsId) {
        return customersService.getInvoicesByOrder(orsId);
    }

    @GetMapping("/{cusId}/invoices-by-cus")
    public List<Invoices> getListInvoices(@PathVariable Long cusId) {
        return customersService.getInvoicesByCus(cusId);
    }

    @PostMapping
    public Customers createNewCus(@RequestBody CustomerDto customerDto) {
        return customersService.createCustomer(customerDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCus(@PathVariable Long id) {
        customersService.deleteCustomer(id);
        return "deleted";
    }
}

package com.example.demo_postgresSql.service;

import com.example.demo_postgresSql.dto.CustomerDto;
import com.example.demo_postgresSql.entity.Customers;
import com.example.demo_postgresSql.entity.Invoices;
import com.example.demo_postgresSql.entity.Orders;
import com.example.demo_postgresSql.repository.CustomersRepository;
import com.example.demo_postgresSql.repository.InvoiceRepository;
import com.example.demo_postgresSql.repository.OrdersRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;
   public List<Customers> getList(){
        return customersRepository.getList();
    }
    public Customers detail(Long id){
     return customersRepository.findById(id).orElseThrow(()-> new RuntimeException("not found!"));
    }
    public List<Orders> getOrders(){
       return ordersRepository.findAll();
    }
    public List<Orders> getOrdersByCusId(Long cusId){
        return ordersRepository.findByCustomer_CusId(cusId);
    }

    public List<Invoices> getInvoices(){
       return invoiceRepository.findAll();
    }

    public Invoices getInvoicesByOrder(Long id){
       return invoiceRepository.findByOrder_OrsId(id);
    }

    public  List<Invoices> getInvoicesByCus(Long id){
       return invoiceRepository.getInvoicesByCustomer(id);
    }

    public Customers createCustomer( CustomerDto customer){
        Customers customers = new Customers();
        if(customer.getCusAddress().equals("")
                ||customer.getCusAddress().isBlank()
                || customer.getCusName().equals("")
                || customer.getCusName().isBlank()
                || customer.getCusPhone().equals("")
                || customer.getCusPhone().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Customer data is invalid!");
        }
         String cusName = customer.getCusName();
         String cusAddress = customer.getCusAddress();
         String cusPhone = customer.getCusPhone();
         customers.setCusAddress(cusAddress);
         customers.setCusName(cusName);
         customers.setCusPhone(cusPhone);
         return customersRepository.save(customers);
    }


}

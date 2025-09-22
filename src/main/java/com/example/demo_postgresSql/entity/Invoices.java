package com.example.demo_postgresSql.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "inv_number")
    private Long invNumber;

    @Column(name = "cus_id")
    private Long cusId;

//    @Column(name = "ors_id")
//    private Long orsId;
    private Integer total;

    @OneToOne
    @JoinColumn(name = "ors_id")
    private Orders order;

    public Long getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(Long invNumber) {
        this.invNumber = invNumber;
    }

    public Long getCusId() {
        return cusId;
    }

    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}

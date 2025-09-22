package com.example.demo_postgresSql.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ors_id")
    private Long orsId;
    private String ors_name;
    private Integer ors_amounts;
    private String weight;

    @ManyToOne
    @JoinColumn(name = "cus_id") // khóa ngoại tham chiếu Customer
    private Customers customer;

    public Long getOrs_id() {
        return orsId;
    }

    public void setOrs_id(Long orsId) {
        this.orsId = orsId;
    }

    public String getOrs_name() {
        return ors_name;
    }

    public void setOrs_name(String ors_name) {
        this.ors_name = ors_name;
    }

    public int getOrs_amount() {
        return ors_amounts;
    }

    public void setOrs_amount(int ors_amount) {
        this.ors_amounts = ors_amount;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


}

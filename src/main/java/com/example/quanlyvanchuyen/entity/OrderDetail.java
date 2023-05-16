package com.example.quanlyvanchuyen.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailID;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "unitPrice")
    private String unitPrice;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private Order order;

    @OneToMany(mappedBy = "orderDetail")
    private List<Product> products;


    @OneToMany(mappedBy = "orderDetail")
    private List<Payment> payments;

    @ManyToOne
    @JoinColumn(name = "batch")
    private Batch batch;
}
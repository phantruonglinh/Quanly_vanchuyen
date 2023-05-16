package com.example.quanlyvanchuyen.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentID;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "paymentAmount")
    private String paymentAmount;

    @Column(name = "paymentDate")
    private String paymentDate;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "orderDetail")
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(name = "orders")
    private Order order;

}

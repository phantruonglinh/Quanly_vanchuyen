package com.example.quanlyvanchuyen.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  warehouseID;

    @Column(name = "warehouseName")
    private String warehouseName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "warehouse")
    private List<Order> orders;

    @OneToMany(mappedBy = "warehouse")
    private List<Batch> batches;
}

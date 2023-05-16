package com.example.quanlyvanchuyen.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchID;

    @Column(name = "batchDate")
    private String batchDate;

    @Column(name = "quantity")
    private String quantity;

    @OneToMany(mappedBy = "batch")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "batch")
    private List<TransportVehicle> transportVehicles;

    @ManyToOne
    @JoinColumn(name = "warehouse")
    private Warehouse warehouse;
}

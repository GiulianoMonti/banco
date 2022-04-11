package com.giulian.banco.model;


import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_code")
    private String orderTrackingNumber;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}


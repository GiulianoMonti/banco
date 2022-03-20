package com.giulian.banco.model;

import javax.persistence.*;

public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer stock;

}

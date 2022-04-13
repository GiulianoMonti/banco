package com.giulian.banco.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "shop_products")
@Getter
@Setter
public class ShopProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
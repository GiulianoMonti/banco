package com.giulian.banco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String cod;
    private Integer stock;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "product_shop",
//            joinColumns = @JoinColumn(
//                    name = "product_id", referencedColumnName = "id"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "shop_id", referencedColumnName = "id"
//            )
//    )
//    private Shop shop;
}

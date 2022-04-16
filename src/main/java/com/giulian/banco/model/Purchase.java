package com.giulian.banco.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    private Double total;

    @OneToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, targetEntity = PurchaseDetail.class,
            mappedBy = "purchase", orphanRemoval = true)
    private List<PurchaseDetail> details;

    private Long orderId;
    private String message;
}

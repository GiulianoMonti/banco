package com.giulian.banco.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder
@Table(name = "purchase")
public class Purchase implements Serializable {

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

    public Purchase(Client client, Double total, Shop shop, List details) {
        this.client = client;
        this.total = total;
        this.shop = shop;
        this.details = details;
    }

    public Purchase(){

    }
}

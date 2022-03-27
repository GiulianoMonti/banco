//package com.giulian.banco.model;
//
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "orders")
//@AllArgsConstructor
//@NoArgsConstructor
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private int totalQuantity;
//    private BigDecimal totalPrice;
//    private String status;
//
//    @CreationTimestamp
//    private LocalDateTime dateCreated;
//    @UpdateTimestamp
//    private LocalDateTime lastUpdated;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
//    private Address billingAddress;
//
//    // default fetch type for one to many is LAZY
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
//    private Set<OrderItem> orderItems = new HashSet<>();
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "client_id", referencedColumnName = "id")
//    private Client client;
//
//    public BigDecimal getTotalAmount(){
//        BigDecimal amount = new BigDecimal(0.0);
//        for(OrderItem item: this.orderItems){
//            amount = amount.add(item.getPrice());
//        }
//        return amount;
//    }
//
//}

package com.giulian.banco.controller;

import com.giulian.banco.model.Purchase;
import com.giulian.banco.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
//    private final ICheckoutService checkoutService;
    private final IOrderService orderService;

    public OrderController( IOrderService orderService) {
//        this.checkoutService = checkoutService;
        this.orderService = orderService;
    }


    @PostMapping("/purchase")
    public ResponseEntity<?> save(@RequestBody List<Purchase> purchases) {
        List<Purchase> purchaseProcess = orderService.save(purchases);
        return ResponseEntity
                .created(
                        URI.create(String.format("/arrangements/")))
                .body(purchaseProcess);
    }

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> findById(@PathVariable Long id) {
        Purchase purchase = orderService.findById(id);
        return ResponseEntity.ok().body(purchase);
    }
}

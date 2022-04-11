package com.giulian.banco.controller;

import com.giulian.banco.model.dto.Purchase;
import com.giulian.banco.model.dto.PurchaseResponse;
import com.giulian.banco.service.ICheckoutService;
import com.giulian.banco.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    public Purchase placeOrder(@RequestBody Purchase purchase) {

        Purchase purchaseResponse = orderService.placeOrder(purchase);

        return purchaseResponse;
    }
}

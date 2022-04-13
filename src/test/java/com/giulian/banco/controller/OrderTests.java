//package com.giulian.banco.controller;
//
//import com.giulian.banco.model.Address;
//import com.giulian.banco.model.Client;
//import com.giulian.banco.model.Order;
//import com.giulian.banco.model.ShopProduct;
//import com.giulian.banco.repository.ClientRepository;
//import com.giulian.banco.repository.OrderRepository;
//import com.giulian.banco.repository.ProductRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//
//@SpringBootTest
//public class OrderTests {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    // save order along with also save it's order items
//    @Test
//    void saveOrderMethod(){
//        Client client = new Client();
//        client.setName("Giuliano");
//        client.setEmail("giulianm@gmail.com");
//        client.setPhoto("giulian-photo");
//
//        Order order = new Order();
//        order.setStatus("In progress");
//
//        // create order item 1
//        ShopProduct orderItem1 = new ShopProduct();
//        orderItem1.setProduct(productRepository.findById(1L).get());
//        orderItem1.setQuantity(2);
//        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
//        orderItem1.setImageUrl("image1.png");
//        orderItem1.setOrder(order);
//        order.getOrderItems().add(orderItem1);
//
//        // create order item 2
//        ShopProduct orderItem2 = new ShopProduct();
//        orderItem2.setProduct(productRepository.findById(2L).get());
//        orderItem2.setQuantity(3);
//        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
//        orderItem2.setImageUrl("image2.png");
//        orderItem2.setOrder(order);
//        order.getOrderItems().add(orderItem2);
//
//        order.setTotalPrice(order.getTotalAmount());
//        order.setTotalQuantity(2);
//
//        Address address = new Address();
//        address.setCity("Pune");
//        address.setStreet("Kothrud");
//        address.setState("Maharashtra");
//        address.setCountry("India");
//        address.setZipCode("411047");
//        order.setBillingAddress(address);
//        client.getOrders().add(order);
//        order.setClient(client);
//
//        clientRepository.save(client);
////       orderRepository.save(order);
//    }
//
//
//}

package com.giulian.banco.service.impl;

import com.giulian.banco.model.*;
import com.giulian.banco.repository.*;
import com.giulian.banco.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {
    /*TODO Un Cliente puede realizar pedidos de uno
       varios productos a una/varias tiendas al mismo tiempo
       (cree el/los servicios necesarios para esto)*/
    private final OrderRepository orderRepository;

    private final ShopProductRepository shopProductRepository;

    private final ProductRepository productRepository;
    private final PurchaseDetailRepository purchaseDetailRepository;
    private final ClientRepository clientRepository;

    private final ShopRepository shopRepository;




    public OrderServiceImpl(OrderRepository orderRepository,
                            ShopProductRepository shopProductRepository, ProductRepository productRepository,
                            PurchaseDetailRepository orderDetailRepository,
                            ClientRepository clientRepository,
                            ShopRepository shopRepository) {
        this.orderRepository = orderRepository;
        this.shopProductRepository = shopProductRepository;
        this.productRepository = productRepository;
        this.purchaseDetailRepository = orderDetailRepository;
        this.clientRepository = clientRepository;
        this.shopRepository = shopRepository;
    }


    @Override
    public List<Purchase> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Purchase findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("inventory no found."));
    }


    public List<Purchase> save(List<Purchase> purchase) {

        return purchase.stream()
                .map(order -> {
                    Client clientModel =
                            clientRepository.findByUsername
                                    ((order.getClient()
                                            .getUsername())).get();

                    List<PurchaseDetail> details = order.getDetails().stream().


                            map(detail -> {
                                Product db =
                                        productRepository.findById(
                                                detail.getProduct().getId()).get();
                                Shop dbShop =
                                        shopRepository.findById(
                                                detail.getShop().getId()).get();

                                detail.setTotal(db.getPrice() * detail.getQuantity());
                                detail.setProduct(db);
                                detail.setPurchase(order);
                                detail.setShop(dbShop);

                                checkStock(db, detail.getQuantity(), dbShop);
                                return detail;
                            }).collect(Collectors.toList());
                    order.setClient(clientModel);
                    order.setTotal(details.stream().mapToDouble(PurchaseDetail::getTotal).sum());
                    return orderRepository.saveAndFlush(order);
                }).collect(Collectors.toList());

    }

    private Product checkStock(Product dbProduct, int quantity, Shop dbShop) {

        ShopProduct dbShopProductRepository =
                shopProductRepository.findByShopAndProduct(dbShop, dbProduct)
                        .orElseThrow(() -> new RuntimeException("No se encontro el producto" +
                                "en el shop elegido"));


        log.info("Stock actual: " + dbShopProductRepository.getProduct().getStock());

        Integer st = dbShopProductRepository.getProduct().getStock() - quantity;
//        Integer stock = dbProduct.getStock()-quantity;

        return productRepository.findById(dbProduct.getId())
                .map(product -> {
                    product.setStock(st);

                    return this.productRepository.save(product);
                }).orElseThrow();
    }
}

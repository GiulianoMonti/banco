package com.giulian.banco.service.impl;

import com.giulian.banco.exception.ResourceNotFoundException;
import com.giulian.banco.model.*;
import com.giulian.banco.repository.*;
import com.giulian.banco.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {
    /*TODO Un Cliente puede realizar pedidos de uno
       varios productos a una/varias tiendas al mismo tiempo
       (cree el/los servicios necesarios para esto)*/
    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;
    private final PurchaseDetailRepository orderDetailRepository;
    private final ClientRepository clientRepository;

    private final ShopRepository shopRepository;


    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductRepository productRepository,
                            PurchaseDetailRepository orderDetailRepository,
                            ClientRepository clientRepository,
                            ShopRepository shopRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.clientRepository = clientRepository;
        this.shopRepository = shopRepository;
    }

    public List<Purchase> save(List<Purchase> purchase) {

        return purchase.stream()
                .map(order -> {
                    Client clientModel =
                            clientRepository.findByUsername
                                    ((order.getClient()
                                            .getUsername())).get();

                    Shop shopModel =
                            shopRepository.findById(order.getShop().getId()).get();

                    List<PurchaseDetail> details = order.getDetails().stream().


                            map(detail -> {
                                Product db =
                                        productRepository.findById(
                                                detail.getProduct().getId()).get();

                                detail.setTotal(db.getPrice() * detail.getQuantity());
                                detail.setProduct(db);
                                detail.setPurchase(order);
                                checkStock(db, detail.getQuantity());
                                return detail;
                            }).collect(Collectors.toList());
                    order.setClient(clientModel);
                    order.setShop(shopModel);
                    order.setTotal(details.stream().mapToDouble(PurchaseDetail::getTotal).sum());
                    return orderRepository.saveAndFlush(order);
                }).collect(Collectors.toList());

    }

    private Product checkStock(Product db, int quantity) {
        Integer stock = db.getStock()-quantity;

        return productRepository.findById(db.getId()).map(product -> {product.setStock(stock);
            return this.productRepository.save(product);
        }).orElseThrow();
    }
}


//    public Order save(Order order) {
//        return orderRepository.save(order);
//    }
//
//    @Override
//    @Transactional
//    public Purchase placeOrder(Purchase purchase) {
//
//        Client client =
//                clientRepository.findById
//                        (purchase.getClientId()).orElseThrow();
//        purchase.setClient(client);
//
//
//        Order order = new Order();
//        order.setClient(purchase.getClient());
//        order.setOrderTrackingNumber("1234L");
//        order = save(order);
//
//        purchase.setOrderId(order.getId());
//
//        Order finalOrder = order;
//
//        purchase.getOrderDetailClients().forEach(dp -> {
//
//            ShopProduct shopProduct = dp.getShopProduct();
//
////            verificarAgregarStock(tiendaProductos.getProducto(), dp.getCantidad());
////            restarStock(tiendaProductos.getProducto(), dp.getCantidad());
//
//            PurchaseDetail orderDetail = new PurchaseDetail();
//            orderDetail.setOrder(finalOrder);
//            orderDetail.setQuantity(dp.getQuantity());
//            orderDetail.setShopProduct(shopProduct);
//            orderDetailRepository.save(orderDetail);
//
////            tiendaTransaccionService.registoMovimientoTienda
////                    (pedidoCliente.getCliente(), tiendaProductos.getTienda(),
////                            tiendaProductos.getProducto(), dp.getCantidad());
//        });
//        return purchase;
//
//    }


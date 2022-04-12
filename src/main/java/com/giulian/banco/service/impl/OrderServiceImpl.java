package com.giulian.banco.service.impl;

import com.giulian.banco.model.*;
import com.giulian.banco.model.dto.Purchase;
import com.giulian.banco.model.dto.PurchaseResponse;
import com.giulian.banco.repository.ClientRepository;
import com.giulian.banco.repository.OrderDetailRepository;
import com.giulian.banco.repository.OrderRepository;
import com.giulian.banco.service.IOrderDetailService;
import com.giulian.banco.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class OrderServiceImpl implements IOrderService {
    /*TODO Un Cliente puede realizar pedidos de uno
       varios productos a una/varias tiendas al mismo tiempo
       (cree el/los servicios necesarios para esto)*/
    private OrderRepository orderRepository;

    private IOrderDetailService orderDetailService;
    private OrderDetailRepository orderDetailRepository;
    private ClientRepository clientRepository;

    public OrderServiceImpl(OrderRepository orderRepository,


                            ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
//        this.orderDetailService = orderDetailService;
//        this.orderDetailRepository = orderDetailRepository;
        this.clientRepository = clientRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Purchase placeOrder(Purchase purchase) {

        Client client =
                clientRepository.findById
                        (purchase.getClientIdentification()).orElseThrow();
        purchase.setClient(client);


        Order order = new Order();
        order.setClient(purchase.getClient());
        order.setOrderTrackingNumber("123L");
        order = save(order);

        purchase.setOrderId(order.getId());
        Order finalOrder = order;
        purchase.getOrderDetailClients().forEach(dp -> {
            OrderItem orderItem = dp.getOrderItem();

//            verificarAgregarStock(tiendaProductos.getProducto(), dp.getCantidad());
//            restarStock(tiendaProductos.getProducto(), dp.getCantidad());

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(finalOrder);
            orderDetail.setQuantity(dp.getQuantity());
            orderDetail.setOrderItem(orderItem);
            orderDetailRepository.save(orderDetail);

//            tiendaTransaccionService.registoMovimientoTienda
//                    (pedidoCliente.getCliente(), tiendaProductos.getTienda(),
//                            tiendaProductos.getProducto(), dp.getCantidad());
        });
        return purchase;

    }

}


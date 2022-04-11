package com.giulian.banco.model.dto;

import com.giulian.banco.model.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class Purchase {

    private String clientIdentification;
    private Client client;
    private List<OrderDetailClient> orderDetailClients;
    private Long orderId;
    private String message;
}

package com.giulian.banco.model.dto;

import com.giulian.banco.model.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailClient {

    private String shopCode;
    private String productCode;
    private OrderItem orderItem;
    private Long quantity;

}

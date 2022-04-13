package com.giulian.banco.model.dto;

import com.giulian.banco.model.ShopProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailClient {

    private String shopCode;
    private String productCode;
    private ShopProduct shopProduct;
    private Long quantity;

}

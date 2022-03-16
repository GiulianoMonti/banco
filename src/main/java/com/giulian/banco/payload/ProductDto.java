package com.giulian.banco.payload;

import com.giulian.banco.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDto {
    private Long id;
    @NotNull(message = "{error.empty}")
    private String name;
    @NotNull(message = "{error.empty}")
    private Double price;
    @NotNull(message = "{error.empty}")
    private Integer stock;

}

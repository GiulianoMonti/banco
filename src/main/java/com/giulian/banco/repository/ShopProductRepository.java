package com.giulian.banco.repository;

import com.giulian.banco.model.OrderItem;
import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShopProductRepository extends JpaRepository<OrderItem, Long> {


    OrderItem findByShopAndProduct(Shop shop, Product product);

    Optional<List<OrderItem>> findByShopId(Long shopId);

    Optional<OrderItem> findById(Long shopId);


}

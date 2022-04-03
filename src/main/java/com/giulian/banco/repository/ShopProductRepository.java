package com.giulian.banco.repository;

import com.giulian.banco.model.Product;
import com.giulian.banco.model.Role;
import com.giulian.banco.model.Shop;
import com.giulian.banco.model.ShopProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {


    ShopProduct findByShopAndProduct(Shop shop, Product product);
}

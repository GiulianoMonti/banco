package com.giulian.banco.repository;

import com.giulian.banco.model.ShopProduct;
import com.giulian.banco.model.Product;
import com.giulian.banco.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShopProductRepository extends JpaRepository<ShopProduct, Long> {


    Optional<ShopProduct> findByShopAndProduct(Shop shop, Product product);

    Optional<List<ShopProduct>> findByShopId(Long shopId);

    Optional<ShopProduct> findById(Long shopId);


}

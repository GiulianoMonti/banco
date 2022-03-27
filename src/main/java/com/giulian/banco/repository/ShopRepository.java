package com.giulian.banco.repository;

import com.giulian.banco.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {
    boolean existsByName(String name);
}

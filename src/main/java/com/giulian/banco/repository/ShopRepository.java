package com.giulian.banco.repository;

import com.giulian.banco.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    boolean existsByName(String name);

    Optional<Shop> findById(Long shopId);

}

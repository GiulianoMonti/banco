package com.giulian.banco.repository;

import com.giulian.banco.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {

    Optional<Client> findByEmail(String email);
    Optional<Client> findByUsernameOrEmail(String username, String email);
    Optional<Client> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}

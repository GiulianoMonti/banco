package com.giulian.banco.security;


import com.giulian.banco.model.Client;
import com.giulian.banco.model.Role;
import com.giulian.banco.repository.ClientRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private ClientRepository clientRepository;

    public CustomUserDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(client.getEmail(),
                client.getPassword(), mapRolesToAuthorities(client.getRoles()));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}

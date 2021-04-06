package br.com.condoencomenda.api.service.impl;

import br.com.condoencomenda.api.entity.User;
import br.com.condoencomenda.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername( String name) throws UsernameNotFoundException {
        User user = this.repository.findByUser(name);
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), Arrays.asList(authority));
    }

}

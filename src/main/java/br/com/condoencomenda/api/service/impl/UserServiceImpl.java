package br.com.condoencomenda.api.service.impl;

import br.com.condoencomenda.api.entity.User;
import br.com.condoencomenda.api.repository.UserRepository;
import br.com.condoencomenda.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User getUser(Long id){
        Optional< User > user = userRepository.findById(id);

        if(user.equals( Optional.empty() )){
            return null;
        }

        else return user.get();
    }

}

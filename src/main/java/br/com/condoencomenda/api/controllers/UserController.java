package br.com.condoencomenda.api.controllers;

import br.com.condoencomenda.api.dto.UserDto;
import br.com.condoencomenda.api.entity.User;
import br.com.condoencomenda.api.repository.UserRepository;
import br.com.condoencomenda.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value="/{id}")
    public ResponseEntity< UserDto > getUser( @PathVariable Long id ){
        User user = userService.getUser( id );

        UserDto userDto =  Optional.ofNullable( user )
                .map( u -> UserDto.builder()
                        .name( u.getName() )
                        .user( u.getUser() )
                        .id( u.getId() )
                        .build()
                )
                .orElse( null );

        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }
}

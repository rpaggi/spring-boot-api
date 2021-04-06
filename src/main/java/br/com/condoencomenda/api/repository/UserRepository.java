package br.com.condoencomenda.api.repository;

import br.com.condoencomenda.api.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository< User, Long> {
    User findByUser( String user );
}

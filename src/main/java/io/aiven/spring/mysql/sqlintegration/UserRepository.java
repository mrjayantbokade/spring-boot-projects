package io.aiven.spring.mysql.sqlintegration;

import org.springframework.data.repository.CrudRepository;
import io.aiven.spring.mysql.sqlintegration.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);
}

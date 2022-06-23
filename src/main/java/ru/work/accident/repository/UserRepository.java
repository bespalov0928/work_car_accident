package ru.work.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.work.accident.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}

package ru.work.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.work.accident.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}

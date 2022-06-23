package ru.work.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.work.accident.model.Rule;


public interface RuleRepository extends CrudRepository<Rule, Integer> {
}

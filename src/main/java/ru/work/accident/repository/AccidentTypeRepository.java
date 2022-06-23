package ru.work.accident.repository;

import org.springframework.data.repository.CrudRepository;
import ru.work.accident.model.AccidentType;

public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {

}

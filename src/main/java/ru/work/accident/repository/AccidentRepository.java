package ru.work.accident.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.work.accident.model.Accident;

import java.util.List;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    @Query("select distinct a from Accident as a join fetch a.rules join fetch a.type")
    public List<Accident> findAll();

}

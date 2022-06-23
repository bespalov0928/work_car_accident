package ru.work.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.work.accident.model.Accident;
import ru.work.accident.model.AccidentType;
import ru.work.accident.model.Rule;
import ru.work.accident.repository.AccidentRepository;
import ru.work.accident.repository.AccidentTypeRepository;
import ru.work.accident.repository.RuleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentServiceSpring {
    private final AccidentRepository accRepository;
    private final AccidentTypeRepository accTypeRepository;
    private final RuleRepository ruleRepository;

    public AccidentServiceSpring(AccidentRepository accRepository, AccidentTypeRepository accTypeRepository, RuleRepository ruleRepository) {
        this.accRepository = accRepository;
        this.accTypeRepository = accTypeRepository;
        this.ruleRepository = ruleRepository;
    }
    public List<Accident> findAllAccidents() {
        List<Accident> rsl = accRepository.findAll();
        return rsl;
    }

    @Transactional
    public void add(Accident accident, String[] idArray) {
        for (String index : idArray) {
            System.out.println(index);
            Optional<Rule> rule = ruleRepository.findById(Integer.valueOf(index));
            Rule rsl = rule.get();
            accident.addRule(rsl);
        }
        accRepository.save(accident);
    }

    public Accident findById(Integer id) {
        Optional<Accident> acc = accRepository.findById(Integer.valueOf(id));
        Accident rsl = acc.get();
        return rsl;
    }

    public List<AccidentType> findAllAccidentType() {
        List<AccidentType> rsl = (List<AccidentType>) accTypeRepository.findAll();
        return rsl;
    }

    public List<Rule> findAllRule() {
        List<Rule> rsl = (List<Rule>) ruleRepository.findAll();
        return rsl;
    }

}

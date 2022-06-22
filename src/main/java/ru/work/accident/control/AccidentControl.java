package ru.work.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.work.accident.model.Accident;
import ru.work.accident.model.AccidentType;
import ru.work.accident.model.Rule;
import ru.work.accident.repository.AccidentMem;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

//    public AccidentControl() {}

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = new ArrayList<>();
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        model.addAttribute("types", types);
        List<Rule> rules = new ArrayList<>();
        rules.add(Rule.of(1, "Статья. 1"));
        rules.add(Rule.of(2, "Статья. 2"));
        rules.add(Rule.of(3, "Статья. 3"));
        model.addAttribute("rules", rules);

        return "accident/create";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] idArray = req.getParameterValues("rIds");
        String[] idArrayType = req.getParameterValues("type.id");

        Rule rule = accidents.findByIdRule(Integer.valueOf(Arrays.stream(idArray).findFirst().get()));
        AccidentType accidentType = accidents.findByIdType(Integer.valueOf(Arrays.stream(idArrayType).findFirst().get()));

        accident.addRule(rule);
        accident.setType(accidentType);

        accidents.add(accident);
        String[] ids = req.getParameterValues("rIds");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidents.findAllAccidentType();
        List<Rule> rules = accidents.findAllRule();
        model.addAttribute("types", types);
        model.addAttribute("accident", accidents.findById(id));
        model.addAttribute("rules", rules);
        return "accident/update";
    }
}

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
import ru.work.accident.service.AccidentServiceSpring;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class AccidentControl {
    private final AccidentServiceSpring accidents;
    public AccidentControl(AccidentServiceSpring accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<AccidentType> types = accidents.findAllAccidentType();
        model.addAttribute("types", types);

        List<Rule> rules = accidents.findAllRule();
        model.addAttribute("rules", rules);

        return "accident/create";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {

        String[] idArray = req.getParameterValues("rIds");
        accidents.add(accident, idArray);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        List<AccidentType> types = accidents.findAllAccidentType();
        List<Rule> rules = accidents.findAllRule();
        Accident accident = accidents.findById(id);
        model.addAttribute("types", types);
        model.addAttribute("accident", accident);
        model.addAttribute("rules", rules);
        return "accident/update";
    }
}

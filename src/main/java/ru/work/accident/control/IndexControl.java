package ru.work.accident.control;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.work.accident.model.Accident;
import ru.work.accident.service.AccidentServiceSpring;

import java.util.List;

@Controller
public class IndexControl {
    private final AccidentServiceSpring accidentService;

    public IndexControl(AccidentServiceSpring accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> accidentList = null;
        accidentList = accidentService.findAllAccidents();
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", accidentList);
        return "index";

    }

}

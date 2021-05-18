package com.example.com.java.trainee.controller;


import com.example.com.java.trainee.entity.Trainee;
import com.example.com.java.trainee.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TraineeController {
    @Autowired
    private TraineeService service;
    @RequestMapping("/trainees")
    public String viewHomePage(Model model) {
        List<Trainee> trainees = service.listAll();
        System.out.println(trainees);
        model.addAttribute("trainees", trainees);

        return "trainees";
    }

    @RequestMapping("/new")
    public String showNewTraineePage(Model model) {
        Trainee trainee = new Trainee();
        model.addAttribute("trainee", trainee);

        return "new_trainee";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("trainee") Trainee trainee) {
        service.save(trainee);

        return "redirect:/trainees";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTraineePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_trainee");
        Trainee trainee = service.get(id);
        mav.addObject("trainee", trainee);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteTrainee(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/trainees";
    }
}

package com.proj.controller;

import com.proj.data.DeveloperRepository;
import com.proj.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Developer developer) {
        return "add-developer.html";
    }

    @PostMapping("/adddeveloper")
    public String addDeveloper(@Valid Developer developer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-developer.html";
        }

        developerRepository.save(developer);
        model.addAttribute("developers", developerRepository.findAll());
        return "index.html";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid developer id:" + id));

        model.addAttribute("developer", developer);
        return "update-developer.html";
    }

    @PostMapping("/update/{id}")
    public String updateDeveloper(@PathVariable("id") long id, @Valid Developer developer,
                                  BindingResult result, Model model) {
        if (result.hasErrors()) {
            developer.setId(id);
            return "update-developer.html";
        }

        developerRepository.save(developer);
        model.addAttribute("developers", developerRepository.findAll());
        return "index.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid developer id:" + id));
        developerRepository.delete(developer);
        model.addAttribute("developers", developerRepository.findAll());
        return "index.html";
    }
}

package io.aets.WaterTaxationBackend.controller;


import io.aets.WaterTaxationBackend.model.Subscriber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("/")
    public String showUserList(Model model) {
        return "home/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "sign-in/index";
    }
}

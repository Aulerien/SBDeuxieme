package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccueilController {

    @RequestMapping(value = "/Accueil", method = RequestMethod.GET)
    public String showPage(Model model){
        return "Pages/Accueil/index";
    }
}

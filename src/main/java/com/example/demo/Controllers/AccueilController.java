package com.example.demo.Controllers;

import com.example.demo.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

@Controller
public class AccueilController {


    @RequestMapping(value = "/Accueil", method = RequestMethod.GET)
    public String showPage(Model model, HttpServletRequest request) throws FileNotFoundException {

        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }

        model.addAttribute("utilisateur",request.getSession().getAttribute("utilisateur"));
        return "Pages/Accueil/index";
    }
}

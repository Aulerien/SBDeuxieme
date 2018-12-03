package com.example.demo.Controllers;
import com.example.demo.Services.PharmacieService;
import com.example.demo.Services.VilleService;
import com.example.demo.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PharmacieController {


    private final PharmacieService pharmacieService;
    private final VilleService villeService;
    @Autowired
    public PharmacieController(PharmacieService pharmacieService, VilleService villeService) {
        this.pharmacieService = pharmacieService;
        this.villeService = villeService;
    }


    @RequestMapping(value = "/Pharmacie", method = RequestMethod.GET)
    public String showPage(Model model, HttpServletRequest request){

        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }

        model.addAttribute("utilisateur",request.getSession().getAttribute("utilisateur"));

        return "Pages/Pharmacie/index";
    }
}

package com.example.demo.Controllers;
import com.example.demo.Services.PharmacieService;
import com.example.demo.Services.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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
    public String showPage(Model model){
        return "Pages/Pharmacie/index";
    }
}

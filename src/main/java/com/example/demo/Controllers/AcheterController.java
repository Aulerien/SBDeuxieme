package com.example.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
public class AcheterController {


    @RequestMapping(value = "/Acheter", method = RequestMethod.GET)
    public String showPage(Model model) throws IOException, MessagingException {
        return "Pages/Acheter/index";
    }




}

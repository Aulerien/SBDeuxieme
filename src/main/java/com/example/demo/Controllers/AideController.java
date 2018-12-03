package com.example.demo.Controllers;


import com.example.demo.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class AideController {


    @RequestMapping(value = "/Aide", method = RequestMethod.GET)
    public String showPage(Model model, HttpServletRequest request) throws IOException, MessagingException {


        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }

        model.addAttribute("utilisateur",request.getSession().getAttribute("utilisateur"));
        return "Pages/Aide/index";
    }
}

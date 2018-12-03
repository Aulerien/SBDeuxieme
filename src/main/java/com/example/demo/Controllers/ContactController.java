package com.example.demo.Controllers;


import com.example.demo.Model.Contact;
import com.example.demo.Services.ContactService;
import com.example.demo.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ContactController {



    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) { this.contactService = contactService; }


    @RequestMapping(value = "/Contact", method = RequestMethod.GET)
    public String showPage(Model model, HttpServletRequest request) throws IOException, MessagingException {


        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }



        model.addAttribute("contact", new Contact());
        model.addAttribute("utilisateur",request.getSession().getAttribute("utilisateur"));
        return "Pages/Contact/index";
    }


    @RequestMapping(value = "/ajouter/Contact", method = RequestMethod.POST)
    public String ajouterContact(@ModelAttribute Contact contact, Model model) {

        contactService.createContact(contact);
        model.addAttribute("contactAjouter","Demande bien envoyée !!!");

        return "Pages/Contact/index";
    }
}

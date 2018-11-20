package com.example.demo.Controllers;


import com.example.demo.Model.Contact;
import com.example.demo.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
public class ContactController {

    private final ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) { this.contactService = contactService; }


    @RequestMapping(value = "/Contact", method = RequestMethod.GET)
    public String showPage(Model model) throws IOException, MessagingException {
        model.addAttribute("contact", new Contact());
        return "Pages/Contact/index";
    }


    @RequestMapping(value = "/ajouter/Contact", method = RequestMethod.POST)
    public String ajouterContact(@ModelAttribute Contact contact, Model model) {

        contactService.createContact(contact);
        model.addAttribute("contactAjouter","Demande bien envoyée !!!");

        return "Pages/Contact/index";
    }
}

package com.example.demo.Controllers;


import com.example.demo.Model.Message;
import com.example.demo.Model.Reponse;
import com.example.demo.Model.Utilisateur;
import com.example.demo.Services.MessageService;
import com.example.demo.Services.UtilisateurService;
import com.example.demo.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class AppelerController {

    private final MessageService messageService;
    private final UtilisateurService utilisateurService;



    @Autowired
    public AppelerController(UtilisateurService utilisateurService, MessageService messageService)
    {
        this.messageService = messageService;
        this.utilisateurService = utilisateurService;
    }



    @RequestMapping(value = "/Appeler", method = RequestMethod.GET)
    public String showPage(Model model, HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }


        List<Utilisateur> utilisateurList = utilisateurService.getAllUtilisateur();
        List<Message> messageList = messageService.getAllMessage();
        Message message = new Message();

        Utilisateur utilisateurSession = (Utilisateur)request.getSession().getAttribute("utilisateur");

        List<Reponse> reponses = new ArrayList<Reponse>();

        for (int j = 0; j < utilisateurList.size(); j++ )
        {
            int nbMessage = 0;

            if(!Objects.equals(utilisateurSession.getId(), utilisateurList.get(j).getId()))
            {
                for(int i = 0; i < messageList.size(); i++ )
                {
                    if(Objects.equals(messageList.get(i).getMessageto(), utilisateurSession.getId()) || Objects.equals(messageList.get(i).getUtilisateur().getId(), utilisateurSession.getId()))
                    {
                        if(Objects.equals(messageList.get(i).getMessageto(), utilisateurList.get(j).getId()) || Objects.equals(messageList.get(i).getUtilisateur().getId(), utilisateurList.get(j).getId()))
                        {
                            nbMessage = nbMessage + 1;
                        }

                    }

                }
            }

            reponses.add(new Reponse(utilisateurList.get(j).getId(),nbMessage));

        }



        model.addAttribute("utilisateurs", utilisateurList);
        model.addAttribute("utilisateur", request.getSession().getAttribute("utilisateur"));
        model.addAttribute("messages", messageList);
        model.addAttribute("nouveauMessage", message);
        model.addAttribute("reponses", reponses);

        return "Pages/Appeler/index";
    }

}

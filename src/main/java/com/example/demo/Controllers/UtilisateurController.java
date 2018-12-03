package com.example.demo.Controllers;


import com.example.demo.Model.Utilisateur;
import com.example.demo.Services.UtilisateurService;
import com.example.demo.Utils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class UtilisateurController {

    @Value("${upload.path}")
    private String UPLOADED_FOLDER;


    private final UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService)
    {
        this.utilisateurService = utilisateurService;
    }



    @RequestMapping(value = "/Utilisateur", method = RequestMethod.GET)
    public String afficherUtilisateur(Model model, HttpServletRequest request)
    {
        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }

        List<Utilisateur> utilisateurList = utilisateurService.getAllUtilisateur();

        model.addAttribute("utilisateurs", utilisateurList);
        model.addAttribute("utilisateur", request.getSession().getAttribute("utilisateur"));
        model.addAttribute("nouveauUtilisateur", new Utilisateur());
        return "Pages/Utilisateur/index";

    }



    @RequestMapping(value = "/Utilisateur/Ajouter", method = RequestMethod.POST)
    public String ajouterUtilisateur(Model model,
                                     HttpServletRequest request,
                                     @RequestParam(value = "username") String username,
                                     @RequestParam(value = "password") String password,
                                     @RequestParam(value = "description") String description,
                                     @RequestParam(value = "imageUser") MultipartFile imageFile) throws IOException, NoSuchAlgorithmException {
        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }



        MultipartFile multipartFile = imageFile;
        imageFile.getOriginalFilename();
        String nomImage = "";


        if (!multipartFile.isEmpty()) {
            // Le type du fichier
            String extention = FilenameUtils.getExtension(multipartFile.getOriginalFilename()).toLowerCase();

            if(Objects.equals(extention, "jpeg") || Objects.equals(extention, "jpg") || Objects.equals(extention, "tif") || Objects.equals(extention, "png") || Objects.equals(extention, "gif"))
            {
                String fileName = multipartFile.getOriginalFilename();
                InputStream is = multipartFile.getInputStream();
                nomImage = fileName;
                Date date = new Date();
                nomImage =  date.getTime()+fileName;
                Files.copy(is, Paths.get(UPLOADED_FOLDER + nomImage), StandardCopyOption.REPLACE_EXISTING);


            }else
            {
                return  "redirect:/Utilisateur";
            }

        }

        // Envoyer En base de données
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setDescription(description);
        utilisateur.setUsername(username);
        utilisateur.setImage(nomImage);
        utilisateur.setPassword(Utils.Crypter(password));
        utilisateurService.createUtilisateur(utilisateur);


        List<Utilisateur> utilisateurList = utilisateurService.getAllUtilisateur();
        model.addAttribute("utilisateur", request.getSession().getAttribute("utilisateur"));
        model.addAttribute("utilisateurs", utilisateurList);
        return  "redirect:/Utilisateur";

    }

}

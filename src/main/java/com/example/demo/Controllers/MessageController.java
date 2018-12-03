package com.example.demo.Controllers;

import com.example.demo.Model.Message;
import com.example.demo.Services.MessageService;
import com.example.demo.Services.UtilisateurService;
import com.example.demo.Utils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import java.util.Date;

@Controller
public class MessageController {

    @Value("${upload.path.message}")
    private String UPLOADED_FOLDER;

    private final MessageService messageService;
    private final UtilisateurService utilisateurService;
    @Autowired
    public MessageController(UtilisateurService utilisateurService, MessageService messageService)
    {
        this.messageService = messageService;
        this.utilisateurService = utilisateurService;
    }



    @RequestMapping(value = "/envoyer/Message", method = RequestMethod.POST)
    public String envoyerMessage(Model model,
                                 HttpServletRequest request,
                                 @RequestParam(value = "idFrom") int idFrom,
                                 @RequestParam(value = "idTo") int idTo,
                                 @RequestParam(value = "fileImage") MultipartFile multipartFile,
                                 @ModelAttribute("nouveauMessage") Message nouveauMessage
    ) throws IOException {
        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }



        String nomImage = "";

        if (!multipartFile.isEmpty()) {
            // Le type du fichier
            String extention = FilenameUtils.getExtension(multipartFile.getOriginalFilename()).toLowerCase();

                String fileName = multipartFile.getOriginalFilename();
                InputStream is = multipartFile.getInputStream();
                nomImage = fileName;
                Date date = new Date();
                nomImage =  date.getTime()+fileName;
                Files.copy(is, Paths.get(UPLOADED_FOLDER + nomImage), StandardCopyOption.REPLACE_EXISTING);
        }


        Message nMessage = new Message();
        nMessage.setDate(new Date());
        nMessage.setContenu(nouveauMessage.getContenu());
        nMessage.setMessageto((long) idTo);
        nMessage.setImage(nomImage);
        nMessage.setUtilisateur(utilisateurService.getUtilisateur((long) idFrom));

        messageService.createMessage(nMessage);

        return "redirect:/Appeler";
    }
}

package com.example.demo.Controllers;


import com.example.demo.JsonReader;
import com.example.demo.Model.Article;
import com.example.demo.Model.Pays;
import com.example.demo.Services.PaysService;
import com.example.demo.Utils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InformationController {

    private final PaysService paysService;
    @Autowired
    public InformationController(PaysService paysService)
    {
        this.paysService = paysService;
    }



    @RequestMapping(value = "/Informations", method = RequestMethod.GET)
    public String showPage(Model model, HttpServletRequest request) throws IOException, MessagingException {

        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }

        model.addAttribute("utilisateur",request.getSession().getAttribute("utilisateur"));
        model.addAttribute("lesPays",paysService.getAllPays());
        return "Pages/Informations/index";
    }


    public List<Article> getInformations(String url) throws IOException {
        JSONObject reponse = JsonReader.readJsonFromUrl(url);
        JSONArray listBrute = (JSONArray) reponse.get("articles");
        List<Article> listArticle = new ArrayList<Article>();

        for (int i = 0; i < listBrute.length(); i++) {
            Article article = new Article();
            article.setAuthor(listBrute.getJSONObject(i).get("author").toString());
            article.setContent(listBrute.getJSONObject(i).get("content").toString());
            article.setDescription(listBrute.getJSONObject(i).get("description").toString());
            article.setPublishedAt(listBrute.getJSONObject(i).get("publishedAt").toString());
            article.setTitle(listBrute.getJSONObject(i).get("title").toString());
            article.setUrl(listBrute.getJSONObject(i).get("url").toString());
            article.setUrlToImage(listBrute.getJSONObject(i).get("urlToImage").toString());

            Article.Source source = new Article.Source();
            JSONObject sourceJson = listBrute.getJSONObject(i).getJSONObject("source");
            source.setId(sourceJson.get("id").toString());
            source.setName(sourceJson.get("name").toString());

            article.setSource(source);
            article.reorganiser();
            listArticle.add(article);
        }


        return listArticle;

    }



    @RequestMapping(value = "/information/Pays/{idPays}/{categorie}", method = RequestMethod.GET)
    public String afficherInformationPays(Model model,
                                          @PathVariable(value = "idPays") Long idPays,
                                          @PathVariable(value = "categorie") String categorie,
                                          HttpServletRequest request) throws IOException {
        if(!Utils.isAuthentified(request))
        {
            Utils.logout(request);
            return "redirect:/";
        }
        // Pas de Connexion Internet
        if(!Utils.netIsAvailable()) return "redirect:/Informations";

        Pays pays = paysService.getPays(idPays);
        model.addAttribute("utilisateur",request.getSession().getAttribute("utilisateur"));
        model.addAttribute("lesPays",paysService.getAllPays());
        model.addAttribute("pays",pays);

        switch (categorie) {
            case "Sport":
                List<Article> articlesSports = getInformations(pays.getSportLien());
                System.out.println(articlesSports.toString());
                model.addAttribute("articles", articlesSports);
                return "Pages/Informations/information";

            case "Sante":
                List<Article> articlesSante = getInformations(pays.getSanteLien());
                System.out.println(articlesSante.toString());
                model.addAttribute("articles", articlesSante);
                return "Pages/Informations/information";

            case "Divertissement":
                List<Article> articlesDivertissement = getInformations(pays.getDivertissementLien());
                System.out.println(articlesDivertissement.toString());
                model.addAttribute("articles", articlesDivertissement);
                return "Pages/Informations/information";


            case "Technologie":
                List<Article> articlesTechnologie = getInformations(pays.getTechnologiLien());
                System.out.println(articlesTechnologie.toString());
                model.addAttribute("articles", articlesTechnologie);
                return "Pages/Informations/information";


            case "Affaire":
                List<Article> articlesAffaire = getInformations(pays.getAffaireLien());
                System.out.println(articlesAffaire.toString());
                model.addAttribute("articles", articlesAffaire);
                return "Pages/Informations/information";


            default:
                return "redirect:/Informations";
        }





    }

}
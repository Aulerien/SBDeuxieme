package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    private static String UPLOADED_FOLDER = "src/main/resources/static/upload";

    public static File convertMutipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File(multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }


    public static Boolean saveImageFile(MultipartFile file)
    {
        try {

            /* Path dosssierDocument = Paths.get("/src/main/resources/static/upload");

            Path source = Paths.get(file.getAbsolutePath());

            Files.copy(source,dosssierDocument.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING); */

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            return  true;

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }



    public static String changeChar(String chaine, int idx, char monCharRempl) {
        char[] tab = chaine.toCharArray();
        tab[idx - 1] = monCharRempl;
        return String.valueOf(tab);
    }


    public static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }


    public static String Crypter(String motPasse) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {

        byte[] bytesOfMessage = motPasse.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);

        // Le hash est présent sous forme de tableau de byte
        BigInteger bigInt = new BigInteger(1,thedigest);
        String hashPass = bigInt.toString(16);
        while(hashPass.length() < 32 ){
            hashPass = "0"+hashPass;
        }

        return  hashPass;
    }


    public static Boolean isAuthentified(HttpServletRequest request)
    {
        return (request.getSession().getAttribute("utilisateur") != null );
    }



    public static void  logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        request.getSession(false);
    }

}


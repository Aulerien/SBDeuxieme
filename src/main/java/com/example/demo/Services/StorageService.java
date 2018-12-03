package com.example.demo.Services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {

    private Path rootLocation = null;


    private Boolean store(MultipartFile file, String Filename, String fileLocation ) throws IOException {
        try{
            rootLocation = Paths.get(fileLocation);
            if(Files.copy(file.getInputStream(),
                    this.rootLocation.resolve(Filename),
                    StandardCopyOption.REPLACE_EXISTING)>0)
            {
                return true;
            }
        }catch(Exception e){
            throw new RuntimeException("FAIL!" +e.getMessage());
        }

        return false;
    }




    public Resource loadFile(String filename) throws MalformedURLException {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }else{
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }



    public void deleteAll(String path) {
        if(path!=null && !path.isEmpty())
        {
            FileSystemUtils.deleteRecursively(Paths.get(path).toFile());

        }
        else
            FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }


}

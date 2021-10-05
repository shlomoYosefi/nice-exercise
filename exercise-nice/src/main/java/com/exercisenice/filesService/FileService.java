package com.exercisenice.filesService;

import com.exercisenice.models.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public abstract class FileService {

   static String basePath = "./src/main/java/com/exercisenice/fileOfDocuments";

    public static Boolean createFileDocument(Document document,String path){
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(path);
            mapper.writeValue(new File(basePath+path), document );
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Document redeFileDocument(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String pathName =basePath+path;
        Document document = objectMapper.readValue(new File(pathName), Document.class);
        return document;
    }


    public static Boolean deleteFileDocument(String path){
        File file = new File(basePath+path);
        if(file.delete())
        {
            System.out.println("deleted");
            return true;
        }
        else
        {
            System.out.println("Failed to delete the file");
            return false;
        }
    }
}

package com.exercisenice.filesService;

import com.exercisenice.models.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public abstract class FileService {

   static String basePath = "C:/Users/User/Desktop/nice/nice-exercise/exercise-nice/src/main/java/com/exercisenice/fileOfDocuments";

    public static String createFileDocument(Document document){
        ObjectMapper mapper = new ObjectMapper();
        try {
            String pathName = "/document"+document.getId()+".json";
            mapper.writeValue(new File(basePath+pathName), document );
            return pathName;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Document redeFileDocument(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String pathName =basePath+path;
        Document document = objectMapper.readValue(new File(pathName), Document.class);
        return document;
    }
}

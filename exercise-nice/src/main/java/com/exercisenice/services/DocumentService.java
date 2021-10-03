package com.exercisenice.services;


import com.exercisenice.ResponseServer;
import com.exercisenice.models.Document;
import com.exercisenice.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private ResponseServer responseServer = ResponseServer.getInstance();

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public ResponseEntity addDocument(Document document){
        try {
            documentRepository.save(document);
            responseServer.setResult("add success");
            ResponseEntity.status(200).body(responseServer);
        } catch (Exception e) {
            responseServer.setResult(e.getStackTrace());
            ResponseEntity.status(500).body(responseServer);
        }
        return ResponseEntity.status(200).body(responseServer);
    }



    public ResponseEntity getDocumentById(Long id){
                boolean exists = documentRepository.existsById(id);
                if (exists) {
                    return ResponseEntity.status(HttpStatus.OK).body(documentRepository.findById(id));
            }
            responseServer.setResult("document with id " + id +" does not exists");
            return ResponseEntity.status(500).body(responseServer);
    }



    public List<Document> getDocuments(){
        return documentRepository.findAll();
    }




    public ResponseEntity updateDocument(Document document){
        boolean exists = documentRepository.existsById(document.getId());
        if (exists) {
            documentRepository.save(document);
            responseServer.setResult("update success");
            return ResponseEntity.status(HttpStatus.OK).body(responseServer);
        }
        responseServer.setResult("document with id " + document.getId() +" does not exists");
        return ResponseEntity.status(200).body(responseServer);
    }




    public ResponseEntity deletDocument(Long id){
       try{
           documentRepository.deleteById(id);
           return  ResponseEntity.status(200).body("delete success");
        } catch (Exception e) {
           responseServer.setResult(e.getMessage());
           return ResponseEntity.status(502).body(responseServer);

       }

    }

























//    public ResponseEntity addDocument(Document document){
//        try {
//            documentRepository.save(document);
//            responseServer.setResult("add success");
//            ResponseEntity.status(200).body(responseServer);
//        } catch (Exception e) {
//            responseServer.setResult(e.getStackTrace());
//            ResponseEntity.status(500).body(responseServer);
//        }
//        return ResponseEntity.status(200).body(responseServer);
//    }
//
//
//
//    public ResponseEntity getDocumentById(Long id){
//        boolean exists = documentRepository.existsById(id);
//        if (exists) {
//            return ResponseEntity.status(HttpStatus.OK).body(documentRepository.findById(id));
//        }
//        responseServer.setResult("document with id " + id +" does not exists");
//        return ResponseEntity.status(500).body(responseServer);
//    }
//
//
//
//    public List<Document> getDocuments(){
//        return documentRepository.findAll();
//    }
//
//
//
//
//    public ResponseEntity updateDocument(Document document){
//        boolean exists = documentRepository.existsById(document.getId());
//        if (exists) {
//            documentRepository.save(document);
//            responseServer.setResult("update success");
//            return ResponseEntity.status(HttpStatus.OK).body(responseServer);
//        }
//        responseServer.setResult("document with id " + document.getId() +" does not exists");
//        return ResponseEntity.status(200).body(responseServer);
//    }
//
//
//
//
//    public ResponseEntity deletDocument(Long id){
//        try{
//            documentRepository.deleteById(id);
//            return  ResponseEntity.status(200).body("delete success");
//        } catch (Exception e) {
//            responseServer.setResult(e.getMessage());
//            return ResponseEntity.status(502).body(responseServer);
//
//        }
//
//    }
}

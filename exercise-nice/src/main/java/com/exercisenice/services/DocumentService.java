package com.exercisenice.services;


import com.exercisenice.filesService.FileService;
import com.exercisenice.models.DocumentTable;
import com.exercisenice.repositories.DocumentTableRepository;
import com.exercisenice.response.ResponseServer;
import com.exercisenice.models.Document;
import com.exercisenice.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentTableRepository documentTableRepository;


    private ResponseServer responseServer = ResponseServer.getInstance();

    @Autowired
    public DocumentService(DocumentRepository documentRepository, DocumentTableRepository documentTableRepository) {
        this.documentRepository = documentRepository;
        this.documentTableRepository = documentTableRepository;
    }


    public ResponseEntity addDocument(Document document){
        int id =1;
        if(document.getId()==0) {
            if (documentTableRepository.count() != 0) {
                id = documentTableRepository.findTopByOrderByIdDesc().getIdDoc() + 1;
                System.out.println(id);
            } else {
                id = 1;
            }
        }
        String path = "/document"+id+".json";
        DocumentTable doc = new DocumentTable(id,path);
        document.setId(id);
        try {
            documentTableRepository.save(doc);
            FileService.createFileDocument(document,path);
            responseServer.setResult("add success");
            ResponseEntity.status(200).body(responseServer);
        } catch (Exception e) {
            responseServer.setResult(e.getStackTrace());
            ResponseEntity.status(500).body(responseServer);
        }
        return ResponseEntity.status(200).body(responseServer);
    }



    public ResponseEntity getDocumentById(int id) throws IOException {
        boolean exists = documentTableRepository.existsByIdDoc(id);
        if (exists) {
            System.out.println(documentTableRepository.findByIdDoc(id).getPathName());
            return ResponseEntity.status(HttpStatus.OK).body(FileService.redeFileDocument(documentTableRepository.findByIdDoc(id).getPathName()));
        }
        responseServer.setResult("document with id " + id +" does not exists");
        return ResponseEntity.status(500).body(responseServer);
    }



    public List<Document> getDocuments() throws IOException {
        List<DocumentTable> documentTable = documentTableRepository.findAll();
        List<Document> documents = new ArrayList<>();
        for (DocumentTable d:documentTable) {
            documents.add(FileService.redeFileDocument(d.getPathName()));
        }
        return documents;
    }




    public ResponseEntity updateDocument(Document document){
        boolean exists = documentTableRepository.existsByIdDoc(document.getId());
        if (exists) {
            ResponseEntity res = addDocument(document);
            if(res.getStatusCode().is2xxSuccessful()){
                responseServer.setResult("update success");
                return ResponseEntity.status(HttpStatus.OK).body(responseServer);
            }
        }
        responseServer.setResult("document with id " + document.getId() +" does not exists");
        return ResponseEntity.status(200).body(responseServer);
    }




    public ResponseEntity deletDocument(int id) {
        try {
            DocumentTable d =documentTableRepository.findByIdDoc(id);
            String path =d.getPathName();
            documentTableRepository.deleteById(d.getId());
            FileService.deleteFileDocument(path);
            return ResponseEntity.status(200).body("delete success");
        } catch (Exception e) {
            responseServer.setResult(e.getMessage());
            return ResponseEntity.status(502).body(responseServer);
        }
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







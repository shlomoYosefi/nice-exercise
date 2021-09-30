package com.exercisenice.controllers;


import com.exercisenice.models.Document;
import com.exercisenice.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nice/documents")

public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }



    @PostMapping
    public ResponseEntity addDocument(@RequestBody Document document){
       return documentService.addDocument(document);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity getDocumentById(@PathVariable("id") Long id){
       return documentService.getDocumentById(id);
    }

    @GetMapping
    public List<Document> getAllDocument(){
        return documentService.getDocuments();
    }

    @PutMapping
    public ResponseEntity updateDocument(@RequestBody Document document){
        return documentService.updateDocument(document);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteDocument(@PathVariable("id") Long id ){
       return documentService.deletDocument(id);
    }


}

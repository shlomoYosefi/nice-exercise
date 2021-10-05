package com.exercisenice.services;

import com.exercisenice.controllers.DocumentController;
import com.exercisenice.models.Document;
import com.exercisenice.models.DocumentTable;
import com.exercisenice.repositories.DocumentTableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DocumentServiceTest {

    @Autowired
    DocumentTableRepository documentTableRepository;
    @Autowired
    DocumentController documentController;

    @Test
    void addDocumentTest() {
        //given
        Document document = new Document(1,"shlomo","yosefi");
        //when
        ResponseEntity response = documentController.addDocument(document);
        //then
        assertEquals(response.getStatusCodeValue(),200);
    }

    @Test
    void getDocumentByIdTest() throws IOException {
        //given
        int id = 0;
        //when
        ResponseEntity response = documentController.getDocumentById(id);
        //then
        assertEquals(response.getStatusCodeValue(),200);
    }

    @Test
    void getDocumentsTest() throws IOException {
        List documents = documentController.getAllDocument();
        assertNotEquals(documents.size(),0);
    }

    @Test
    void updateDocumentTest() throws IOException {
        //given
        Document document = new Document(0,"test","test");
        //when
        documentController.updateDocument(document);
        //then
        System.out.println(documentController.getDocumentById(1).getBody().getDocumentName());
//        assertEquals(documentController.getDocumentById(1).getBody().getDocumentName(),"test");
    }

    @Test
    void deletDocument() {
        documentController.deleteDocument(1);
        Boolean document = documentTableRepository.existsByIdDoc(1);
        assertTrue(!document);
    }
}
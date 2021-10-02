package com.exercisenice.services;

import com.exercisenice.models.Document;
import com.exercisenice.repositories.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DocumentServiceTest {

    @Autowired
    DocumentRepository documentRepository;

    @Test
    void addDocumentTest() {
        Document document = new Document("shlomo","yosefi");
        documentRepository.save(document);
        assertNotNull(documentRepository.findById(9L));
    }

    @Test
    void getDocumentByIdTest() {
        Document document = documentRepository.findById(8L).get();
        assertEquals("shlomo",document.getLabel());
    }

    @Test
    void getDocumentsTest() {
        List<Document> documents = documentRepository.findAll();
        assertNotEquals(documents.size(),0);
    }

    @Test
    void updateDocumentTest() {
        Document document = documentRepository.findById(8L).get();
        document.setLabel("yacov");
        documentRepository.save(document);
        assertEquals("yacov",document.getLabel());

    }

    @Test
    void deletDocument() {
        documentRepository.deleteById(9L);
        Boolean document = documentRepository.existsById(9L);
        assertTrue(!document);
    }
}
package com.exercisenice.models;


import javax.persistence.*;

@Entity
@Table
public class DocumentTable {

    @Id
    @SequenceGenerator(
            name= "documents_sequence",
            sequenceName = "documents_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "documents_sequence"
    )

    private Long id;
   private int idDoc;

    public DocumentTable() {
    }

    public DocumentTable(int idDoc, String pathName) {
        this.idDoc = idDoc;
        this.pathName = pathName;
    }

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    private String pathName;

    public DocumentTable(String pathName) {
        this.pathName = pathName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}

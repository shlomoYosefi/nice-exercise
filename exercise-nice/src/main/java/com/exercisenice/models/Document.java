package com.exercisenice.models;


import javax.persistence.*;

@Entity
@Table
public class Document {

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


    private int id;
    private String label;
    private String documentName;

    public Document() {
    }

    public Document(int id, String label, String documentName) {
        this.id = id;
        this.label = label;
        this.documentName = documentName;
    }

    public Document(String label, String documentName) {
        this.label = label;
        this.documentName = documentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", documentName='" + documentName + '\'' +
                '}';
    }
}

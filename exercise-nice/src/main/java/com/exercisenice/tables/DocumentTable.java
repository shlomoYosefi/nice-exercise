package com.exercisenice.tables;


import javax.persistence.*;

@Entity
@Table
public class DocumentTable {

    public static int counter = 1;

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

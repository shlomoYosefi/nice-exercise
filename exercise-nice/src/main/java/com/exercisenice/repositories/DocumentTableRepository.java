package com.exercisenice.repositories;

import com.exercisenice.models.DocumentTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTableRepository extends JpaRepository<DocumentTable,Long> {

    DocumentTable findByIdDoc(int i);
    void deleteByIdDoc(int i);
    Boolean existsByIdDoc(int i);
    DocumentTable findTopByOrderByIdDesc();


}

package com.CESI.accessingdatamysql;


import org.springframework.data.repository.CrudRepository;
import com.CESI.accessingdatamysql.CompteEpargne;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CompteEpargneRepository extends CrudRepository<CompteEpargne, Integer> {

}
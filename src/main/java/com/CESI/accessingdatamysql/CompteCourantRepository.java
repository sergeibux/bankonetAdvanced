package com.CESI.accessingdatamysql;


import org.springframework.data.repository.CrudRepository;
import com.CESI.accessingdatamysql.CompteCourant;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CompteCourantRepository extends CrudRepository<CompteCourant, Integer> {

}
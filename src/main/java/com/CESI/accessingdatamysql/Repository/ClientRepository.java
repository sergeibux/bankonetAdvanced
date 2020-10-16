package main.java.com.CESI.accessingdatamysql.Repository;


import main.java.com.CESI.accessingdatamysql.Entity.Client;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
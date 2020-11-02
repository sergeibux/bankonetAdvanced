package main.java.com.CESI.accessingdatamysql.Entity;

import main.java.com.CESI.accessingdatamysql.Entity.Compte;
import main.java.com.CESI.accessingdatamysql.Repository.ClientRepository;
import main.java.com.CESI.accessingdatamysql.Repository.CompteCourantRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity // This tells Hibernate to make a table out of this class
public class CompteEpargne extends Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdComteEpargne;

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    private double tauxInteret;


    public Integer getId() {
        return IdComteEpargne;
    }

    public void setId(Integer id) {
        this.IdComteEpargne = id;
    }



}

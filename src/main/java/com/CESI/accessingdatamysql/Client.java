package com.CESI.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Identifiant;

    private String Nom;

    private String Prenom;
    
    private Integer CompteCourant;
    
    private Integer CompteEpargne;

    public Integer getId() {
        return Identifiant;
    }

    public void setId(Integer id) {
        this.Identifiant = id;
    }

    public String get_nom() {
        return Nom;
    }

    public void set_nom(String name) {
        this.Nom = name;
    }

    public String get_prenom() {
        return Prenom;
    }

    public void set_prenom(String prenom) {
        this.Prenom = prenom;
    }

    public Integer getCompteCourant() {
        return CompteCourant;
    }

    public Integer getCourantEpargne() {
        return CompteEpargne;
    }
}

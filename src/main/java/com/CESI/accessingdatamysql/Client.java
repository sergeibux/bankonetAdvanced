package main.java.com.CESI.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Identifiant;

    private String nom;

    private String prenom;

    public Integer getId() {
        return Identifiant;
    }

    public void setId(Integer id) {
        this.Identifiant = id;
    }

    public String get_nom() {
        return nom;
    }

    public void set_nom(String name) {
        this.nom = name;
    }

    public String get_prenom() {
        return prenom;
    }

    public void set_prenom(String prenom) {
        this.prenom = prenom;
    }
}
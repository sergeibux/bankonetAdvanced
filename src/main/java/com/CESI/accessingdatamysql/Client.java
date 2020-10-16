package main.java.com.CESI.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Identifiant;

    private String Nom;

    private String Prenom;

    @OneToOne
    private CompteCourant CompteCourant;

    @OneToOne
    private CompteEpargne CompteEpargne;

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

    public CompteCourant getCompteCourant() {
        return CompteCourant;
    }

    public CompteEpargne getCourantEpargne() {
        return CompteEpargne;
    }
}

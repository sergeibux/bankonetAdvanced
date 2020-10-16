package main.java.com.CESI.accessingdatamysql;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer IdClient;

    private String Nom;

    private String Prenom;

    @OneToMany
    @JoinTable(name = "T_Compte_Courant_Client",
    joinColumns = @JoinColumn( name = "IdClient"),
    inverseJoinColumns = @JoinColumn( name = "IdCompteCourant"))
    private List<CompteCourant> CompteCourant = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "T_Compte_Epargne_Client",
    joinColumns = @JoinColumn( name = "IdClient"),
    inverseJoinColumns = @JoinColumn( name = "IdCompteEpargne"))
    private List<CompteEpargne> CompteEpargne = new ArrayList<>();

    public Integer getId() {
        return IdClient;
    }

    public void setId(Integer id) {
        this.IdClient = id;
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

    public List<CompteCourant> getCompteCourant() {
        return CompteCourant;
    }

    public List<CompteEpargne> getCourantEpargne() {
        return CompteEpargne;
    }
}

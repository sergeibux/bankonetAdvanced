package main.java.com.CESI.accessingdatamysql.Entity;

import main.java.com.CESI.accessingdatamysql.Repository.ClientRepository;

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
    private List<main.java.com.CESI.accessingdatamysql.Entity.CompteCourant> CompteCourant = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "T_Compte_Epargne_Client",
    joinColumns = @JoinColumn( name = "IdClient"),
    inverseJoinColumns = @JoinColumn( name = "IdCompteEpargne"))
    private List<main.java.com.CESI.accessingdatamysql.Entity.CompteEpargne> CompteEpargne = new ArrayList<>();

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

    public boolean saveClient(String nom, String prenom, ClientRepository ClientRepository) {
        try {
            this.Nom = nom;
            this.Prenom = prenom;
            ClientRepository.save(this);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void addCompte (CompteCourant compteCourant){
        this.CompteCourant.add(compteCourant);
    }
}

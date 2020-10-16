package main.java.com.CESI.accessingdatamysql.Entity;

import main.java.com.CESI.accessingdatamysql.Entity.Compte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class CompteCourant extends Compte {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer IdComteCourant;

    private double montantDecouvertAutorise;

    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }

    public Integer getId() {
        return IdComteCourant;
    }

    public void setId(Integer id) {
        this.IdComteCourant = id;
    }



}

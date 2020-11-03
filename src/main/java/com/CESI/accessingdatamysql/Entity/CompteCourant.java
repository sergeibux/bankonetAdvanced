package main.java.com.CESI.accessingdatamysql.Entity;

import main.java.com.CESI.accessingdatamysql.Entity.Compte;
import main.java.com.CESI.accessingdatamysql.Repository.ClientRepository;
import main.java.com.CESI.accessingdatamysql.Repository.CompteCourantRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // This tells Hibernate to make a table out of this class
public class CompteCourant extends Compte {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer IdCompteCourant;

    private double montantDecouvertAutorise;

    public double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }

    @JsonIgnore
    public Integer getId() {
        return IdCompteCourant;
    }

    public void setId(Integer id) {
        this.IdCompteCourant = id;
    }

    public int createCompte(Double decouvertAutorise, String intitule, Double solde, String numero, ClientRepository clientRepository, CompteCourantRepository CompteCourantRepository) {
        this.montantDecouvertAutorise = decouvertAutorise;
        this.Intitule = intitule;
        this.Solde = solde;
        this.Numero = numero;


        CompteCourant monComtpe = CompteCourantRepository.save(this);
        return monComtpe.getId();
    }

	@Override
	public String toString() {
		return "CompteCourant [" + (IdCompteCourant != null ? "IdComteCourant=" + IdCompteCourant + ", " : "")
				+ "montantDecouvertAutorise=" + montantDecouvertAutorise + "]";
	}
    
}

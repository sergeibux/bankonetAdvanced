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

    public boolean createComtpe(Double decouvertAutorise, String intitule, Double solde, String numero, ClientRepository ClientRepository, CompteCourantRepository CompteCourantRepository, int idClient) {
        this.montantDecouvertAutorise = decouvertAutorise;
        this.Intitule = intitule;
        this.Solde = solde;
        this.Numero = numero;

        Optional<Client> client = ClientRepository.findById(idClient);
        if (client.isPresent()) {
            CompteCourant myCompte = CompteCourantRepository.save(this);

            Client monClient = client.get();
            monClient.addCompte(myCompte);
            ClientRepository.save(monClient);
            return true;
        } else return false;
    }
}

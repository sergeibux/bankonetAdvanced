package main.java.com.CESI.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class CompteCourant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer IdComteCourant;

    private String Numero;

    private String Intitule;
    
    private double Solde;

    public Integer getId() {
        return IdComteCourant;
    }

    public void setId(Integer id) {
        this.IdComteCourant = id;
    }

    public String get_numero() {
        return Numero;
    }

    public void set_numero(String Numero) {
        this.Numero = Numero;
    }


    public String get_intitule() {
        return Intitule;
    }

    public void set_intitule(String Intitule) {
        this.Intitule = Intitule;
    }


    public double get_solde() {
        return Solde;
    }

    public void set_solde(float Solde) {
        this.Solde = Solde;
    }
}

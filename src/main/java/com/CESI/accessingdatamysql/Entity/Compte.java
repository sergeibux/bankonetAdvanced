package main.java.com.CESI.accessingdatamysql.Entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Compte {

    protected String Numero;

    protected String Intitule;

    protected double Solde;

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

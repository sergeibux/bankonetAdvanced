package main.java.com.CESI.accessingdatamysql;

public abstract class Compte {

    protected String Numero;

    protected String Intitule;

    protected double Solde;

    public abstract String get_numero();

    public abstract void set_numero(String Numero);


    public abstract String get_intitule();

    public abstract void set_intitule(String Intitule);


    public abstract double get_solde();

    public abstract void set_solde(float Solde);
}

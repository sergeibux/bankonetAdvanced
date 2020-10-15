package main.java.com.CESI.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class ClientCompteEpargne {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Identifiant;

    private Integer idClient;

    private Integer idCompteEpargne;

    public Integer getId() {
        return Identifiant;
    }

    public void setId(Integer id) {
        this.Identifiant = id;
    }

    public Integer get_idClient() {
        return idClient;
    }

    public void set_idClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer get_idCompteEpargne() {
        return idCompteEpargne;
    }

    public void set_idCompteEpargne(Integer idCompteEpargne) {
        this.idCompteEpargne = idCompteEpargne;
    }
}

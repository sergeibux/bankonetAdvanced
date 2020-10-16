package main.java.com.CESI.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class CompteCourant extends Compte {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer IdComteCourant;

    public Integer getId() {
        return IdComteCourant;
    }

    public void setId(Integer id) {
        this.IdComteCourant = id;
    }
}

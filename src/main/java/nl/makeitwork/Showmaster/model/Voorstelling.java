package nl.makeitwork.Showmaster.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Voorstelling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer voorstellingId;
    private String naam;
    private Date datum = new Date();

    public Integer getVoorstellingId() {
        return voorstellingId;
    }

    public void setVoorstellingId(Integer voorstellingId) {
        this.voorstellingId = voorstellingId;
    }

    public String getName() {
        return naam;
    }

    public void setName(String name) {
        this.naam = name;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}

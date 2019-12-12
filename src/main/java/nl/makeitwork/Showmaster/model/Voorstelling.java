package nl.makeitwork.Showmaster.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Calendar;


@Entity
public class Voorstelling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer voorstellingId;
    private String naam;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime datum;


    public Integer getVoorstellingId() {
        return voorstellingId;
    }

    public void setVoorstellingId(Integer voorstellingId) {
        this.voorstellingId = voorstellingId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }
}

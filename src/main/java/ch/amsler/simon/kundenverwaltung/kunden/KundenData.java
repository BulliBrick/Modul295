package ch.amsler.simon.kundenverwaltung.kunden;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Data
@Entity
public class KundenData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable=false)
    private Long Kundennummer;

    private String vorname;
    private String name;

    public KundenData() {
    }

    public KundenData(Long kundennummer, String vorname, String name) {
        this.Kundennummer = kundennummer;
        this.vorname = vorname;
        this.name = name;
    }

    public KundenData(Long id, Long kundennummer, String vorname, String name) {
        this.id = id;
        this.Kundennummer = kundennummer;
        this.vorname = vorname;
        this.name = name;
    }
}


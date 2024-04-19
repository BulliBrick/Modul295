package ch.amsler.simon.kundenverwaltung.auftrag;

import ch.amsler.simon.kundenverwaltung.kunden.KundenData;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.List;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

@Data
@Entity
public class AuftragData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "kunden_id", nullable = false)
    private KundenData KundenData;

    private LocalDate auftragsdatum;

    private Long auftragsnummer;
    private String auftragsstatus;

    private List bestellung;


}
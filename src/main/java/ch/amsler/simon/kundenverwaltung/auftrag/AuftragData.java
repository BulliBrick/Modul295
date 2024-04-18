package ch.amsler.simon.kundenverwaltung.auftrag;

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

    @Column(nullable=false)
    private Long Kundennummer;

    private LocalDate auftragsdatum;

    private Long auftragsnummer;
    private String auftragsstatus;

    private List bestellung;


}
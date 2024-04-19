package ch.amsler.simon.kundenverwaltung.kundenservice;

import ch.amsler.simon.kundenverwaltung.kunden.KundenData;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.List;

import java.time.LocalDate;

@Data
@Entity
public class KundenServiceData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kunden_id", nullable = false)
    private KundenData KundenData;

    private LocalDate servicesdatum;

    private String servicesstatus;

    private String servicesbeschreibung;


}
package ch.amsler.simon.kundenverwaltung.kundenservice;

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

    @Column(nullable=false)
    private Long Kundennummer;

    private LocalDate servicesdatum;


    private String servicesstatus;

    private String servicesbeschreibung;


}
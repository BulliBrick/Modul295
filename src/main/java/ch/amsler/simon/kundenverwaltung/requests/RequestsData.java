package ch.amsler.simon.kundenverwaltung.requests;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RequestsData{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable=false)
    private Long Kundennummer;

    private String vorname;
    private String name;
}

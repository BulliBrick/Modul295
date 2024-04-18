package ch.amsler.simon.kundenverwaltung.auftrag;

import ch.amsler.simon.kundenverwaltung.kunden.KundenData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface AuftragRepository extends  JpaRepository<AuftragData, Long>{
}

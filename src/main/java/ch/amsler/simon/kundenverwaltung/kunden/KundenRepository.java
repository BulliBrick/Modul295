package ch.amsler.simon.kundenverwaltung.kunden;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface KundenRepository extends  JpaRepository<KundenData, Long>{
    public List<KundenData> findByName(String name);
}

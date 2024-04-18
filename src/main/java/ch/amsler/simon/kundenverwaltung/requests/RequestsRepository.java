package ch.amsler.simon.kundenverwaltung.requests;

import ch.amsler.simon.kundenverwaltung.kunden.KundenData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestsRepository extends JpaRepository<RequestsData, Long> {
    public List<RequestsData> findByName(String name);
}
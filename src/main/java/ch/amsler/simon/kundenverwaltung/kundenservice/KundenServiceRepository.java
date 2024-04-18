package ch.amsler.simon.kundenverwaltung.kundenservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KundenServiceRepository extends  JpaRepository<KundenServiceData, Long>{

}

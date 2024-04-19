package ch.amsler.simon.kundenverwaltung.auftrag;

import ch.amsler.simon.kundenverwaltung.auftrag.AuftragData;
import ch.amsler.simon.kundenverwaltung.auftrag.AuftragRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuftragService {

    private AuftragRepository AuftragRepository;

    public AuftragService(AuftragRepository repository) {
        this.AuftragRepository = repository;
    }

    public List<AuftragData> findAll(){
        return AuftragRepository.findAll();
    }

    public Optional<AuftragData> findById(long id){
        return AuftragRepository.findById(id);
    }


    public AuftragData insert(AuftragData data){
        return AuftragRepository.save(data);
    }

    public AuftragData save(AuftragData data){
        return AuftragRepository.save(data);
    }

    public void delete(AuftragData data){
        AuftragRepository.delete(data);
    }

    public void deleteById(Long id) {
        AuftragRepository.deleteById((Long) id);

    }

    public List<AuftragData> saveAll(List<AuftragData> auftragDataList) {
        return AuftragRepository.saveAll(auftragDataList);
    }

}

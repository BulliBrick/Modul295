package ch.amsler.simon.kundenverwaltung.kunden;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KundenService {

    private KundenRepository KundenRepository;

    public KundenService(KundenRepository repository) {
        this.KundenRepository = repository;
    }

    public List<KundenData> findAll(){
        return KundenRepository.findAll();
    }

    public Optional<KundenData> findById(long id){
        return KundenRepository.findById(id);
    }

    public List<KundenData> findByName(String name){
        return KundenRepository.findByName(name);
    }

    public KundenData insert(KundenData data){
        return KundenRepository.save(data);
    }

    public KundenData save(KundenData data, Long id){
        return KundenRepository.findById(id)
                .map(kundenOrig -> {
                    kundenOrig.setName(data.getName());
                    kundenOrig.setVorname(data.getVorname());
                    kundenOrig.setKundennummer(data.getKundennummer());
                    return KundenRepository.save(kundenOrig);
                })
                .orElseGet(() -> KundenRepository.save(data));
    }

    public void deleteById(Long id) {
        KundenRepository.deleteById((Long) id);

    }

    public List<KundenData> saveAll(List<KundenData> kundenDataList) {
        return KundenRepository.saveAll(kundenDataList);
    }

}

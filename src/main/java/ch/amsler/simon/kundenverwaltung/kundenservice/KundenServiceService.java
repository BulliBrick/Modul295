package ch.amsler.simon.kundenverwaltung.kundenservice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KundenServiceService {

    private KundenServiceRepository KundenServiceRepository;

    public KundenServiceService(KundenServiceRepository repository) {
        this.KundenServiceRepository = repository;
    }

    public List<KundenServiceData> findAll(){
        return KundenServiceRepository.findAll();
    }

    public Optional<KundenServiceData> findById(long id){
        return KundenServiceRepository.findById(id);
    }

    public KundenServiceData save(KundenServiceData data){
        return KundenServiceRepository.save(data);
    }

    public void delete(KundenServiceData data){
        KundenServiceRepository.delete(data);
    }

    public void deleteById(Long id) {
        KundenServiceRepository.deleteById((Long) id);

    }

    public List<KundenServiceData> saveAll(List<KundenServiceData> kundenServiceDataList) {
        return KundenServiceRepository.saveAll(kundenServiceDataList);
    }

}

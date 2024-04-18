package ch.amsler.simon.kundenverwaltung.requests;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestsService {

    private RequestsRepository RequestsRepository;

    public RequestsService(RequestsRepository repository) {
        this.RequestsRepository = repository;
    }

    public List<RequestsData> findAll(){
        return RequestsRepository.findAll();
    }

    public Optional<RequestsData> findById(long id){
        return RequestsRepository.findById(id);
    }

    public List<RequestsData> findByName(String name){
        return RequestsRepository.findByName(name);
    }

    public RequestsData save(RequestsData data){
        return RequestsRepository.save(data);
    }

    public void delete(RequestsData data){
        RequestsRepository.delete(data);
    }

    public void deleteById(Long id) {
        RequestsRepository.deleteById((Long) id);

    }
}
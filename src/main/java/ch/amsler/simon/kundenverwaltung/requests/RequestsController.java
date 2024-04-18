package ch.amsler.simon.kundenverwaltung.requests;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RequestsController {

    private final RequestsService requestsService;

    public RequestsController(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    @PostMapping("/api/requests")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public ResponseEntity<RequestsData> createRequest(@RequestBody RequestsData requestsData) {
        return new ResponseEntity<>(requestsService.save(requestsData), HttpStatus.CREATED);
    }

    @PutMapping("/api/requests")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public ResponseEntity<RequestsData> updateRequest(@RequestBody RequestsData requestsData) {
        return new ResponseEntity<>(requestsService.save(requestsData), HttpStatus.OK);
    }

    @DeleteMapping("/api/requests/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        requestsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package ch.amsler.simon.kundenverwaltung.requests;

import ch.amsler.simon.kundenverwaltung.kunden.KundenData;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class RequestsController {

    private final RequestsService requestsService;

    public RequestsController(RequestsService requestsService) {
        this.requestsService = requestsService;
    }

    @GetMapping("/api/requests")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<List<RequestsData>> requestsRequests() {
        return new ResponseEntity<>(requestsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/requests/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('read') or hasRole('update')")
    ResponseEntity<Optional<RequestsData>> requestsRequestsById(@PathVariable Long id) {
        return new ResponseEntity<>(requestsService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/api/requests")
    @PreAuthorize("hasRole('admin') or hasRole('update')")
    public ResponseEntity<RequestsData> createRequest(@RequestBody RequestsData requestsData) {
        return new ResponseEntity<>(requestsService.save(requestsData), HttpStatus.CREATED);
    }

    @PutMapping("/api/requests/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('update')")
    public ResponseEntity<RequestsData> updateRequest(@RequestBody RequestsData requestsData, @PathVariable Long id) {
        return new ResponseEntity<>(requestsService.save(requestsData), HttpStatus.OK);
    }

    @DeleteMapping("/api/requests/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('update')")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        requestsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
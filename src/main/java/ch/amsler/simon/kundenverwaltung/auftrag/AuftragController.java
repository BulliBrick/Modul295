package ch.amsler.simon.kundenverwaltung.auftrag;

import ch.amsler.simon.kundenverwaltung.auftrag.AuftragData;
import ch.amsler.simon.kundenverwaltung.auftrag.AuftragService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@SecurityRequirement(name = "bearerAuth")
public class AuftragController {


    private final AuftragService auftragService;

    public AuftragController(AuftragService auftragService) {
        this.auftragService = auftragService;
    }


    @GetMapping("/api/auftrag")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<List<AuftragData>> auftragAuftrag() {
        return new ResponseEntity<>(auftragService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/auftrag/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('read') or hasRole('update')")
    ResponseEntity<Optional<AuftragData>> auftragAuftragById(@PathVariable Long id) {
        return new ResponseEntity<>(auftragService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/api/auftrag")
    @PreAuthorize("hasRole('admin') or hasRole('update')")
    ResponseEntity<AuftragData> auftragCreate(@RequestBody AuftragData auftragData) {
        return new ResponseEntity<>(auftragService.save(auftragData), HttpStatus.CREATED);
    }

    @PutMapping("/api/auftrag/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('update')")
    ResponseEntity<AuftragData> auftragUpdate(@RequestBody AuftragData auftragData, @PathVariable Long id) {
        return new ResponseEntity<>(auftragService.save(auftragData), HttpStatus.OK);
    }

    @DeleteMapping("/api/auftrag/{id}")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<Void> auftragDelete(@PathVariable Long id) {
        auftragService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


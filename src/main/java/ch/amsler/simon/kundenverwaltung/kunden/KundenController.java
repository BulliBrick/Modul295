package ch.amsler.simon.kundenverwaltung.kunden;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@SecurityRequirement(name = "bearerAuth")
public class KundenController {


    private final KundenService kundenService;

    public KundenController(KundenService kundenService) {
        this.kundenService = kundenService;
    }


    @GetMapping("/api/kunden")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    ResponseEntity<List<KundenData>> kundenKunden() {
        return new ResponseEntity<>(kundenService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/kunden/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    ResponseEntity<Optional<KundenData>> kundenKundenById(@PathVariable Long id) {
        return new ResponseEntity<>(kundenService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/api/kunden/name/{name}")
    @PreAuthorize("hasRole('admin') or hasRole('user')")
    ResponseEntity<List<KundenData>> kundenKundenByName(@PathVariable String name) {
        return new ResponseEntity<>(kundenService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/api/kunden")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<KundenData> kundenCreate(@RequestBody KundenData kundenData) {
        return new ResponseEntity<>(kundenService.save(kundenData), HttpStatus.CREATED);
    }

    @PutMapping("/api/kunden")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<KundenData> kundenUpdate(@RequestBody KundenData kundenData) {
        return new ResponseEntity<>(kundenService.save(kundenData), HttpStatus.OK);
    }

    @DeleteMapping("/api/kunden/{id}")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<Void> kundenDelete(@PathVariable Long id) {
        kundenService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

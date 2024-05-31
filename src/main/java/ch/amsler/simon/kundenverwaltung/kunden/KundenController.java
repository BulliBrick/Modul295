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
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<List<KundenData>> kundenKunden() {
        return new ResponseEntity<>(kundenService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/kunden/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('read') or hasRole('update')")
    ResponseEntity<Optional<KundenData>> kundenKundenById(@PathVariable Long id) {
        return new ResponseEntity<>(kundenService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/api/kunden/name/{name}")
    @PreAuthorize("hasRole('admin') or hasRole('read') or hasRole('update')")
    ResponseEntity<List<KundenData>> kundenKundenByName(@PathVariable String name) {
        return new ResponseEntity<>(kundenService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/api/kunden")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<KundenData> kundenCreate(@RequestBody KundenData kundenData) {
        return new ResponseEntity<>(kundenService.insert(kundenData), HttpStatus.CREATED);
    }

    @PostMapping("/api/kunden/many")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<KundenData>> kundenCreateMany(@RequestBody List<KundenData> kundenDataList) {
        List<KundenData> createdKundenDataList = kundenService.saveAll(kundenDataList);
        return new ResponseEntity<>(createdKundenDataList, HttpStatus.CREATED);
    }


    @PutMapping("/api/kunden/{id}")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<KundenData> kundenUpdate(@RequestBody KundenData kundenData, @PathVariable Long id) {
        return new ResponseEntity<>(kundenService.save(kundenData, id), HttpStatus.OK);
    }

    @DeleteMapping("/api/kunden/{id}")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<Void> kundenDelete(@PathVariable Long id) {
        kundenService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package ch.amsler.simon.kundenverwaltung.kundenservice;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@SecurityRequirement(name = "bearerAuth")
public class KundenServiceController {


    private final KundenServiceService kundenServiceService;

    public KundenServiceController(KundenServiceService kundenServiceService) {
        this.kundenServiceService = kundenServiceService;
    }


    @GetMapping("/api/service")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<List<KundenServiceData>> serviceService() {
        return new ResponseEntity<>(kundenServiceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/service/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('read') or hasRole('update')")
    ResponseEntity<Optional<KundenServiceData>> serviceServiceById(@PathVariable Long id) {
        return new ResponseEntity<>(kundenServiceService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/api/service")
    @PreAuthorize("hasRole('admin') or hasRole('update')")
    ResponseEntity<KundenServiceData> serviceCreate(@RequestBody KundenServiceData kundenServiceData) {
        return new ResponseEntity<>(kundenServiceService.save(kundenServiceData), HttpStatus.CREATED);
    }

    @PutMapping("/api/service/{id}")
    @PreAuthorize("hasRole('admin') or hasRole('update')")
    ResponseEntity<KundenServiceData> serviceUpdate(@RequestBody KundenServiceData kundenServiceData, @PathVariable Long id) {
        return new ResponseEntity<>(kundenServiceService.save(kundenServiceData), HttpStatus.OK);
    }

    @DeleteMapping("/api/service/{id}")
    @PreAuthorize("hasRole('admin')")
    ResponseEntity<Void> serviceDelete(@PathVariable Long id) {
        kundenServiceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


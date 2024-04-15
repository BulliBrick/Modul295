package ch.amsler.simon.kundenverwaltung.kunden;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<List<KundenData>> apiKunden() {
        return new ResponseEntity<>(kundenService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/api/kunden/{id}")
    ResponseEntity<Optional<KundenData>> apiKundenById(@PathVariable int id) {
        return new ResponseEntity<>(kundenService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/api/kunden")
    ResponseEntity<KundenData> apiCreate(@RequestBody KundenData kundenData) {
        return new ResponseEntity<>(kundenService.save(kundenData), HttpStatus.CREATED);
    }


}

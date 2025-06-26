package org.example.exo4rest.controler;

import org.example.exo4rest.dto.observationDto.ObservationReceiveDTO;
import org.example.exo4rest.dto.observationDto.ObservationResponseDTO;
import org.example.exo4rest.service.ObservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/biodiversity/observation")
public class ObservationControler {

private final ObservationService observationService;


    public ObservationControler(ObservationService observationService) {
        this.observationService = observationService;
    }

    @GetMapping
    public ResponseEntity<List> findAll(){
        return ResponseEntity.ok(observationService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ObservationResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(observationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ObservationResponseDTO> create(@RequestBody ObservationReceiveDTO observationReceiveDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(observationService.create(observationReceiveDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObservationResponseDTO> update(@PathVariable Long id, @RequestBody ObservationReceiveDTO observationReceiveDTO){
        return ResponseEntity.ok(observationService.update(id, observationReceiveDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        observationService.deleteById(id);
        return ResponseEntity.ok("Deleted observation");
    }

    @GetMapping("/by-location")
    public ResponseEntity<List<ObservationResponseDTO>> findObservationsByLocation(@RequestParam String location){
        return ResponseEntity.ok(observationService.findObservationsByLocation(location));
    }

    @GetMapping("/by-specie/{specie_id}")
    public ResponseEntity<List<ObservationResponseDTO>> findObservationBySpecieId(@PathVariable Long specie_id){
        return ResponseEntity.ok(observationService.findObservationBySpecieId(specie_id));
    }




}

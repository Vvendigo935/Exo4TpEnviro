package org.example.exo4rest.controler;

import org.example.exo4rest.dto.specieDto.SpecieReceiveDTO;
import org.example.exo4rest.dto.specieDto.SpecieResponseDTO;
import org.example.exo4rest.entity.Specie;
import org.example.exo4rest.service.SpecieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/biodiversity/specie")
public class SpecieControler {

private final SpecieService specieService;


    public SpecieControler(SpecieService specieService) {
        this.specieService = specieService;
    }

    @GetMapping
    public ResponseEntity<List<SpecieResponseDTO>> findAll() {
        return ResponseEntity.ok(specieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecieResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(specieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SpecieResponseDTO> create (@RequestBody SpecieReceiveDTO specieReceiveDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(specieService.create(specieReceiveDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecieResponseDTO> update (@PathVariable Long id, @RequestBody SpecieReceiveDTO specieReceiveDTO){
        return ResponseEntity.ok(specieService.update(id, specieReceiveDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        specieService.deleteById(id);
        return ResponseEntity.ok("Deleted specie with id " + id);
    }


}
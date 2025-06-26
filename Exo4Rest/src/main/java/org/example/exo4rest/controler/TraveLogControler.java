package org.example.exo4rest.controler;

import org.example.exo4rest.dto.travelogDto.TraveLogReceiveDTO;
import org.example.exo4rest.dto.travelogDto.TraveLogResponseDTO;
import org.example.exo4rest.service.TraveLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/biodiversity/travelog")
public class TraveLogControler {

private final TraveLogService traveLogService;


    public TraveLogControler(TraveLogService traveLogService) {
        this.traveLogService = traveLogService;
    }

    @GetMapping
    public ResponseEntity<List> findAll() {
        return ResponseEntity.ok(traveLogService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TraveLogResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(traveLogService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TraveLogResponseDTO> create(@RequestBody TraveLogReceiveDTO traveLogReceiveDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(traveLogService.create(traveLogReceiveDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TraveLogResponseDTO> update(@PathVariable Long id, @RequestBody TraveLogReceiveDTO traveLogReceiveDTO){
        return ResponseEntity.ok(traveLogService.update(id, traveLogReceiveDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        traveLogService.deleteById(id);
        return ResponseEntity.ok("Deleted travelog");
    }

    @GetMapping("/stats/{idObservation}")
    public ResponseEntity<TraveLogResponseDTO> stats(@PathVariable Long idObservation){
        return ResponseEntity.ok(traveLogService.findById(idObservation));

    }

}

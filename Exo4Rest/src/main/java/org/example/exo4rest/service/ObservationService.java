package org.example.exo4rest.service;

import org.example.exo4rest.dto.observationDto.ObservationReceiveDTO;
import org.example.exo4rest.dto.observationDto.ObservationResponseDTO;
import org.example.exo4rest.entity.Observation;
import org.example.exo4rest.exeption.NotFoundException;
import org.example.exo4rest.repository.ObservationRepository;
import org.example.exo4rest.repository.SpecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

private final ObservationRepository observationRepository;
private final SpecieRepository specieRepository;


    public ObservationService(ObservationRepository observationRepository, SpecieRepository specieRepository) {
        this.observationRepository = observationRepository;
        this.specieRepository = specieRepository;
    }

public ObservationResponseDTO create (ObservationReceiveDTO observationReceiveDTO) {
        return observationRepository.save(observationReceiveDTO.dtoToEntity(specieRepository)).entityToDTO();
}

public ObservationResponseDTO findById(Long id) {
        return observationRepository.findById(id).orElseThrow(NotFoundException::new).entityToDTO();
}

public List<ObservationResponseDTO> findAll() {
        return observationRepository.findAll().stream().map(Observation::entityToDTO).toList();
}

public void deleteById(Long id) {
        observationRepository.deleteById(id);
}

public ObservationResponseDTO update(Long id, ObservationReceiveDTO observationReceiveDTO) {
        Observation observationFound = observationRepository.findById(id).orElseThrow(NotFoundException::new);
        Observation observationGet = observationReceiveDTO.dtoToEntity(specieRepository);
        observationFound.setObserverName(observationGet.getObserverName());
        observationFound.setLocation(observationGet.getLocation());
        observationFound.setLatitude(observationGet.getLatitude());
        observationFound.setLongitude(observationGet.getLongitude());
        observationFound.setObservationDate(observationGet.getObservationDate());
        return observationRepository.save(observationFound).entityToDTO();
}

public List<ObservationResponseDTO> findObservationBySpecieId(Long specieId) {
        return observationRepository.findObservationsBySpecieId(specieId).stream().map(Observation::entityToDTO).toList();
}

public List<ObservationResponseDTO> findObservationsByLocation(String location) {
        return observationRepository.findObservationsByLocation(location).stream().map(Observation::entityToDTO).toList();
}


}



package org.example.exo4rest.service;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.example.exo4rest.dto.travelogDto.Co2ResponseDTO;
import org.example.exo4rest.dto.travelogDto.TraveLogReceiveDTO;
import org.example.exo4rest.dto.travelogDto.TraveLogResponseDTO;
import org.example.exo4rest.entity.TraveLog;
import org.example.exo4rest.exeption.NotFoundException;
import org.example.exo4rest.repository.ObservationRepository;
import org.example.exo4rest.repository.TraveLogRepository;
import org.example.exo4rest.util.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TraveLogService {

    private final TraveLogRepository traveLogRepository;
    private final ObservationRepository observationRepository;
//    private final Co2ResponseDTO co2ResponseDTO;



    public TraveLogService(TraveLogRepository traveLogRepository, ObservationRepository observationRepository /*, Co2ResponseDTO co2ResponseDTO*/) {
        this.traveLogRepository = traveLogRepository;
        this.observationRepository = observationRepository;
    //    this.co2ResponseDTO = co2ResponseDTO;
    }

public TraveLogResponseDTO create (TraveLogReceiveDTO traveLogReceiveDTO) {
        return traveLogRepository.save(traveLogReceiveDTO.dtoToEntity(observationRepository)).entityToDTO();
}

public TraveLogResponseDTO findById (Long id) {
        return traveLogRepository.findById(id).orElseThrow(NotFoundException::new).entityToDTO();
}

public List<TraveLogResponseDTO> findAll() {

        return traveLogRepository.findAll().stream().map(TraveLog::entityToDTO).toList();
}

public void deleteById (Long id) {
        traveLogRepository.deleteById(id);
}

public TraveLogResponseDTO update(Long id, TraveLogReceiveDTO traveLogReceiveDTO) {
        TraveLog traveLogFound = traveLogRepository.findById(id).orElseThrow(NotFoundException::new);
        TraveLog traveLogGet = traveLogReceiveDTO.dtoToEntity(observationRepository);
        traveLogFound.setObservation(traveLogGet.getObservation());
        traveLogFound.setDistanceKm(traveLogGet.getDistanceKm());
        traveLogFound.setTravelMode(traveLogGet.getTravelMode());
        traveLogFound.setEstimatedCo2Kg(traveLogGet.getEstimatedCo2Kg());
        return traveLogRepository.save(traveLogFound).entityToDTO();
}

public List<TraveLogResponseDTO> findTraveLogsByObservationId (Long observationId) {
        return traveLogRepository.findTraveLogByObservationId(observationId).stream().map(TraveLog::entityToDTO).toList();
}

//public Map<String,Double> showStatsDetailObservation (Long observationId) {
//    Map<String,Double> result = new HashMap<>();
//    List<TraveLog> traveLogs = traveLogRepository.findTraveLogByObservationId(observationId);
//    Double totalCo2 = 0.0;
//    for(TraveLog traveLog : traveLogs) {
//        totalCo2 = traveLog.getEstimatedCo2Kg() * traveLog.getDistanceKm();
//    }
//    result.put("totalCo2", totalCo2);
//   return result;
//}

}


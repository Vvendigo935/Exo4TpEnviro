package org.example.exo4rest.dto.travelogDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.entity.Observation;
import org.example.exo4rest.entity.TraveLog;
import org.example.exo4rest.exeption.NotFoundException;
import org.example.exo4rest.repository.ObservationRepository;
import org.example.exo4rest.repository.SpecieRepository;
import org.example.exo4rest.util.TravelMode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TraveLogReceiveDTO {

    private Long id;

    private Long observationId;

    private Double distanceKm;
    private TravelMode travelMode;
    private Double estimatedCo2Kg;


    public TraveLog dtoToEntity(ObservationRepository observationRepository) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return TraveLog.builder()
                .observation(observationRepository.findById(getObservationId()).orElseThrow(NotFoundException::new))
                .distanceKm(getDistanceKm())
                .travelMode(getTravelMode())
                .estimatedCo2Kg(getEstimatedCo2Kg())
                .build();

    }


}

package org.example.exo4rest.dto.observationDto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.entity.Observation;
import org.example.exo4rest.exeption.NotFoundException;
import org.example.exo4rest.repository.SpecieRepository;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ObservationReceiveDTO {

    private Long id;

    private Long specieId;

    private String observerName;
    private String location;
    private Double latitude;
    private Double longitude;

    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}" , message = "Date must be dd-MM-yyyy")
    private String observationDateString;

    public Observation dtoToEntity(SpecieRepository specieRepository) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Observation.builder()
                .specie(specieRepository.findById(getSpecieId()).orElseThrow(NotFoundException::new))
                .observerName(getObserverName())
                .location(getLocation())
                .latitude(getLatitude())
                .longitude(getLongitude())
                .observationDate(LocalDate.parse(getObservationDateString(), formatter))
                .build();
    }


}
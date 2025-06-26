package org.example.exo4rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.dto.observationDto.ObservationResponseDTO;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Observation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //TODO : voir si on a besoin de + de précision
    @JoinColumn(name = "specie_id")
    private Specie specie;

    private String observerName;
    private String location;
    private Double latitude;
    private Double longitude;
    private LocalDate observationDate;


         public ObservationResponseDTO entityToDTO() {
        return ObservationResponseDTO.builder()
                .id(getId())
                .specie(getSpecie())
                .observerName(getObserverName())
                .location(getLocation())
                .latitude(getLatitude())
                .longitude(getLongitude())
                .observationDate(getObservationDate())
                .build();
    }


}

package org.example.exo4rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.dto.specieDto.SpecieResponseDTO;
import org.example.exo4rest.dto.travelogDto.TraveLogResponseDTO;
import org.example.exo4rest.util.TravelMode;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TraveLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //TODO : voir si on a besoin de + de précision
    @JoinColumn(name = "observation_id")
    private Observation observation;

    private Double distanceKm;
    private TravelMode travelMode;
    private Double estimatedCo2Kg;



         public TraveLogResponseDTO entityToDTO() {
        return TraveLogResponseDTO.builder()
                .id(getId())
                .observation(getObservation())
                .distanceKm(getDistanceKm())
                .travelMode(getTravelMode())
                .estimatedCo2Kg(getEstimatedCo2Kg())
                .build();
    }


}
package org.example.exo4rest.dto.travelogDto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.entity.Observation;
import org.example.exo4rest.util.TravelMode;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TraveLogResponseDTO {

    private Long id;

    @OneToOne //TODO : voir si on a besoin de + de précision
    @JoinColumn(name = "observation_id")
    Observation observation;

    private Double distanceKm;
    private TravelMode travelMode;
    private Double estimatedCo2Kg;

}

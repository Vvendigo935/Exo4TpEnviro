package org.example.exo4rest.dto.observationDto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.entity.Specie;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ObservationResponseDTO {

    private Long id;

    @ManyToOne //TODO : voir si on a besoin de + de précision
    @JoinColumn(name = "specie_id")
     Specie specie;

    private String observerName;
    private String location;
    private Double latitude;
    private Double longitude;
    private LocalDate observationDate;

}

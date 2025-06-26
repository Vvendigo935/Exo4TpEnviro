package org.example.exo4rest.dto.travelogDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Co2ResponseDTO {

    private Map<TraveLogResponseDTO,Integer> travelLogs;
    private double totalCo2;



}

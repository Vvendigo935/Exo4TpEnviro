package org.example.exo4rest.dto.specieDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.util.Category;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SpecieResponseDTO {


    private Long id;

    private String commonName;
    private String scientificName;
    private Category category;




}

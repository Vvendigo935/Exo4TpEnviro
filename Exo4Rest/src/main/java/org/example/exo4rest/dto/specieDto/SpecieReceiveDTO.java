package org.example.exo4rest.dto.specieDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.entity.Specie;
import org.example.exo4rest.repository.SpecieRepository;
import org.example.exo4rest.util.Category;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecieReceiveDTO {


    private Long id;
    private String commonName;
    private String scientificName;
    private Category category;

    public Specie dtoToEntity() {
        return Specie.builder()
                .commonName(getCommonName())
                .scientificName(getScientificName())
                .category(getCategory())
                .build();
    }


}



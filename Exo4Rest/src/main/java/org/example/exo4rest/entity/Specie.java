package org.example.exo4rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo4rest.dto.specieDto.SpecieResponseDTO;
import org.example.exo4rest.util.Category;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Specie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commonName;
    private String scientificName;
    private Category category;


     public SpecieResponseDTO entityToDTO() {
        return SpecieResponseDTO.builder()
                .id(getId())
                .commonName(getCommonName())
                .scientificName(getScientificName())
                .category(getCategory())
                .build();
    }




}

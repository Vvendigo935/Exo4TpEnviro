package org.example.exo4rest.service;

import org.example.exo4rest.dto.specieDto.SpecieReceiveDTO;
import org.example.exo4rest.dto.specieDto.SpecieResponseDTO;
import org.example.exo4rest.entity.Specie;
import org.example.exo4rest.exeption.NotFoundException;
import org.example.exo4rest.repository.SpecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecieService {

private final SpecieRepository specieRepository;


    public SpecieService(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    public SpecieResponseDTO create (SpecieReceiveDTO specieReceiveDTO){
        return specieRepository.save(specieReceiveDTO.dtoToEntity()).entityToDTO();
    }

    public SpecieResponseDTO findById(Long id){
        return specieRepository.findById(id).orElseThrow(NotFoundException::new).entityToDTO();
    }

    public List<SpecieResponseDTO> findAll(){
        return specieRepository.findAll().stream().map(Specie::entityToDTO).toList();
    }

    public void deleteById(Long id){
        specieRepository.deleteById(id);
    }

    public SpecieResponseDTO update(Long id, SpecieReceiveDTO specieReceiveDTO){
        Specie specieFound = specieRepository.findById(id).orElseThrow(NotFoundException::new);
        Specie specieGet = specieReceiveDTO.dtoToEntity();
        specieFound.setCommonName(specieGet.getCommonName());
        specieFound.setScientificName(specieGet.getScientificName());
        specieFound.setCategory(specieGet.getCategory());
        return specieRepository.save(specieFound).entityToDTO();
    }




}
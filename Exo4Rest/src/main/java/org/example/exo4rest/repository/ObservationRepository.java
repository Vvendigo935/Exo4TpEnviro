package org.example.exo4rest.repository;

import org.example.exo4rest.entity.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
    List<Observation> findObservationsBySpecieId(Long specie_id);

    List<Observation> findObservationsByLocation (String location);





}

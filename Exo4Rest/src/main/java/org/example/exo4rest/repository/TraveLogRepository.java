package org.example.exo4rest.repository;

import org.example.exo4rest.entity.TraveLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TraveLogRepository extends JpaRepository<TraveLog, Long> {
    List<TraveLog> findTraveLogByObservationId(Long observationId);
}

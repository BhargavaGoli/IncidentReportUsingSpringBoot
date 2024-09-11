package com.ByteMonk.Assignment.repo;

import com.ByteMonk.Assignment.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IncidentRepository extends JpaRepository<Incident,Long> {
    Optional<Incident> findByTitle(String title);
    List<Incident> findBySeverityAndIncidentDateBetween(String severity, LocalDate startDate, LocalDate endDate);
}

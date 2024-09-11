package com.ByteMonk.Assignment.service;

import com.ByteMonk.Assignment.model.Incident;
import com.ByteMonk.Assignment.repo.IncidentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncidentService {

    @Autowired
    IncidentRepository incidentRepository;


    public Incident createIncident(Incident incident) {
        validateIncident(incident);
        return incidentRepository.save(incident);
    }

    private void validateIncident(Incident incident) {
        if(incident.getIncidentDate().isAfter(LocalDate.now().plusDays(1)) ||
                incident.getIncidentDate().isBefore(LocalDate.now().minusDays(30))){
            throw new RuntimeException("Incident date is invalid");
        }
        if(!List.of("Low","Medium","High").contains(incident.getSeverity())){
            throw new RuntimeException("Invalid severity level");
        }
        if (incident.getTitle().length() < 10) {
            throw new RuntimeException("Incident title must be at least 10 characters long");
        }
        if (incidentRepository.findByTitle(incident.getTitle()).isPresent()) {
            throw new RuntimeException("Incident with the same title already exists");
        }
    }


    public List<Incident> listIncidents(String severity, LocalDate startDate, LocalDate endDate) {
        if (severity != null && startDate != null && endDate != null) {
            return incidentRepository.findBySeverityAndIncidentDateBetween(severity, startDate, endDate);
        }
        return incidentRepository.findAll();
    }

    public Incident updateIncident(long id, Incident updatedincident) {
        Incident existingincident=incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident not found."));
        existingincident.setStatus(updatedincident.getStatus());
        existingincident.setStatus(updatedincident.getNotes());
        return incidentRepository.save(existingincident);
    }


    public Incident getIncident(Long id) {
        return incidentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Incident with that id is not found"));
    }
}

package com.ByteMonk.Assignment;

import com.ByteMonk.Assignment.model.Incident;
import com.ByteMonk.Assignment.repo.IncidentRepository;
import com.ByteMonk.Assignment.service.IncidentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IncidentServiceTest {

    @InjectMocks
    private IncidentService incidentService;

    @Mock
    private IncidentRepository incidentRepository;

    private Incident incident;

    @BeforeEach
    public void setup() {
        // Initialize mocks and create a sample incident
        MockitoAnnotations.openMocks(this);
        incident = new Incident();
        incident.setTitle("Incident Title");
        incident.setDescription("A sample description");
        incident.setSeverity("High");
        incident.setIncidentDate(LocalDate.now());
    }

    @Test
    public void testCreateIncident() {
        // Simulate saving the incident
        when(incidentRepository.save(any(Incident.class))).thenReturn(incident);

        Incident createdIncident = incidentService.createIncident(incident);

        assertNotNull(createdIncident);
        assertEquals("Incident Title", createdIncident.getTitle());
    }

    @Test
    public void testUpdateIncident() {
        // Simulate finding and updating the incident
        when(incidentRepository.findById(1L)).thenReturn(Optional.of(incident));

        Incident updatedIncident = new Incident();
        updatedIncident.setStatus("Resolved");

        when(incidentRepository.save(any(Incident.class))).thenReturn(updatedIncident);

        Incident result = incidentService.updateIncident(1L, updatedIncident);

        assertNotNull(result);
        assertEquals("Resolved", result.getStatus());
    }
}

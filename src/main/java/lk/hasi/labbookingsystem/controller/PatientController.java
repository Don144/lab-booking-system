package lk.hasi.labbookingsystem.controller;

import lk.hasi.labbookingsystem.dto.PatientDto;
import lk.hasi.labbookingsystem.entity.Patient;
import lk.hasi.labbookingsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Save operation
    @PostMapping("/patient")
    public PatientDto savePatient(
            @RequestBody Patient patient)
    {
        return patientService.patientRegistration(patient);
    }

    // Read operation
    @GetMapping("/patient")
    public List<PatientDto> fetchPatientList()
    {
        return patientService.fetchPatient();
    }

    // Update operation
    @PutMapping("/patient/{id}")
    public Patient
    updatePatientDetails(@RequestBody Patient patient,
                        @PathVariable("id") Integer patientId)
    {
        return patientService.updatePatient(patient, patientId);
    }

    // Delete operation
    @DeleteMapping("/patient/{id}")
    public String deletePatientById(@PathVariable("id")
                                   Integer patientId)
    {
        patientService.deletePatient(
                patientId);
        return "Deleted Successfully";
    }
}

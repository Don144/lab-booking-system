package lk.hasi.labbookingsystem.service;

import lk.hasi.labbookingsystem.dto.PatientDto;
import lk.hasi.labbookingsystem.entity.Patient;

import java.util.List;

public interface PatientService {

    PatientDto patientRegistration(Patient patient);

    List<PatientDto> fetchPatient();

    Patient updatePatient(Patient patient,
                             Integer patientId);

    void deletePatient(Integer patientId);
}

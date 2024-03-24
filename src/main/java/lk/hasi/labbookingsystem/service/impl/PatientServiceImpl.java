package lk.hasi.labbookingsystem.service.impl;

import lk.hasi.labbookingsystem.dto.PatientDto;
import lk.hasi.labbookingsystem.repo.PatientRepository;
import lk.hasi.labbookingsystem.entity.Patient;
import lk.hasi.labbookingsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientDto patientRegistration(Patient patient) {
        try{
            PatientDto patientDto = new PatientDto();
            Patient result = patientRepository.save(patient);
            patientDto.setId(result.getId());
            patientDto.setAge(result.getAge());
            patientDto.setEmail(result.getEmail());
            patientDto.setGender(result.getGender());
            patientDto.setName(result.getName());
            patientDto.setAddress(result.getAddress());
            patientDto.setDoctorAppointments(result.getDoctorAppointments());


            return patientDto;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PatientDto> fetchPatient() {
        try{
            List<PatientDto> patientDtoList =new ArrayList<>();
            List<Patient> result = patientRepository.findAll();
            if(!result.isEmpty()){
                for(Patient patient: result){
                    PatientDto patientDto = new PatientDto();
                    patientDto.setId(patient.getId());
                    patientDto.setAge(patient.getAge());
                    patientDto.setEmail(patient.getEmail());
                    patientDto.setGender(patient.getGender());
                    patientDto.setName(patient.getName());
                    patientDto.setAddress(patient.getAddress());
                    patientDto.setDoctorAppointments(patient.getDoctorAppointments());

                    patientDtoList.add(patientDto);
                }
                return patientDtoList;
            }
            return null;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Patient updatePatient(Patient patient, Integer patientId) {
        return null;
    }

    @Override
    public void deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
    }
}

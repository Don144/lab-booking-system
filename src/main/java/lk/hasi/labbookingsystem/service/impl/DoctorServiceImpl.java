package lk.hasi.labbookingsystem.service.impl;

import lk.hasi.labbookingsystem.dto.DoctorDto;
import lk.hasi.labbookingsystem.entity.Doctors;
import lk.hasi.labbookingsystem.repo.DoctorRepository;
import lk.hasi.labbookingsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public DoctorDto doctorRegistration(Doctors doctors) {
        try{
            DoctorDto doctorDto = new DoctorDto();
            Doctors result = doctorRepository.save(doctors);
            doctorDto.setDoctor_name(result.getDoctor_name());
            doctorDto.setDoctor_email(result.getDoctor_email());
            doctorDto.setDoctor_specialization(result.getDoctor_specialization());
            doctorDto.setDoctorAppointments(result.getDoctorAppointments());
            doctorDto.setAvailability(result.isAvailability());
            doctorDto.setMax_appointment_count(result.getMax_appointment_count());

            return doctorDto;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DoctorDto> fetchDoctors() {
        try{
            List<DoctorDto> doctorDtoList =new ArrayList<>();
            List<Doctors> result = doctorRepository.findAll();
            if(!result.isEmpty()){
                for(Doctors doctors: result){
                    DoctorDto doctorDto = new DoctorDto();
                    doctorDto.setId(doctors.getId());
                    doctorDto.setDoctor_email(doctors.getDoctor_email());
                    doctorDto.setDoctor_name(doctors.getDoctor_name());
                    doctorDto.setDoctorAppointments(doctors.getDoctorAppointments());
                    doctorDto.setDoctor_specialization(doctors.getDoctor_specialization());
                    doctorDto.setAvailability(doctors.isAvailability());
                    doctorDto.setMax_appointment_count(doctors.getMax_appointment_count());

                    doctorDtoList.add(doctorDto);
                }
                return doctorDtoList;
            }
            return null;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Doctors updateDepartment(Doctors doctors, Integer doctorId) {
        return null;
    }

    @Override
    public void deleteDoctors(Integer doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}

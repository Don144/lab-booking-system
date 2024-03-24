package lk.hasi.labbookingsystem.service;

import lk.hasi.labbookingsystem.dto.DoctorDto;
import lk.hasi.labbookingsystem.entity.Doctors;

import java.util.List;

public interface DoctorService {

    DoctorDto doctorRegistration(Doctors doctors);

    List<DoctorDto> fetchDoctors();

    Doctors updateDepartment(Doctors doctors,
                                Integer doctorId);

    void deleteDoctors(Integer doctorId);

}

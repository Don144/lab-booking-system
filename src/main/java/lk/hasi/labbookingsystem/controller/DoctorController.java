package lk.hasi.labbookingsystem.controller;

import lk.hasi.labbookingsystem.dto.DoctorDto;
import lk.hasi.labbookingsystem.entity.Doctors;
import lk.hasi.labbookingsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(path="/all")
    private String test(){
        return "Test";
    }

    // Save operation
    @PostMapping("/doctor")
    public DoctorDto saveDoctor(
            @RequestBody Doctors doctors)
    {
        return doctorService.doctorRegistration(doctors);
    }

    // Read operation
    @GetMapping("/doctor")
    public List<DoctorDto> fetchDoctorList()
    {
        return doctorService.fetchDoctors();
    }

    // Update operation
    @PutMapping("/doctor/{id}")
    public Doctors
    updateDoctorDetails(@RequestBody Doctors doctors,
               @PathVariable("id") Integer doctorId)
    {
        return doctorService.updateDepartment(doctors, doctorId);
    }

    // Delete operation
    @DeleteMapping("/doctor/{id}")
    public String deleteDoctorById(@PathVariable("id")
                                 Integer doctorId)
    {
        doctorService.deleteDoctors(
                doctorId);
        return "Deleted Successfully";
    }


}

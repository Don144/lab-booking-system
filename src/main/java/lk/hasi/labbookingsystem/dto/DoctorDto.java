package lk.hasi.labbookingsystem.dto;

import lk.hasi.labbookingsystem.entity.DoctorAppointment;
import lombok.Data;

import java.util.Set;

@Data
public class DoctorDto {

    private Integer id;

    private String doctor_name;

    private String doctor_email;

    private String doctor_specialization;

    private boolean availability;

    private Integer max_appointment_count;

    private Set<DoctorAppointment> doctorAppointments;
}

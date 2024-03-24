package lk.hasi.labbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class DoctorAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date appointment_date;

    private Date create_date;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctors doctors;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;
}

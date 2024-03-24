package lk.hasi.labbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Technicians {
    @Id
    private Integer tech_id;

    private String tech_name;

    private String tech_email;

    private String tech_specialization;

    private boolean availability;

    private Integer max_appointment_count;

    private String NIC;

    @OneToMany(mappedBy="technicians")
    private Set<TechniciansAppointment> techniciansAppointments;

    @OneToMany(mappedBy="technicians")
    private Set<TestResult> testResults;

    @OneToMany(mappedBy="technicians")
    private Set<Test> test;
}

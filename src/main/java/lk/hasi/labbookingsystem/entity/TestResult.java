package lk.hasi.labbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String result_url;

    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctors doctors;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="tech_id", nullable=false)
    private Technicians technicians;
}

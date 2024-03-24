package lk.hasi.labbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "Doctors")
public class Doctors {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String doctor_name;

	private String doctor_email;

	private String doctor_specialization;

	private boolean availability;

	private Integer max_appointment_count;

	private String NIC;

	@OneToMany(mappedBy="doctors")
	private Set<DoctorAppointment> doctorAppointments;

	@OneToMany(mappedBy="doctors")
	private Set<TestResult> testResults;

	@OneToMany(mappedBy="doctors")
	private Set<TechniciansAppointment> techniciansAppointments;
}

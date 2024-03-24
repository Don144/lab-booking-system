package lk.hasi.labbookingsystem.repo;

import lk.hasi.labbookingsystem.entity.DoctorAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorAppointmentRepository extends JpaRepository<DoctorAppointment,Integer> {
}

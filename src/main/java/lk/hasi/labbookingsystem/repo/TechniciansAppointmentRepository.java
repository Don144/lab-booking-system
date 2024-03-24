package lk.hasi.labbookingsystem.repo;

import lk.hasi.labbookingsystem.entity.TechniciansAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechniciansAppointmentRepository extends JpaRepository<TechniciansAppointment,Integer> {
}

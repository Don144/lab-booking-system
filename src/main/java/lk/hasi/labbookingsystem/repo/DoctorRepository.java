package lk.hasi.labbookingsystem.repo;

import lk.hasi.labbookingsystem.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors, Integer>{

}

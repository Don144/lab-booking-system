package lk.hasi.labbookingsystem.repo;

import lk.hasi.labbookingsystem.entity.Technicians;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechniciansRepository extends JpaRepository<Technicians,Integer> {
}

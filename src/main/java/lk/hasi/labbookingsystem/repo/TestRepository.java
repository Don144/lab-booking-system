package lk.hasi.labbookingsystem.repo;

import lk.hasi.labbookingsystem.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {
    List<Test> findAllByAvaliableOrderByIdAsc(Boolean avaliable);

//    List<Test> findAllByTechIdOrderByIdAsc(Integer tech_id);
}

package lk.hasi.labbookingsystem.service;

import lk.hasi.labbookingsystem.dto.TechniciansDTO;
import lk.hasi.labbookingsystem.entity.Technicians;

import java.util.List;

public interface TechniciansService {

    TechniciansDTO techniciansRegistration(Technicians technicians);

    List<TechniciansDTO> fetchTechnicians();

    Technicians updateTechnicians(Technicians technicians,
                             Integer techId);

    void deleteTechnicians(Integer techId);
}

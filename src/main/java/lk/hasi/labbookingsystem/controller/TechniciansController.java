package lk.hasi.labbookingsystem.controller;

import lk.hasi.labbookingsystem.dto.TechniciansDTO;
import lk.hasi.labbookingsystem.entity.Technicians;
import lk.hasi.labbookingsystem.service.TechniciansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechniciansController {

    @Autowired
    TechniciansService techniciansService;

    // Save operation
    @PostMapping("/technicians")
    public TechniciansDTO saveTechnicians(
            @RequestBody Technicians technicians)
    {
        return techniciansService.techniciansRegistration(technicians);
    }

    // Read operation
    @GetMapping("/technicians")
    public List<TechniciansDTO> fetchTechniciansList()
    {
        return techniciansService.fetchTechnicians();
    }

    // Update operation
    @PutMapping("/technicians/{id}")
    public Technicians
    updateTechniciansDetails(@RequestBody Technicians technicians,
                        @PathVariable("id") Integer techId)
    {
        return techniciansService.updateTechnicians(technicians, techId);
    }

    // Delete operation
    @DeleteMapping("/technicians/{id}")
    public String deleteTechniciansById(@PathVariable("id")
                                   Integer techId)
    {
        techniciansService.deleteTechnicians(
                techId);
        return "Deleted Successfully";
    }
}

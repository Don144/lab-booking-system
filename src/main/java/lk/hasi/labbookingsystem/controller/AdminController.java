package lk.hasi.labbookingsystem.controller;

import lk.hasi.labbookingsystem.dto.AdminDTO;
import lk.hasi.labbookingsystem.entity.Admin;
import lk.hasi.labbookingsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Save operation
    @PostMapping("/admin")
    public AdminDTO saveAdmin(
            @RequestBody Admin admin)
    {
        return adminService.adminRegistration(admin);
    }

    // Read operation
    @GetMapping("/admin")
    public List<AdminDTO> fetchAdminList()
    {
        return adminService.fetchAdmins();
    }

    // Update operation
    @PutMapping("/admin/{id}")
    public Admin
    updateAdminDetails(@RequestBody Admin admin,
                        @PathVariable("id") Integer adminId)
    {
        return adminService.updateAdmin(admin, adminId);
    }

    // Delete operation
    @DeleteMapping("/admin/{id}")
    public String deleteAdminById(@PathVariable("id")
                                   Integer adminId)
    {
        adminService.deleteAdmin(
                adminId);
        return "Deleted Successfully";
    }
}

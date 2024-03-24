package lk.hasi.labbookingsystem.service;

import lk.hasi.labbookingsystem.dto.AdminDTO;
import lk.hasi.labbookingsystem.entity.Admin;

import java.util.List;

public interface AdminService {

    AdminDTO adminRegistration(Admin admin);

    List<AdminDTO> fetchAdmins();

    Admin updateAdmin(Admin admin,
                             Integer adminId);

    void deleteAdmin(Integer adminId);
}

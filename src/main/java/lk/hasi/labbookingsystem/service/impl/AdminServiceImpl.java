package lk.hasi.labbookingsystem.service.impl;

import lk.hasi.labbookingsystem.dto.AdminDTO;
import lk.hasi.labbookingsystem.repo.AdminRepository;
import lk.hasi.labbookingsystem.entity.Admin;
import lk.hasi.labbookingsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public AdminDTO adminRegistration(Admin admin) {
        try{
            AdminDTO adminDTO = new AdminDTO();
            Admin result = adminRepository.save(admin);
            adminDTO.setId(result.getId());
            adminDTO.setName(result.getName());
            adminDTO.setNIC(result.getNIC());
            adminDTO.setPassword(result.getPassword());


            return adminDTO;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AdminDTO> fetchAdmins() {
        try{
            List<AdminDTO> adminDTOList =new ArrayList<>();
            List<Admin> result = adminRepository.findAll();
            if(!result.isEmpty()){
                for(Admin admin: result){
                    AdminDTO adminDTO = new AdminDTO();
                    adminDTO.setPassword(admin.getPassword());
                    adminDTO.setNIC(admin.getNIC());
                    adminDTO.setId(admin.getId());
                    adminDTO.setName(admin.getName());

                    adminDTOList.add(adminDTO);
                }
                return adminDTOList;
            }
            return null;
        }catch (Exception ex){
            return null;
        }
    }

    @Override
    public Admin updateAdmin(Admin admin, Integer adminId) {
        return null;
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        adminRepository.deleteById(adminId);
    }
}

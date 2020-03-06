package com.easytrip.easytrip.service;

import com.easytrip.easytrip.dao.AdminDao;
import com.easytrip.easytrip.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    private final AdminDao adminDao;

    @Autowired
    public AdminService(@Qualifier("fakeAdminDao") AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public boolean persistNewAdmin(UUID adminId, Admin admin){
        UUID adminUid = adminId==null ? UUID.randomUUID() : adminId;
        admin.setId(adminId);
        return adminDao.insertNewAdmin(adminUid,admin);
    }

    public Admin getAdminById(UUID adminId){
        return adminDao.selectAdminById((adminId));
    }

    public List<Admin> getAllAdmins(){
        return adminDao.selectAllAdmins();
    }

    public boolean updateAdminById(UUID adminId, Admin adminUpdate){
        return adminDao.updateAdminById(adminId,adminUpdate);
    }

    public boolean deleteAdminById(UUID studentId){
        return adminDao.deleteAdminById((studentId));
    }

}

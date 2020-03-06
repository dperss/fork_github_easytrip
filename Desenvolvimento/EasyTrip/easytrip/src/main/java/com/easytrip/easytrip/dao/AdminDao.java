package com.easytrip.easytrip.dao;
import com.easytrip.easytrip.model.Admin;

import java.util.List;
import java.util.UUID;

public interface AdminDao {

    boolean insertNewAdmin(UUID personId, Admin admin);

    Admin selectAdminById(UUID personId);

    List<Admin> selectAllAdmins();

    boolean updateAdminById(UUID admin, Admin adminUpdate);

    boolean deleteAdminById(UUID adminId);
}

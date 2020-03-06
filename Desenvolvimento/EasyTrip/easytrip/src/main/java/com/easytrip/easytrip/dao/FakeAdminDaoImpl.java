package com.easytrip.easytrip.dao;

import com.easytrip.easytrip.model.Admin;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeAdminDao")
public class FakeAdminDaoImpl implements AdminDao {

    private final Map<UUID, Admin> database;

    public FakeAdminDaoImpl(){
        database = new HashMap<>();
        UUID personId = UUID.randomUUID();
        database.put(personId,new Admin(personId,"asdf","Alex"));
    }

    @Override
    public boolean insertNewAdmin(UUID personId, Admin admin){
        database.put(personId,admin);
        return true;
    }

    @Override
    public Admin selectAdminById(UUID personId){
        return database.get(personId);
    }

    @Override
    public List<Admin> selectAllAdmins(){
        return new ArrayList<>(database.values());
    }

    @Override
    public boolean updateAdminById(UUID adminId, Admin adminUpdate){
        database.put(adminId,adminUpdate);
        return true;
    }

    @Override
    public boolean deleteAdminById(UUID adminId){
        database.remove(adminId);
        return true;
    }
}

package com.easytrip.easytrip.resource;


import com.easytrip.easytrip.model.Admin;
import com.easytrip.easytrip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/admins")
public class AdminResource {

    private final AdminService adminService;

    @Autowired
    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Admin> getAllAdmins(){

        return adminService.getAllAdmins();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{adminId}"
    )
    public Admin getAdminsById(@PathVariable("adminId") UUID adminId){

        return adminService.getAdminById(adminId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public void insertNewAdmin(@RequestBody Admin admin){
        adminService.persistNewAdmin(UUID.randomUUID(),admin);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{adminId}"
    )

    public void updateNewAdmin(@PathVariable("adminId") UUID adminId, @RequestBody Admin admin){
        adminService.updateAdminById(adminId,admin);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{adminId}"
    )

    public void updateNewAdmin(@PathVariable("adminId") UUID adminId){
        adminService.deleteAdminById(adminId);
    }
}

package com.example.customer_relationship_manager.Controller;

import com.example.customer_relationship_manager.Model.Owner;
import com.example.customer_relationship_manager.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "https://crm-frontend-production-f09c.up.railway.app")
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @PostMapping("/signup")
    public String addPerson(@RequestBody Owner owner) {
        return ownerService.addPerson(owner);
    }

    @GetMapping("/dummy")
    public String checkLogin(){
        return "login checked";
    }

    @GetMapping("/getOwnerByEmailId/{emailId}")
    public String getOwnerByEmailId(@PathVariable("emailId") String email){
        return ownerService.getOwnerByEmailId(email);
    }

    @PostMapping("/forgot_password")
    public String forgotPassword(@RequestBody Owner owner){
        return ownerService.forgotPassword(owner);
    }

}

package com.group2.petcaredriver.controller;

import com.group2.petcaredriver.entity.BaseService;
import com.group2.petcaredriver.service.ServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "v1/constant")
@Slf4j
public class ConstantController {
    @Autowired
    ServiceService service;

    @GetMapping(value = "/getAllServices")
    public ResponseEntity<List<BaseService>> getAllServices() {
        return ResponseEntity.accepted().body(service.getAllServices());
    }

    @PostMapping(value = "/addService")
    public ResponseEntity<BaseService> createNewBaseService(@RequestBody BaseService baseService) {
        return ResponseEntity.accepted().body(service.createNewService(baseService));
    }

    @PostMapping(value = "/deleteService")
    public ResponseEntity<String> deleteBaseService(@RequestBody BaseService baseService) {
        service.deleteService(baseService);
        return ResponseEntity.accepted().body("Delete service success!");
    }

    @PutMapping(value = "/updateService")
    public ResponseEntity<BaseService> updateBaseService(@RequestBody BaseService baseService) {
        return ResponseEntity.accepted().body(service.updateService(baseService));
    }
}

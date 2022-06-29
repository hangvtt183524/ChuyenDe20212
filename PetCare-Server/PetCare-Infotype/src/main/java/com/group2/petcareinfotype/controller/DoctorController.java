package com.group2.petcareinfotype.controller;

import com.group2.petcareinfotype.entity.Doctor;
import com.group2.petcareinfotype.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "v1/doctor")
@Slf4j
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping(value = "/search")
    public ResponseEntity<List<Doctor>> searchDoctor(@RequestParam(name = "username", required = false) String username,
                                                   @RequestParam(name = "mail", required = false) String mail,
                                                   @RequestParam(name = "phone", required = false) String phone,
                                                   @RequestParam(name = "address", required = false) String address,
                                                   @RequestParam(name = "major", required = false) String major) {
        return ResponseEntity.accepted().body(doctorService.getDoctor(username, mail, phone, address, major));
    }

    @PostMapping(value = "/searchById")
    public ResponseEntity<Doctor> searchDoctorById(@RequestBody String id) {
        return ResponseEntity.accepted().body(doctorService.getDoctorById(id));
    }

    @GetMapping(value = "/searchAll")
    public ResponseEntity<List<Doctor>> searchAllDoctor() {
        return ResponseEntity.accepted().body(doctorService.getAllDoctors());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.accepted().body(doctorService.updateDoctor(doctor));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.accepted().body(doctorService.createDoctor(doctor));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> deleteDoctor(@RequestBody Doctor doctor) {
        doctorService.deleteDoctor(doctor);
        return ResponseEntity.accepted().body("Delete doctor success");
    }
}

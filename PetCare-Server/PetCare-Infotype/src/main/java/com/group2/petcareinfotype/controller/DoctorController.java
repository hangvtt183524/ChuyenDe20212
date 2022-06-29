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

    @GetMapping(value = "/searchById")
    public ResponseEntity<Doctor> searchDoctorById(@RequestParam(name = "id", required = false) String id) {
        return ResponseEntity.accepted().body(doctorService.getDoctorById(id));
    }

    @GetMapping(value = "/searchAll")
    public ResponseEntity<List<Doctor>> searchAllDoctor() {
        return ResponseEntity.accepted().body(doctorService.getAllDoctors());
    }

    @GetMapping(value = "/update")
    public ResponseEntity<Doctor> updateDoctor(@RequestParam(name = "id", required = false) Long id,
                                               @RequestParam(name = "doctorName", required = false) String doctorName,
                                               @RequestParam(name = "mail", required = false) String mail,
                                               @RequestParam(name = "phone", required = false) String phone,
                                               @RequestParam(name = "address", required = false) String address,
                                               @RequestParam(name = "major", required = false) String major,
                                               @RequestParam(name = "password", required = false) String password) {
        Doctor updateDoctor = Doctor.builder().id(id)
                .doctorName(doctorName)
                .mail(mail)
                .phone(phone)
                .password(password)
                .address(address)
                .major(major)
                .build();
        return ResponseEntity.accepted().body(doctorService.updateDoctor(updateDoctor));
    }

    @GetMapping(value = "/create")
    public ResponseEntity<Doctor> createDoctor(@RequestParam(name = "doctorName", required = false) String doctorName,
                                               @RequestParam(name = "mail", required = false) String mail,
                                               @RequestParam(name = "phone", required = false) String phone,
                                               @RequestParam(name = "address", required = false) String address,
                                               @RequestParam(name = "major", required = false) String major,
                                               @RequestParam(name = "password", required = false) String password) {
        Doctor saveDoctor = Doctor.builder()
                .doctorName(doctorName)
                .mail(mail)
                .phone(phone)
                .password(password)
                .address(address)
                .major(major)
                .build();
        return ResponseEntity.accepted().body(doctorService.createDoctor(saveDoctor));
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteDoctor(@RequestParam(name = "id", required = false) Long id,
                                               @RequestParam(name = "doctorName", required = false) String doctorName,
                                               @RequestParam(name = "mail", required = false) String mail,
                                               @RequestParam(name = "phone", required = false) String phone,
                                               @RequestParam(name = "address", required = false) String address,
                                               @RequestParam(name = "major", required = false) String major,
                                               @RequestParam(name = "password", required = false) String password) {
        Doctor deleteDoctor = Doctor.builder().id(id)
                .doctorName(doctorName)
                .mail(mail)
                .phone(phone)
                .password(password)
                .address(address)
                .major(major)
                .build();
        doctorService.deleteDoctor(deleteDoctor);
        return ResponseEntity.accepted().body("Delete doctor success");
    }
}

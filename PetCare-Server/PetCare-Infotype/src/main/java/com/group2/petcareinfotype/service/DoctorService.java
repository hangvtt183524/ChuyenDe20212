package com.group2.petcareinfotype.service;

import com.group2.petcareinfotype.entity.Doctor;
import com.group2.petcareinfotype.entity.User;
import com.group2.petcareinfotype.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public Doctor getDoctorById(final String id) {
        Doctor doctor = null;
        if (id != null) {
            Optional<Doctor> optionalDoctor = doctorRepository.findById(Long.parseLong(id));
            if (optionalDoctor.isPresent() && optionalDoctor.get() != null) {
                doctor = optionalDoctor.get();
            } else {
                throw new IllegalArgumentException("No Doctor existed!");
            }
        }

        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getDoctor(final String doctorName, final String mail, final String phone, final String address, final String major) {
        return doctorRepository.findAll().stream().filter(doctor -> {
            boolean equalDoctorname = true;
            boolean equalMail = true;
            boolean equalPhone = true;
            boolean equalAddress = true;
            boolean equalMajor = true;

            if (doctorName != null) {
                equalDoctorname = doctor.getDoctorName().contains(doctorName);
            }
            if (mail != null) {
                equalMail = doctor.getMail().equals(mail);
            }
            if (phone != null) {
                equalPhone = doctor.getPhone().equals(phone);
            }
            if (address != null) {
                equalAddress = doctor.getAddress().equals(address);
            }
            if (major != null) {
                equalMajor = doctor.getMajor().equals(major);
            }

            return equalDoctorname && equalMail && equalPhone && equalAddress && equalMajor;
        }).collect(Collectors.toList());
    }

    public Doctor updateDoctor(final Doctor doctor) {
        if (doctor.getId() == null || !doctorRepository.findById(doctor.getId()).isPresent()) {
            throw new IllegalArgumentException("No matching doctor existed!");
        } else {
            return doctorRepository.save(doctor);
        }
    }

    public Doctor createDoctor(final Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(final Doctor doctor) {
        if (doctor.getId() == null || !doctorRepository.findById(doctor.getId()).isPresent()) {
            throw new IllegalArgumentException("No matching doctor existed!");
        } else {
            doctorRepository.delete(doctor);
        }
    }
}

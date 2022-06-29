package com.group2.petcareinfotype.service;

import com.group2.petcareinfotype.entity.Examination;
import com.group2.petcareinfotype.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExaminationService {
    @Autowired
    ExaminationRepository examinationRepository;

    public Examination getExamById(final String id) {
        Examination examination = null;
        if (id != null) {
            Optional<Examination> optionalExam = examinationRepository.findById(Long.parseLong(id));
            if (optionalExam.isPresent() && optionalExam.get() != null) {
                examination = optionalExam.get();
            } else {
                throw new IllegalArgumentException("No Examination existed!");
            }
        }

        return examination;
    }

    public List<Examination> getAllExams() {
        return examinationRepository.findAll();
    }

    public List<Examination> getExam(final Long doctorId, final Long ownerId, final Long petId, final Integer dateStart, final Integer dateEnd, final Integer status) {
        return examinationRepository.findAll().stream().filter(exam -> {
            boolean equalDoctor = true;
            boolean equalOwner = true;
            boolean equalPet = true;
            boolean inDateStart = true;
            boolean inDateEnd = true;
            boolean equalStatus = true;

            if (doctorId != null) {
                equalDoctor = exam.getDoctorId().equals(doctorId);
            }
            if (ownerId != null) {
                equalOwner = exam.getOwnerId().equals(ownerId);
            }
            if (petId != null) {
                equalPet = exam.getPetId().equals(petId);
            }
            if (dateStart != null) {
                inDateStart = exam.getStartDate() >= dateStart;
            }
            if (dateEnd != null) {
                inDateEnd = exam.getEndDate() <= dateEnd;
            }
            if (status != null) {
                equalStatus = exam.getStatus().equals(status);
            }

            return equalDoctor && equalOwner && equalPet && inDateStart && inDateEnd && equalStatus;
        }).collect(Collectors.toList());
    }

    public Examination updateExam(final Examination examination) {
        if (examination.getId() == null || !examinationRepository.findById(examination.getId()).isPresent()) {
            throw new IllegalArgumentException("No matching examination existed!");
        } else {
            return examinationRepository.save(examination);
        }
    }

    public void deleteExam(final Examination examination) {
        if (examination.getId() == null || !examinationRepository.findById(examination.getId()).isPresent()) {
            throw new IllegalArgumentException("No matching examination existed!");
        } else {
            examinationRepository.delete(examination);
        }
    }

    public Examination createExam(final Examination examination) {
        Optional<Examination> existedExamination = examinationRepository.findById(examination.getId());
        if (existedExamination.isPresent() && existedExamination.get() != null) {
            throw new IllegalArgumentException("Examination with same Id had been existed!");
        }

        Examination savedExam = examinationRepository.save(examination);
        return savedExam;
    }

    public Examination setExam(final Examination examination) {
        if (examination.getDoctorId() == null) {
            throw new IllegalArgumentException("Must set doctor for examination!");
        }

        if (examination.getStatus() != null) {
            throw new IllegalArgumentException("Must set status for examination!");
        }

        return examinationRepository.save(examination);
    }
}

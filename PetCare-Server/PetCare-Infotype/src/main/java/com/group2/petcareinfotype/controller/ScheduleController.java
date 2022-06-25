package com.group2.petcareinfotype.controller;

import com.group2.petcareinfotype.entity.Examination;
import com.group2.petcareinfotype.service.ExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    ExaminationService examinationService;

    @PostMapping(value = "/searchById")
    public ResponseEntity<Examination> searchExamById(@RequestBody String id) {
        return ResponseEntity.accepted().body(examinationService.getExamById(id));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Examination>> searchExam(@RequestParam(name = "doctorId", required = false) Long doctorId,
                                                  @RequestParam(name = "ownerId", required = false) Long ownerId,
                                                  @RequestParam(name = "petId", required = false) Long petId,
                                                  @RequestParam(name = "dateStart", required = false) Integer dateStart,
                                                  @RequestParam(name = "dateEnd", required = false) Integer dateEnd,
                                                  @RequestParam(name = "status", required = false) Integer status) {
        return ResponseEntity.accepted().body(examinationService.getExam(doctorId, ownerId, petId, dateStart, dateEnd, status));
    }

    @GetMapping(value = "/searchAll")
    public ResponseEntity<List<Examination>> searchAllExam() {
        return ResponseEntity.accepted().body(examinationService.getAllExams());
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Examination> updateExam(@RequestBody Examination examination) {
        return ResponseEntity.accepted().body(examinationService.updateExam(examination));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> deleteExam(@RequestBody Examination examination) {
        examinationService.deleteExam(examination);
        return ResponseEntity.accepted().body("Delete examination success");
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Examination> createExam(@RequestBody Examination examination) {
        return ResponseEntity.accepted().body(examinationService.createExam(examination));
    }
}

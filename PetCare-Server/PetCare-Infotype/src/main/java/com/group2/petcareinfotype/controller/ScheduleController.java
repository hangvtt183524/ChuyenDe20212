package com.group2.petcareinfotype.controller;

import com.group2.petcareinfotype.entity.Examination;
import com.group2.petcareinfotype.service.ExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "v1/schedule")
@Slf4j
public class ScheduleController {
    @Autowired
    ExaminationService examinationService;

    @GetMapping(value = "/searchById")
    public ResponseEntity<Examination> searchExamById(@RequestParam(name = "id", required = false) Long id) {
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

    @GetMapping(value = "/update")
    public ResponseEntity<Examination> updateExam(@RequestParam(name = "id", required = false) Long id,
                                                  @RequestParam(name = "ownerId", required = false) Long ownerId,
                                                  @RequestParam(name = "doctorId", required = false) Long doctorId,
                                                  @RequestParam(name = "firstDescription", required = false) String firstDescription,
                                                  @RequestParam(name = "result", required = false) String result,
                                                  @RequestParam(name = "status", required = false) Integer status) {
        Examination updateExamination = Examination.builder().id(id)
                .ownerId(ownerId)
                .doctorId(doctorId)
                .firstDescription(firstDescription)
                .result(result)
                .status(status)
                .build();
        return ResponseEntity.accepted().body(examinationService.updateExam(updateExamination));
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteExam(@RequestParam(name = "id", required = false) Long id,
                                             @RequestParam(name = "ownerId", required = false) Long ownerId,
                                             @RequestParam(name = "doctorId", required = false) Long doctorId,
                                             @RequestParam(name = "firstDescription", required = false) String firstDescription,
                                             @RequestParam(name = "result", required = false) String result,
                                             @RequestParam(name = "status", required = false) Integer status) {
        Examination deleteExamination = Examination.builder().id(id)
                .ownerId(ownerId)
                .doctorId(doctorId)
                .firstDescription(firstDescription)
                .result(result)
                .status(status)
                .build();
        examinationService.deleteExam(deleteExamination);
        return ResponseEntity.accepted().body("Delete examination success");
    }

    @GetMapping(value = "/create")
    public ResponseEntity<Examination> createExam(@RequestParam(name = "ownerId", required = false) Long ownerId,
                                                  @RequestParam(name = "doctorId", required = false) Long doctorId,
                                                  @RequestParam(name = "firstDescription", required = false) String firstDescription,
                                                  @RequestParam(name = "result", required = false) String result,
                                                  @RequestParam(name = "status", required = false) Integer status) {
        Examination createExamination = Examination.builder()
                .ownerId(ownerId)
                .doctorId(doctorId)
                .firstDescription(firstDescription)
                .result(result)
                .status(status)
                .build();
        return ResponseEntity.accepted().body(examinationService.createExam(createExamination));
    }

    @GetMapping(value = "/set-schedule")
    public ResponseEntity<Examination> setSchedule(@RequestParam(name = "id", required = false) Long id,
                                                   @RequestParam(name = "ownerId", required = false) Long ownerId,
                                                   @RequestParam(name = "doctorId", required = false) Long doctorId,
                                                   @RequestParam(name = "firstDescription", required = false) String firstDescription,
                                                   @RequestParam(name = "result", required = false) String result,
                                                   @RequestParam(name = "status", required = false) Integer status) {
        Examination examination = Examination.builder().id(id)
                .ownerId(ownerId)
                .doctorId(doctorId)
                .firstDescription(firstDescription)
                .result(result)
                .status(status)
                .build();
        return ResponseEntity.accepted().body(examinationService.setExam(examination));
    }
}

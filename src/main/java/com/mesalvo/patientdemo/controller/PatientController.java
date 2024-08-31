package com.mesalvo.patientdemo.controller;

import com.mesalvo.patientdemo.dto.PatientRequestDTO;
import com.mesalvo.patientdemo.dto.PatientResponseDTO;
import com.mesalvo.patientdemo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public Mono<PatientResponseDTO> create(@RequestBody PatientRequestDTO patient) {
        return patientService.create(patient);
    }

    @GetMapping("/{id}")
    public Mono<PatientRequestDTO> findById(@PathVariable Integer id) {
        return patientService.findById(id);
    }

    @GetMapping
    public Flux<PatientRequestDTO> findByLastName(@RequestParam(name = "lastName") String searchString) {
        return patientService.findByLastName(searchString);
    }
}

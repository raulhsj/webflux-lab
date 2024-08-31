package com.mesalvo.patientdemo.service;

import com.mesalvo.patientdemo.dto.PatientRequestDTO;
import com.mesalvo.patientdemo.dto.PatientResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientService {
    Mono<PatientResponseDTO> create(PatientRequestDTO patient);
    Mono<PatientRequestDTO> findById(Integer id);
    Flux<PatientRequestDTO> findByLastName(String searchString);
}

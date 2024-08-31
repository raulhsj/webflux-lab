package com.mesalvo.patientdemo.service.impl;

import com.mesalvo.patientdemo.dto.PatientRequestDTO;
import com.mesalvo.patientdemo.dto.PatientResponseDTO;
import com.mesalvo.patientdemo.model.Patient;
import com.mesalvo.patientdemo.repository.PatientRepository;
import com.mesalvo.patientdemo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper mapper;

    @Override
    public Mono<PatientResponseDTO> create(PatientRequestDTO patient) {
        return patientRepository.save(mapper.map(patient, Patient.class))
                .map(patientDB -> mapper.map(patientDB, PatientResponseDTO.class));
    }

    @Override
    public Mono<PatientRequestDTO> findById(Integer id) {
        return patientRepository.findById(id)
                .map(patientDB -> mapper.map(patientDB, PatientRequestDTO.class));
    }

    @Override
    public Flux<PatientRequestDTO> findByLastName(String searchString) {
        return patientRepository.findByLastNameStartsWith(searchString).map(patientDB -> mapper.map(patientDB, PatientRequestDTO.class));
    }
}

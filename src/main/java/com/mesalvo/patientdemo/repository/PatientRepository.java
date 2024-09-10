package com.mesalvo.patientdemo.repository;

import com.mesalvo.patientdemo.model.Patient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PatientRepository extends ReactiveMongoRepository<Patient, Integer> {
    Flux<Patient> findByLastNameStartsWith(String searchString);
}

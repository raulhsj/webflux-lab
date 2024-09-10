package com.mesalvo.patientdemo;

import com.mesalvo.patientdemo.enums.Gender;
import com.mesalvo.patientdemo.model.Patient;
import com.mesalvo.patientdemo.repository.PatientRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

@DataMongoTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PatientMongoTests {

    @Autowired
    private PatientRepository patientRepository;

    Mono<Patient> idSavedPatient;

    @BeforeAll
    public void setup() {
        idSavedPatient = patientRepository.save(Patient.builder().id(1).firstName("Perico").lastName("Palotes").birthDate(LocalDate.of(1981,7,5)).gender(Gender.MALE).build());
    }

    @AfterAll
    public void clean() {
        patientRepository.deleteAll();
    }

    @Test
    public void shouldCreatePatientOK() {
        //Then
        StepVerifier.create(idSavedPatient).expectNextMatches(p -> p.getFirstName().equals("Perico") && p.getLastName().equals("Palotes")).verifyComplete();
    }

    @Test
    public void shouldRetrievePatientOK() {
        //Given
        var id = 1;
        //When
        var patient = patientRepository.findById(id);

        //Then
        StepVerifier.create(patient).expectNextMatches(p -> p.getFirstName().equals("Perico") && p.getLastName().equals("Palotes")).verifyComplete();
    }

    @Test
    public void shouldRetrievePatientOKSearchingByLastName() {
        //Given
        var searchString = "Pal";
        //When
        var patient = patientRepository.findByLastNameStartsWith(searchString);

        //Then
        StepVerifier.create(patient).expectNextMatches(p -> p.getFirstName().equals("Perico") && p.getLastName().equals("Palotes")).verifyComplete();
    }

    @Test
    public void shouldFailOnNonExistentPatient() {
        //Given
        var id = 35;
        //When
        var patient = patientRepository.findById(id);

        //Then
        StepVerifier.create(patient).expectError().verify();
    }

}

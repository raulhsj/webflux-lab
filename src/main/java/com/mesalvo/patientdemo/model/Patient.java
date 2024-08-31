package com.mesalvo.patientdemo.model;

import com.mesalvo.patientdemo.enums.Gender;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@Builder
public class Patient {
    @Id
    int id;

    String lastName;
    String firstName;
    LocalDate birthDate;
    Gender gender;
}

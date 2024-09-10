package com.mesalvo.patientdemo.model;

import com.mesalvo.patientdemo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    int id;

    String lastName;
    String firstName;
    LocalDate birthDate;
    Gender gender;
}

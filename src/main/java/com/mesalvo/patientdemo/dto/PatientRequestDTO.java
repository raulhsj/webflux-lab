package com.mesalvo.patientdemo.dto;

import com.mesalvo.patientdemo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientRequestDTO {
    String lastName, firstName;
    LocalDate birthDate;
    Gender gender;
}

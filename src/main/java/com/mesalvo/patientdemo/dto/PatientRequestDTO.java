package com.mesalvo.patientdemo.dto;

import com.mesalvo.patientdemo.enums.Gender;
import java.time.LocalDate;

public record PatientRequestDTO(String lastName, String firstName, LocalDate birthDate, Gender gender) {}

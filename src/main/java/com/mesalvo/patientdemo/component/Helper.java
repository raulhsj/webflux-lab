package com.mesalvo.patientdemo.component;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Helper {

    @Bean
    ModelMapper mapper() { return new ModelMapper(); }
}

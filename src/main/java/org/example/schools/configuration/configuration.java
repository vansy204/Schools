package org.example.schools.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //modelMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        modelMapper.getConfiguration();
        return modelMapper;
    }
}

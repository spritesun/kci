package com.kci.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kci.entity.PipelineConfiguration;
import org.springframework.stereotype.Component;

@Component
public class PipelineConfigurationParser {
    public PipelineConfiguration parseJson(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonString, PipelineConfiguration.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

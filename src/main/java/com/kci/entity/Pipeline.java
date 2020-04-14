package com.kci.entity;

import lombok.Data;
import org.dizitart.no2.objects.Id;

import java.io.IOException;
import java.io.Serializable;

@Data
public class Pipeline implements Serializable {
    @Id
    private String name;
    private Repository repository;
    private PipelineConfiguration configuration;

    public Pipeline() {
    }

    public Pipeline(String name, Repository repository, PipelineConfiguration configuration) throws IOException {
        this.name = name;
        this.repository = repository;
        this.configuration = configuration;
    }
}

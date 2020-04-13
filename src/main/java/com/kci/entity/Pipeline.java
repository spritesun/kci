package com.kci.entity;

import lombok.Data;
import org.dizitart.no2.objects.Id;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
public class Pipeline implements Serializable {
    @Id
    private String name;
    private Repository repository;
    private String configuration;

    public Pipeline() {
    }

    public Pipeline(String name, Repository repository) throws IOException {
        this.name = name;
        this.repository = repository;
        Path path = Paths.get(repository.getAbsolutePath() + "/kci.json");
        this.configuration = Files.readAllLines(path).get(0);
    }
}

package com.kci.entity;

import lombok.Data;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Data
public class Repository implements Serializable {
    private static final String REPOSITORY_BASE_PATH = "/tmp/kci/repository/";

    private String url;
    private String directory;

    public Repository() {
    }

    public Repository(String url) {
        this.url = url;
        this.directory = UUID.randomUUID().toString();
    }

    public String getAbsolutePath() {
        return REPOSITORY_BASE_PATH + directory;
    }

    public String getKciJson() throws IOException {
        Path path = Paths.get(getAbsolutePath() + "/kci.json");
        return new String(Files.readAllBytes(path));
    }
}

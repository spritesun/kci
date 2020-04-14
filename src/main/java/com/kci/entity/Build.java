package com.kci.entity;

import lombok.Data;
import org.dizitart.no2.objects.Id;

@Data
public class Build {
    @Id
    private int sequence;
    private String pipelineName;

    public Build() {
    }

    public Build(Pipeline pipeline) {
        this.pipelineName = pipeline.getName();
    }
}

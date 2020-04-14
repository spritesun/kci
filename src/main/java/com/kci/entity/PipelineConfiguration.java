package com.kci.entity;

import lombok.Data;

import java.util.List;

@Data
public class PipelineConfiguration {
    private List<Stage> stages;
}

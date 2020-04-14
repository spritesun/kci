package com.kci.entity;

import lombok.Data;

import java.util.List;

@Data
public class Stage {
    private String name;
    private List<Job> jobs;
}

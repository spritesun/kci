package com.kci.job;

import org.springframework.stereotype.Component;

public class LogRecorder {
    public void log(String line) {
        // TODO: should write log to file
        System.out.println(line);
    }
}

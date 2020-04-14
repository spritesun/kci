package com.kci.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class LinuxShellExecutor {
    @Autowired
    protected LogRecorder logRecorder;

    public void execute(String command) {
        execute(command, null);
    }

    public void execute(String command, String homeDirectory) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (null != homeDirectory) {
            processBuilder.directory(new File(homeDirectory));
        }
        processBuilder.command("bash", "-c", command);
        try {
            Process process = processBuilder.start();
            logRecorder.log("\nExecuting: " + command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                logRecorder.log(line);
            }
            int exitCode = process.waitFor();
            logRecorder.log("\nExited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

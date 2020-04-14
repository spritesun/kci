package com.kci.job;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class JobInstance {
    protected LogRecorder logRecorder = new LogRecorder();

    protected String homeDirectory;

    public JobInstance(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    abstract void execute();

    protected void executeLinuxShell(String command) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(homeDirectory));
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

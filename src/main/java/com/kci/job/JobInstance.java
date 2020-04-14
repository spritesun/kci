package com.kci.job;

public abstract class JobInstance {
    protected String DEFAULT_IMAGE_NAME = "localhost:5000/spring-demo:1.0";

    protected String homeDirectory;

    public JobInstance(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    abstract void execute();

    protected void executeLinuxShell(String command) {
        new LinuxShellExecutor().execute(command, homeDirectory);
    }
}

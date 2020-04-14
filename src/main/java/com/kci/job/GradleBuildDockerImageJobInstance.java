package com.kci.job;

public class GradleBuildDockerImageJobInstance extends JobInstance {
    public GradleBuildDockerImageJobInstance(String homeDirectory) {
        super(homeDirectory);
    }

    @Override
    public void execute() {
        executeLinuxShell("./gradlew clean build");
//        TODO: should handle image version tag
        executeLinuxShell(String.format("docker build -t spring-demo ."));
    }
}

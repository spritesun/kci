package com.kci.job;

public class DeployDockerImageJobInstance extends JobInstance {
    public DeployDockerImageJobInstance(String homeDirectory) {
        super(homeDirectory);
    }

    @Override
    public void execute() {
        executeLinuxShell(String.format("IMAGE_NAME=%s kubectl delete -f %s",
                DEFAULT_IMAGE_NAME, homeDirectory + "/kubectl.yaml" ));
        executeLinuxShell(String.format("IMAGE_NAME=%s kubectl apply -f %s",
                DEFAULT_IMAGE_NAME, homeDirectory + "/kubectl.yaml" ));
    }
}

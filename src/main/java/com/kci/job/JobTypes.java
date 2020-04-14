package com.kci.job;


public enum JobTypes {
    GRADLE_BUILD_DOCKER_IMAGE {
        @Override
        public JobInstance createJobInstance(String homeDirectory) {
            return new GradleBuildDockerImageJobInstance(homeDirectory);
        }
    },
    DEPLOY_DOCKER_IMAGE {
        @Override
        public JobInstance createJobInstance(String homeDirectory) {

            return new DeployDockerImageJobInstance(homeDirectory);
        }
    };

    public abstract JobInstance createJobInstance(String homeDirectory);
}

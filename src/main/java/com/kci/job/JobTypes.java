package com.kci.job;


public enum JobTypes {
    GRADLE_BUILD_DOCKER_IMAGE {
        @Override
        public JobInstance createJobInstance() {
            return new GradleBuildDockerImageJobInstance();
        }
    },
    DEPLOY_DOCKER_IMAGE {
        @Override
        public JobInstance createJobInstance() {

            return new DeployDockerImageJobInstance();
        }
    };

    public abstract JobInstance createJobInstance();
}

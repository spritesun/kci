package com.kci.command;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "create",
        description = "Create pipeline from a template codebase"
)
public class PipelineCreateCommand implements Callable<Integer> {
    private static final String TEMPLATE_CODEBASE = "https://github.com/spritesun/spring-boot-http-gradle-demo";

    @Override
    public Integer call() throws Exception {
        service.createWithUri()
        return 0;
    }
}

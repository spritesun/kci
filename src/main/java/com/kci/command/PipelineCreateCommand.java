package com.kci.command;

import com.kci.service.PipelineCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "create",
        description = "Create pipeline from a template codebase"
)
public class PipelineCreateCommand implements Callable<Integer> {
    private static final String TEMPLATE_CODEBASE_URL = "https://github.com/spritesun/spring-boot-http-gradle-demo";

    @Autowired
    private PipelineCreateService service;

    @Override
    public Integer call() throws Exception {
        service.createWithUrl(TEMPLATE_CODEBASE_URL);
        return 0;
    }
}

package com.kci.command;

import com.kci.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "create",
        description = "Create pipeline from a template codebase"
)
public class PipelineCreateCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-n", "--name"}, description = "Pipeline name, must be unique", required = true)
    private String name;

    @CommandLine.Option(names = {"-u", "--url"}, description = "Pipeline code repository url", required = true)
    private String url;

    @Autowired
    private PipelineService pipelineService;

    @Override
    public Integer call() throws Exception {
        pipelineService.create(name, url);
        return 0;
    }
}

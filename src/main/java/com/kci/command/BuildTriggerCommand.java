package com.kci.command;

import com.kci.entity.Pipeline;
import com.kci.service.BuildService;
import com.kci.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "trigger",
        description = "Trigger a build for pipeline"
)
public class BuildTriggerCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-n", "--name"}, description = "Pipeline name", required = true)
    private String name;

    @Autowired
    private BuildService buildService;

    @Autowired
    private PipelineService pipelineService;

    @Override
    public Integer call() throws Exception {
        Pipeline pipeline = pipelineService.getPipeline(name);

        if (pipeline == null) {
            System.err.println(String.format("Can not find pipeline %s.", name));
            return -1;
        }
        buildService.trigger(pipeline);
        return 0;
    }
}

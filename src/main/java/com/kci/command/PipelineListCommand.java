package com.kci.command;

import com.kci.entity.Pipeline;
import com.kci.view.PipelineListView;
import com.kci.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List all pipelines"
)
public class PipelineListCommand implements Callable<Integer> {
    @Autowired
    private PipelineService pipelineService;

    @Autowired
    private PipelineListView view;

    @Override
    public Integer call() throws Exception {
        List<Pipeline> pipelines = pipelineService.getPipelines();
        System.out.println(view.render(pipelines));
        return 0;
    }
}

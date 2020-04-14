package com.kci.command;

import com.kci.entity.Build;
import com.kci.service.BuildService;
import com.kci.view.BuildListView;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List all build"
)
public class BuildListCommand implements Callable<Integer> {

    @Autowired
    private BuildService buildService;

    @Autowired
    private BuildListView view;

    @Override
    public Integer call() throws Exception {
        List<Build> builds = buildService.getBuilds();
        System.out.println(view.render(builds));
        return null;
    }
}

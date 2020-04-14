package com.kci.command;

import com.kci.view.StubEnviromentListView;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

@CommandLine.Command(
        name = "environment",
        aliases = {"env"},
        description = "List available environments"
)
public class EnvironmentCommand extends InternalCommand {
    @Autowired
    private StubEnviromentListView view;

    @Override
    public Integer call() throws Exception {
        System.out.println(view.render());
        return 0;
    }
}

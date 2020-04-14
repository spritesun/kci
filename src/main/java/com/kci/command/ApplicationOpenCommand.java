package com.kci.command;

import com.kci.job.LinuxShellExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "open",
        description = "Open deployed application"
)
public class ApplicationOpenCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-n", "--name"}, description = "Application name", required = true)
    private String name;
    @Autowired
    private LinuxShellExecutor executor;

    @Override
    public Integer call() throws Exception {
        // TODO: port should not hard card
        executor.execute(String.format("kubectl port-forward deployment/%s 8080:8080", name));
        return 0;
    }
}

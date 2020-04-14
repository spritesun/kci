package com.kci.command;

import com.kci.job.LinuxShellExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List deployed applications"
)
public class ApplicationListCommand implements Callable<Integer> {
    @Autowired
    private LinuxShellExecutor executor;

    @Override
    public Integer call() throws Exception {
        executor.execute("kubectl get deployments");
        return 0;
    }
}

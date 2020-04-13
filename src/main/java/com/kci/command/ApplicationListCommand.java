package com.kci.command;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List deployed applications"
)
public class ApplicationListCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("listing applications");
        return 0;
    }
}

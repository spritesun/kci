package com.kci.command;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List running build"
)
public class BuildListCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

package com.kci.command;

import picocli.CommandLine;

import java.util.concurrent.Callable;

public abstract class InternalCommand implements Callable<Integer> {
    @CommandLine.Spec
    private CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() {
        spec.commandLine().usage(System.out);
        return 0;
    }
}

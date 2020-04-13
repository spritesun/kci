package com.kci.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "build",
        description = "Trigger build, list running builds"
)
public class BuildCommand extends InternalCommand {
}
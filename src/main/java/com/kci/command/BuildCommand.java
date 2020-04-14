package com.kci.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "build",
        description = "Trigger build, list running builds",
        subcommands = {
                BuildTriggerCommand.class,
                BuildListCommand.class
        }
)
public class BuildCommand extends InternalCommand {

}
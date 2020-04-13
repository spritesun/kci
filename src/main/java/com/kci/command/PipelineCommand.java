package com.kci.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "pipeline",
        description = "List pipelines, create pipeline",
        subcommands = {
                PipelineListCommand.class,
                PipelineCreateCommand.class
        }
)
public class PipelineCommand extends InternalCommand {
}

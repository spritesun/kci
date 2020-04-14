package com.kci.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "application",
        description = "List/Open deployed applications",
        subcommands = {
                ApplicationListCommand.class,
                ApplicationOpenCommand.class
        }
)
public class ApplicationCommand extends InternalCommand {
}

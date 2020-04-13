package com.kci.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "application",
        description = "List deployed applications",
        subcommands = {
                ApplicationListCommand.class
        }
)
public class ApplicationCommand extends InternalCommand {
}

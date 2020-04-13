package com.kci.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "environment",
        aliases = {"env"},
        description = "List available environments"
)
public class EnvironmentCommand  extends InternalCommand {
}

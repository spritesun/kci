package com.kci.command;

import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Component
@Command(
        name = "kci",
        description = "A kubernetes native CI/CD tool",
        version = "0.1.0",
        mixinStandardHelpOptions = true,
        subcommands = {
                PipelineCommand.class,
                BuildCommand.class,
                EnvironmentCommand.class,
                ApplicationCommand.class
        }
)
public class KciCommand extends InternalCommand {
}
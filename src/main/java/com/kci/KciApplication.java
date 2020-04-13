package com.kci;

import com.kci.command.KciCommand;
import org.dizitart.no2.Nitrite;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@SpringBootApplication
public class KciApplication implements CommandLineRunner, ExitCodeGenerator {

    private IFactory factory;
    private KciCommand command;
    private int exitCode;

    KciApplication(IFactory factory, KciCommand command) {
        this.factory = factory;
        this.command = command;
    }

    @Override
    public void run(String... args) {
        exitCode = new CommandLine(command, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    public static void main(String[] args) {
        System.exit(org.springframework.boot.SpringApplication.exit(org.springframework.boot.SpringApplication.run(KciApplication.class, args)));
    }
}
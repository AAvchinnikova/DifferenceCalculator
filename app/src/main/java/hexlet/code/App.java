package hexlet.code;

import hexlet.code.commands.GenDiff;
import picocli.CommandLine;

public class App {

    public static void main(String... args) {
        new CommandLine(new GenDiff()).execute(args);
    }
}

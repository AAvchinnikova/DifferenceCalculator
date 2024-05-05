package hexlet.code;

import hexlet.code.commands.Differ;
import picocli.CommandLine;

public class App {

    public static void main(String... args) {
        new CommandLine(new Differ()).execute(args);
    }
}

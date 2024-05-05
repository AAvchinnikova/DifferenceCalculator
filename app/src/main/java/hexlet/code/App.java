package hexlet.code;

import picocli.CommandLine;

import java.nio.file.Path;
import java.util.concurrent.Callable;

public class App {

    public static void main(String... args) {
        new CommandLine(new Differ()).execute(args);
    }
}

@CommandLine.Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)
class Differ implements Callable{
    @CommandLine.Parameters(description = "path to first file", paramLabel = "filepath1")
    Path filepath1;

    @CommandLine.Parameters(description = "path to second file", paramLabel = "filepath2")
    Path filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    String format;

    @Override
    public Object call() throws Exception {
        System.out.println(filepath1);
        return null;
    }
}
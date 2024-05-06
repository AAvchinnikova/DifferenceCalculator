package hexlet.code.commands;

import hexlet.code.Differ;
import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)
public class GenDiff implements Callable {
    @CommandLine.Parameters(description = "path to first file", paramLabel = "filepath1")
    Path filepath1;

    @CommandLine.Parameters(description = "path to second file", paramLabel = "filepath2")
    Path filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    String format;

    @Override
    public Object call() throws Exception {
        Path absolutOfPath1 = filepath1.toAbsolutePath().normalize();
        Path absolutOfPath2 = filepath2.toAbsolutePath().normalize();
        if (!Files.exists(absolutOfPath1) || !Files.exists(absolutOfPath2)) {
            throw new Exception("File does not exist");
        }
        Differ.generate(absolutOfPath1, absolutOfPath2);
        return null;
    }
}
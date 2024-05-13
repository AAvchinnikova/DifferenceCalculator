package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)
public class App implements Callable<Integer> {
    private static final int SUCCES_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @CommandLine.Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;

    @CommandLine.Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"},
            description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Override
    public Integer call() {
        try {
            String formattedDif = Differ.generate(filepath1, filepath2, format);
            System.out.println(formattedDif);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }
        return SUCCES_EXIT_CODE;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}

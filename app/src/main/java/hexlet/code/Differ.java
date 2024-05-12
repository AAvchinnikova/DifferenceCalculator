package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        String defaultFormat = "stylish";
        return makeDiff(filepath1, filepath2, defaultFormat);
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        return makeDiff(filepath1, filepath2, format);
    }

    private static String makeDiff(String filepath1, String filepath2, String format) throws Exception {

        Path absolutePath1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path absolutePath2 = Paths.get(filepath2).toAbsolutePath().normalize();

        String fileType1 = filepath1.substring(filepath1.lastIndexOf(".") + 1);
        String fileType2 = filepath2.substring(filepath2.lastIndexOf(".") + 1);

        Map<String, Object> data1 = getData(absolutePath1, fileType1);
        Map<String, Object> data2 = getData(absolutePath2, fileType2);

        List<Map<String, Object>> resultOfDiff = DiffBuilder.build(data1, data2);

        return Formatter.format(resultOfDiff, format);
    }
}

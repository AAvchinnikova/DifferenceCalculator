package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Differ {

    public static String generate(Path filePath1, Path filePath2) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        var mapOfFile1 = mapper.readValue(new File(filePath1.toUri()), new TypeReference<TreeMap<String, String>>() {
        });
        var  mapOfFile2 = mapper.readValue(new File(filePath2.toUri()), new TypeReference<TreeMap<String, String>>() {
        });
        var resultDif = new LinkedHashMap<>();
        mapOfFile1.forEach((key1, value1) -> {
            if (!mapOfFile2.containsKey(key1)) {
                resultDif.put("- " + key1, value1);
            } else {
                mapOfFile2.forEach((key2, value2) -> {
                    if (key1.equals(key2) && value1.equals(value2)) {
                        resultDif.put("  " + key1, value1);
                    } else if (key1.equals(key2)) {
                        resultDif.put("- " + key1, value1);
                        resultDif.put("+ " + key1, value2);
                    }
                });
            }
        });
        mapOfFile2.forEach((key2, value2) -> {
            if (!mapOfFile1.containsKey(key2)) {
                resultDif.put("+ " + key2, value2);
            }
        });
        var resultDifString = resultDif.entrySet().stream()
                .map(key -> key.getKey() + ": " + key.getValue()).collect(Collectors.joining("\n"));
        System.out.println(resultDifString);
        return "{\n" + resultDifString + "\n}";
    }
}

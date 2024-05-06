package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Compare {

    public static void compareJson(Path filePath1, Path filePath2) throws Exception {
        Path absolutOfPath1 = filePath1.toAbsolutePath().normalize();
        Path absolutOfPath2 = filePath2.toAbsolutePath().normalize();
        if (!Files.exists(absolutOfPath1) || !Files.exists(absolutOfPath2)) {
            throw new Exception("File does not exist");
        }
        ObjectMapper mapper = new ObjectMapper();
        TreeMap<String, String> mapOfFile1 = mapper.readValue(new File(absolutOfPath1.toUri()), TreeMap.class);
        TreeMap<String, String>  mapOfFile2 = mapper.readValue(new File(absolutOfPath2.toUri()), TreeMap.class);
        var resultDif = new LinkedHashMap<>();
        mapOfFile1.forEach((key1, value1) -> {
            if (!mapOfFile2.containsKey(key1)) {
                var keyDelete = "- " + key1;
                resultDif.put(keyDelete, value1);
            } else {
                mapOfFile2.forEach((key2, value2) -> {
                    if (key1.equals(key2) && value1.equals(value2)) {
                        resultDif.put(key1, value1);
                    } else if (key1.equals(key2) && !value1.equals(value2)) {
                        var keyDelete = "- " + key1;
                        resultDif.put(keyDelete, value1);
                        var keyAdd = "+ " + key1;
                        resultDif.put(keyAdd, value2);
                    }
                });
            }
        });
        mapOfFile2.forEach((key2, value2) -> {
        if (!mapOfFile1.containsKey(key2)) {
                var keyAdd = "+ " + key2;
                resultDif.put(keyAdd, value2);
            }
        });
        System.out.println(resultDif);
    }
}

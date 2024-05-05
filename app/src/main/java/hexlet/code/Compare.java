package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Compare {

    public static void compareJson(Path filePath1, Path filePath2) throws Exception {
        Path absolutOfPath1 = filePath1.toAbsolutePath().normalize();
        Path absolutOfPath2 = filePath2.toAbsolutePath().normalize();
        if (!Files.exists(absolutOfPath1) || !Files.exists(absolutOfPath2)) {
            throw  new Exception("File does not exist");
        }
        File file1 = new File(absolutOfPath1.toUri());
        File file2 = new File(absolutOfPath2.toUri());
        ObjectMapper mapper = new ObjectMapper();
        Map mapOfFile1 = mapper.readValue(file1, Map.class);
        Map mapOfFile2 = mapper.readValue(file2, Map.class);
        System.out.println(mapOfFile1);
        System.out.println(mapOfFile2);
    }
}

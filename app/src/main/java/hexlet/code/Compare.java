package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;

public class Compare {

    public static void compareJson(Path filePath1, Path filePath2) throws Exception {
        Path absolutOfPath1 = filePath1.toAbsolutePath().normalize();
        Path absolutOfPath2 = filePath2.toAbsolutePath().normalize();
        if (!Files.exists(absolutOfPath1) || !Files.exists(absolutOfPath2)) {
            throw  new Exception("File does not exist");
        }
        //HashMap<String, String> mapOfFile1 =
    }
}

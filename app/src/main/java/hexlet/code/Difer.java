package hexlet.code;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Difer {

    public static void difer() throws Exception {

        Path writeFilePath1 = Paths.get("~/gitLesson/java-project-71/app/filepath1.json");
        try {
            Path createdFilePath = Files.createFile(writeFilePath1);
            System.out.println("Файл создан: " + createdFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String readFilePath = "~/gitLesson/java-project-71/app/filepath1.json";
        Path path = Paths.get(readFilePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String content = Files.readString(path);
        System.out.println(content);
    }
}

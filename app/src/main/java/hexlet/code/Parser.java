package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class Parser {

    public static Map<String, Object> getData(Path absolutePath, String dataType) throws Exception {
        if (dataType.equals("json")) {
            return new ObjectMapper().readValue(absolutePath.toUri().toURL(),
                    new TypeReference<TreeMap<String, Object>>() { });
        } else if (dataType.equals("yml") || dataType.equals("yaml")) {
            return new YAMLMapper().readValue(absolutePath.toUri().toURL(),
                    new TypeReference<TreeMap<String, Object>>() { });
        } else {
            throw new RuntimeException("unknown format");
        }
    }
}

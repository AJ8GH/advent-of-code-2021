package day14;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Main {
    private static final String EXAMPLE = "./src/main/resources/day14/example.txt";
    private static final String INPUT = "./src/main/resources/day14/input.txt";

    public static void main(String[] args) {
        // part 1
        PolymerBuilder polymerBuilder = deserialize(EXAMPLE);
        polymerBuilder.build(10);
        int solution = polymerBuilder.getMostMinusLeast();
        log.info("{}", solution);
        assert solution == 1588;

        polymerBuilder = deserialize(INPUT);
        polymerBuilder.build(10);
        solution = polymerBuilder.getMostMinusLeast();
        log.info("{}", solution);
        assert solution == 2435;

        // part 2

    }

    private static PolymerBuilder deserialize(String filePath) {
        Map<String, String> pairs = new HashMap<>();
        String template = "";
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            template = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] pair = line.split(" -> ");
                pairs.put(pair[0], pair[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PolymerBuilder(template, pairs);
    }
}

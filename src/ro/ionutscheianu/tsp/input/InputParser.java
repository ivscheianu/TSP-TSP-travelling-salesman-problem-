package ro.ionutscheianu.tsp.input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private InputParser() {

    }

    public static List<Integer> parseLine(String line) {
        String[] split = line.split(" ");
        List<Integer> integerList = new ArrayList<>();
        Stream.iterate(0, index -> ++index)
                .limit(split.length)
                .forEach(index -> integerList.add(Integer.parseInt(split[index])));
        return integerList;
    }
}
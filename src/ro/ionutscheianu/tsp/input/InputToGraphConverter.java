package ro.ionutscheianu.tsp.input;

import ro.ionutscheianu.tsp.NodeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputToGraphConverter {

    private Map<Integer, List<NodeInfo>> adjacencyList = new HashMap<>();

    public Map<Integer, List<NodeInfo>> getAdjacencyList() {
        List<String> lines = FileReader.readLinesFromTextFile("input.txt");
        lines.forEach(this::analyzeLine);
        return adjacencyList;
    }

    private void analyzeLine(String line) {
        String[] split = line.split(" ");
        addNode(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    private void addNode(Integer startingNode, Integer endingNode, Integer cost) {
        addToAdjacencyList(endingNode, startingNode, cost);
        addToAdjacencyList(startingNode, endingNode, cost);
    }

    private void addToAdjacencyList(Integer startingNode, Integer endingNode, Integer cost) {
        if (adjacencyList.get(endingNode) == null) {
            List<NodeInfo> list = new ArrayList<>();
            list.add(new NodeInfo(startingNode, cost));
            adjacencyList.put(endingNode, list);
        } else {
            if(!adjacencyList.get(endingNode).contains(new NodeInfo(startingNode, cost))) {
                adjacencyList.get(endingNode).add(new NodeInfo(startingNode, cost));
            }
        }
    }
}

package ro.ionutscheianu.tsp.input;

import ro.ionutscheianu.tsp.NodeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomGraphGenerator {
    private final int nodesNumber;
    private final int maxCost;

    public RandomGraphGenerator(int nodesNumber, int maxCost) {
        this.nodesNumber = nodesNumber;
        this.maxCost = maxCost;
    }

    public Map<Integer, List<NodeInfo>> getRandomGraph() {
        Map<Integer, List<NodeInfo>> adjacencyList = new HashMap<>();
        final Random random = new Random();
        for (int startingNode = 0; startingNode < nodesNumber; ++startingNode) {
            adjacencyList.put(startingNode, new ArrayList<>());
            for (int targetNode = 0; targetNode < nodesNumber; ++targetNode) {
                if (startingNode == targetNode && !adjacencyList.get(startingNode).contains(new NodeInfo(targetNode, 0))) {
                    continue;
                }
                adjacencyList.get(startingNode).add(new NodeInfo(targetNode, random.nextInt(maxCost)));
            }
        }
        return adjacencyList;
    }
}

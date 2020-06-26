package ro.ionutscheianu.tsp;

import java.util.List;
import java.util.Map;

public class Graph {

    private final Map<Integer, List<NodeInfo>> adjacencyList;

    public Graph(Map<Integer, List<NodeInfo>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    @Override
    public String toString() {
        return "Graph" +
                 "\nadjacency list: \n" +
                getAdjacencyListAsString();
    }

    public Map<Integer, List<NodeInfo>> getAdjacencyList() {
        return adjacencyList;
    }

    private String getAdjacencyListAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var entry : adjacencyList.entrySet()) {
            stringBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}

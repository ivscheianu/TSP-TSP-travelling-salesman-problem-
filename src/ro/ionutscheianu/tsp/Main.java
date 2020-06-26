package ro.ionutscheianu.tsp;

import ro.ionutscheianu.tsp.input.RandomGraphGenerator;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<NodeInfo>> adjacencyList;
//        adjacencyList = new InputToGraphConverter().getAdjacencyList();
        adjacencyList = new RandomGraphGenerator(10, 10).getRandomGraph();
        Graph graph = new Graph(adjacencyList);
        Driver driver = new Driver(graph);
        driver.start();
        
    }
}

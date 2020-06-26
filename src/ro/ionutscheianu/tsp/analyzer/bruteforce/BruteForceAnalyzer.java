package ro.ionutscheianu.tsp.analyzer.bruteforce;

import ro.ionutscheianu.tsp.Graph;
import ro.ionutscheianu.tsp.analyzer.RouteAnalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BruteForceAnalyzer extends RouteAnalyzer {

    public BruteForceAnalyzer(Graph graph) {
        super(graph);
    }

    @Override
    public void calculateRoute(Integer startingNode) {
        super.startingNode = startingNode;
        List<Integer> list = new ArrayList<>(graph.getAdjacencyList().keySet());
        list.remove(startingNode);
        heapPermutation(list, list.size());
        System.out.println("Brute force result: " + finalRoute + " : " + minCost);
    }

    private void checkBestRouteSoFar(List<Integer> possibleBestRoute) {
        int cost = getCost(possibleBestRoute);
        if (cost < minCost) {
            minCost = cost;
            finalRoute = possibleBestRoute;
        }
    }

    private void heapPermutation(List<Integer> permutations, int size) {
        if (size == 1) {
            List<Integer> completeRoute = getCompleteRoute(permutations);
            checkBestRouteSoFar(completeRoute);
        }
        for (int index = 0; index < size; ++index) {
            heapPermutation(permutations, size - 1);
            if (size % 2 == 1) {
                Collections.swap(permutations, 0, size - 1);
            } else {
                Collections.swap(permutations, index, size - 1);
            }
        }
    }
}

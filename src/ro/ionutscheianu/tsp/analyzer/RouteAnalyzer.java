package ro.ionutscheianu.tsp.analyzer;

import ro.ionutscheianu.tsp.Graph;
import ro.ionutscheianu.tsp.NodeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class RouteAnalyzer {

    protected final Graph graph;
    protected Integer startingNode;
    protected int minCost = Integer.MAX_VALUE;
    protected List<Integer> finalRoute = new ArrayList<>();

    public RouteAnalyzer(Graph graph) {
        this.graph = graph;
    }

    public abstract void calculateRoute(Integer startingNode);

    public int getMinCost() {
        return minCost;
    }

    public List<Integer> getFinalRoute() {
        return finalRoute;
    }

    protected int getCost(List<Integer> route) {
        int cost = 0;
        for (int index = 0; index < route.size() - 1; ++index) {
            int secondIndex = index + 1;
            Optional<NodeInfo> searchedNode = graph.getAdjacencyList()
                    .get(route.get(index))
                    .stream()
                    .filter(node -> node.getNodeNumber().equals(route.get(secondIndex)))
                    .findFirst();
            if (searchedNode.isPresent()) {
                cost += searchedNode.get().getCost();
            } else {
                return 99_999;
            }
        }
        return cost;
    }

    protected List<Integer> getCompleteRoute(List<Integer> permutations) {
        List<Integer> completeRoute = new ArrayList<>(permutations);
        completeRoute.add(0, startingNode);
        completeRoute.add(startingNode);
        return completeRoute;
    }
}

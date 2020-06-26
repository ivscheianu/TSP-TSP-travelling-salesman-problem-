package ro.ionutscheianu.tsp.analyzer.hillclimbing;

import ro.ionutscheianu.tsp.Graph;
import ro.ionutscheianu.tsp.analyzer.RouteAnalyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class HillClimbingAnalyzer extends RouteAnalyzer {

    private static final int MAX_SIMULATED_ANNEALING_ATTEMPTS = 100;
    private static final int HILL_CLIMBING_TRIES = 100;

    public HillClimbingAnalyzer(Graph graph) {
        super(graph);
    }

    @Override
    public void calculateRoute(Integer startingNode) {
        super.startingNode = startingNode;
        Stream.iterate(0, index->++index)
                .limit(HILL_CLIMBING_TRIES)
                .forEach(index->hillClimbing(startingNode));
        System.out.println("Hill climbing result: " + finalRoute + " : " + minCost);
    }

    private void hillClimbing(Integer startingNode) {
        List<Integer> currentRoute = new ArrayList<>(graph.getAdjacencyList().keySet());
        Collections.shuffle(currentRoute);
        addStartAndFinishNode(startingNode, currentRoute);
        List<Integer> anotherRoute;
        int annealingCounter = 0;
        while (annealingCounter < MAX_SIMULATED_ANNEALING_ATTEMPTS) {
            anotherRoute = getNeighborRoute(new ArrayList<>(currentRoute));
            if (getCost(anotherRoute) <= getCost(currentRoute)) {
                annealingCounter = 0;
                currentRoute = new ArrayList<>(anotherRoute);
            } else {
                ++annealingCounter;
            }
        }
        checkIsBetterRoute(currentRoute);
    }

    private void checkIsBetterRoute(List<Integer> currentRoute) {
        if(minCost > getCost(currentRoute)) {
            minCost = getCost(currentRoute);
            finalRoute = currentRoute;
        }
    }

    private void addStartAndFinishNode(Integer startingNode, List<Integer> currentRoute) {
        currentRoute.add(startingNode);
        Collections.swap(currentRoute, 0, currentRoute.indexOf(startingNode));
    }

    private List<Integer> getNeighborRoute(List<Integer> route) {
        int firstPosition = 0;
        int secondPosition = 0;
        while(firstPosition == secondPosition){
            firstPosition = ThreadLocalRandom.current().nextInt(1, route.size() - 1);
            secondPosition = ThreadLocalRandom.current().nextInt(1, route.size() - 1);
        }
        Collections.swap(route, firstPosition, secondPosition);
        return route;
    }
}

package ro.ionutscheianu.tsp.analyzer.hillclimbing;

import ro.ionutscheianu.tsp.Graph;
import ro.ionutscheianu.tsp.analyzer.RouteAnalyzer;

public class HillClimbingRunnable implements Runnable {

    private final Graph graph;

    public HillClimbingRunnable(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void run() {
        RouteAnalyzer hillClimbingAnalyzer = new HillClimbingAnalyzer(graph);
        hillClimbingAnalyzer.calculateRoute(0);
        System.out.println("Hill climbing completed");
    }
}

package ro.ionutscheianu.tsp.analyzer.bruteforce;

import ro.ionutscheianu.tsp.Graph;
import ro.ionutscheianu.tsp.analyzer.RouteAnalyzer;

public class BruteForceRunnable implements Runnable{

    private final Graph graph;

    public BruteForceRunnable(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void run() {
        RouteAnalyzer bruteForceAnalyzer = new BruteForceAnalyzer(graph);
        bruteForceAnalyzer.calculateRoute(0);
        System.out.println("Brute force completed \n");
    }
}

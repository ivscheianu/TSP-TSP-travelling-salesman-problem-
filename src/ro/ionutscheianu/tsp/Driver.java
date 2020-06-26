package ro.ionutscheianu.tsp;

import ro.ionutscheianu.tsp.analyzer.bruteforce.BruteForceRunnable;
import ro.ionutscheianu.tsp.analyzer.hillclimbing.HillClimbingRunnable;

public class Driver {

    private final Graph graph;

    public Driver(Graph graph) {
        this.graph = graph;
    }

    public void start() {
        startBruteForce();
        startHillClimbing();
    }

    private void startBruteForce() {
        System.out.println("Brute force started");
        BruteForceRunnable bruteForceRunnable = new BruteForceRunnable(graph);
        Thread bruteForceThread = new Thread(bruteForceRunnable);
        bruteForceThread.start();
    }

    private void startHillClimbing() {
        System.out.println("Hill climbing started");
        HillClimbingRunnable hillClimbingRunnable = new HillClimbingRunnable(graph);
        Thread hillClimbingThread = new Thread(hillClimbingRunnable);
        hillClimbingThread.start();
    }
}

package com.uneatlantico;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.MultiGraph;
import org.junit.Test;

public class AlgorithmTest {

  @Test
  public void dijkstra() throws IOException {
    Reader r = new Reader();
    ArrayList<Airport> airportes = r.readFileAirports();
    ArrayList<Route> routes = r.readFileRoutes(airportes);
    Graph graph = new MultiGraph("World");
    graph.addAttribute("ui.quality");
    App.addNodesToGraph(airportes,graph);
    App.addEdgesToGraph(routes,graph);
    
    Path path = App.dijkstra("1892", "1251", graph);
    assertEquals(path.toString(), "[1892, 1229, 1251]");
  }

  @Test
  public void allReachableNodes() throws IOException {
    Reader r = new Reader();
    ArrayList<Airport> airportes = r.readFileAirports();
    ArrayList<Route> routes = r.readFileRoutes(airportes);
    Graph graph = new MultiGraph("World");
    graph.addAttribute("ui.quality");
    App.addNodesToGraph(airportes,graph);
    App.addEdgesToGraph(routes,graph);
    
    ArrayList<Node> neighbors = App.allReachableNodes("5800", graph);
    assertEquals(neighbors.toString(), "[1701, 1682]");
  }
}

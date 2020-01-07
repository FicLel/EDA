package com.uneatlantico;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.MultiGraph;
import org.junit.Test;

public class DijkstraTest {

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
    
    System.out.println(path);
  }

}

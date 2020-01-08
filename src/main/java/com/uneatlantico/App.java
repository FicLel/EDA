package com.uneatlantico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.Viewer;

/**
 * Hello world!
 *
 */

// https://stackoverflow.com/questions/28458212/how-to-use-static-layout-in-graphstream
//Es para cambiar vieww y metodos

public class App {
  @SuppressWarnings("unused")
  public static void main(String[] args) throws IOException {
    Reader r = new Reader();
    ArrayList<Airport> airportes = r.readFileAirports();
    ArrayList<Route> routes = r.readFileRoutes(airportes);
    Graph graph = new MultiGraph("World");
    graph.setAttribute("ui.quality");
    addNodesToGraph(airportes, graph);
    addEdgesToGraph(routes, graph);
    graph.setAttribute("ui.stylesheet", style());
    graph.addAttribute("ui.screenshot",
        "url('https://www.mapsland.com/maps/world/large-satellite-map-of-the-world.jpg')");
    Viewer viewer = graph.display(false);
    viewer.disableAutoLayout();

//        }
//        catch(Exception e) {
//          System.out.println(e.getMessage());
//        }

    // System.out.println(total);

//        Reader routes = new Reader();
//        System.out.println(routes.readFileRoutes());

  }

  public static void addNodesToGraph(ArrayList<Airport> airports, Graph grafo) {
    for (Airport a : airports) {
      if (a != null) {
        try {
          grafo.addNode(a.getId());
          Node node = grafo.getNode(a.getId());
          node.addAttribute("data", a);
          node.setAttribute("layout.frozen");
          node.setAttribute("ui.frozen");
          node.setAttribute("x", a.getLongitude());
          node.setAttribute("y", a.getLatitude());
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e.getMessage());
        }
      }
    }
  }

  public static void addEdgesToGraph(ArrayList<Route> routes, Graph grafo) {
    for (Route r : routes) {
      grafo
          .addEdge(r.getAirlineIATA() + r.getSourceAirportIATA() + r.getDestinationAirportIATA(),
              r.getSourceAirport().getId(), r.getDestinationAirport().getId(), true)
          .setAttribute("weight", r.getWeight());
      ;
    }
  }

  public static Path dijkstra(String origin, String destination, Graph graph) {
    Dijkstra dijkstra = new Dijkstra(Dijkstra.Element.EDGE, null, "weight");
    dijkstra.init(graph);
    dijkstra.setSource(graph.getNode(origin));
    dijkstra.compute();

    return dijkstra.getPath(graph.getNode(destination));
  }

  public static ArrayList<Node> allReachableNodes(String origin, Graph graph) {
    Node originNode = graph.getNode(origin);
    Iterator<Node> originNeighbors = originNode.getNeighborNodeIterator();
    ArrayList<Node> originNeighborsNodes = new ArrayList();
    
    while (originNeighbors.hasNext()) {
      originNeighborsNodes.add(originNeighbors.next());
    }
    
    return originNeighborsNodes;
  }
  
  public static String style() {
    return "graph{" + " fill-mode: image-scaled; "
        + " fill-image: url('https://www.mapsland.com/maps/world/large-satellite-map-of-the-world.jpg');" + "}"

        + "node {" + "size: 3px;" + "fill-color: red;" + "text-mode: hidden;" + "z-index: 0;" + "}"

        + "edge {" + "size: 2px;" + "shape: cubic-curve;" + "fill-color: #cccccc;" + "arrow-size: 2px, 2px;" + "}";
  }

}

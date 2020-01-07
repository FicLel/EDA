package com.uneatlantico;

import java.io.IOException;
import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.Viewer;

/**
 * Hello world!
 *
 */

// https://stackoverflow.com/questions/28458212/how-to-use-static-layout-in-graphstream
//Es para cambiar vieww y metodos

public class App 
{
    @SuppressWarnings("unused")
    public static void main( String[] args ) throws IOException
    {
        Reader r = new Reader();
        ArrayList<Airport> airportes = r.readFileAirports();
        ArrayList<Route> routes = r.readFileRoutes(airportes);
        Graph graph = new MultiGraph("World");
        graph.addAttribute("ui.quality");
        addNodesToGraph(airportes,graph);
        addEdgesToGraph(routes,graph);
        Viewer viewer = graph.display(false);
        viewer.disableAutoLayout();
//        }
//        catch(Exception e) {
//          System.out.println(e.getMessage());
//        }
        
        //System.out.println(total);
        
//        Reader routes = new Reader();
//        System.out.println(routes.readFileRoutes());
        
    }
    public static void addNodesToGraph(ArrayList<Airport> airports, Graph grafo) {
      for(Airport a :  airports) {
        if(a != null) {
          try {
            grafo.addNode(a.getId());
            Node node = grafo.getNode(a.getId());
            node.addAttribute("data", a);
            node.addAttribute("layout.frozen");
            node.addAttribute("ui.frozen");
            node.setAttribute("x", a.getLongitude());
            node.setAttribute("y", a.getLatitude());
          }
          catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
          } 
        }
      }
    }
    public static void addEdgesToGraph(ArrayList<Route> routes, Graph grafo) {
      for(Route r : routes) {
        grafo.addEdge(r.getAirlineIATA()+r.getSourceAirportIATA()+r.getDestinationAirportIATA(), r.getSourceAirport().getId(), r.getDestinationAirport().getId(), true);
        
      }
    }

}

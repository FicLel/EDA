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
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Reader r = new Reader();
        Graph graph = new SingleGraph("World");
        addNodesToGraph(r.readFileAirports(),graph);
        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
        //System.out.println(total);
        
//        Reader routes = new Reader();
//        System.out.println(routes.readFileRoutes());
        
    }
    public static void addNodesToGraph(ArrayList<Airport> airports, Graph grafo) {
      for(Airport a :  airports) {
        grafo.addNode(a.getId());
        Node node = grafo.getNode(a.getId());
        node.addAttribute("data", a);
        node.setAttribute("x", a.getLongitude());
        node.setAttribute("y", a.getLatitude());
      }
    }
}

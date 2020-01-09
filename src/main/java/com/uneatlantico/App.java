package com.uneatlantico;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.swingViewer.DefaultView;
import org.graphstream.ui.swingViewer.LayerRenderer;
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
        graph.setAttribute("ui.quality");
        addNodesToGraph(airportes,graph);
        //addEdgesToGraph(routes,graph);
        graph.setAttribute("ui.stylesheet", style());
        graph.addAttribute("ui.screenshot", "url('https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Gall%E2%80%93Peters_projection_SW.jpg/1024px-Gall%E2%80%93Peters_projection_SW.jpg')");
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        Viewer viewer = graph.display(false);
        viewer.disableAutoLayout();
        DefaultView view = (DefaultView) viewer.getDefaultView(); 
        view.resizeFrame(1366, 768);
        view.setBackLayerRenderer(new LayerRenderer() {
          public void render(Graphics2D graphics, GraphicGraph graph, double px2Gu, int widthPx, int heightPx,
              double minXGu, double minYGu, double maxXGu, double maxYGu) {
            URL url;
            URLConnection conn;
            InputStream inputStream;
            BufferedImage img = null;

            try {
              url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Mercator_projection_SW.jpg/800px-Mercator_projection_SW.jpg");
              conn = url.openConnection();
              inputStream = conn.getInputStream();
              img = ImageIO.read(inputStream);
            } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            
            graphics.drawImage(img, 0, 0, 1366, 768, null);
          }
        });
//    	MainUI main = new MainUI();
//    	main.setVisible(true);


        
    }
    public static void addNodesToGraph(ArrayList<Airport> airports, Graph grafo) {
      for(Airport a :  airports) {
        if(a != null) {
          try {
            grafo.addNode(a.getId());
            Node node = grafo.getNode(a.getId());
            node.addAttribute("data", a);
            node.setAttribute("layout.frozen");
            node.setAttribute("ui.frozen");
         // get x   1366, 768
            double x = 6371 * Math.cos(a.getLatitude()) * Math.cos(a.getLongitude());
            double y = 6371 * Math.cos(a.getLatitude()) * Math.sin(a.getLongitude());
            node.setAttribute("x", x);
            node.setAttribute("y", y);
          }
          catch(Exception e) {
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
    return "node {" + "size: 3px;" + "fill-color: red;" + "text-mode: hidden;" + "z-index: 0;" + "}"

        + "edge {" + "size: 2px;" + "shape: cubic-curve;" + "fill-color: #cccccc;" + "arrow-size: 2px, 2px;" + "}";
  }

}

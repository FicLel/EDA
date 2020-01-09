/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uneatlantico;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.graphstream.algorithm.Dijkstra;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.swingViewer.DefaultView;
import org.graphstream.ui.swingViewer.LayerRenderer;
import org.graphstream.ui.swingViewer.Viewer;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.*;

/**
 *
 * @author pereirapaula
 */
public class Principal extends javax.swing.JFrame {

     public static ArrayList<Airport> airportes;
     public static ArrayList<Route> routes;
     public static Graph graph = new MultiGraph("World");
     /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("frmPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(368, 616));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(241, 241, 241));
        jPanel1.setPreferredSize(new java.awt.Dimension(368, 616));

        jPanel2.setBackground(new java.awt.Color(241, 241, 241));
        jPanel2.setName("jpnOptions"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 68, 69));
        jLabel1.setText("Origen");

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(50, 68, 69));
        jLabel2.setText("Destino");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(50, 68, 69));
        jButton1.setText("Buscar Rutas");
        jButton1.setName("buttonBuscar"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setEditable(true);
        jComboBox2.setFont(new java.awt.Font("Lucida Sans Typewriter", 2, 13)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(204, 204, 204));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox3.setEditable(true);
        jComboBox3.setFont(new java.awt.Font("Lucida Sans Typewriter", 2, 13)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(204, 204, 204));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Reader r = new Reader();
      try {
        airportes = r.readFileAirports();
        routes = r.readFileRoutes(airportes);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
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
      viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
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
      
      //Termina Desvergue
      
      
      jTextField1.getText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox2MouseClicked
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

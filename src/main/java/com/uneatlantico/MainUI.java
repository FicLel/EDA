package com.uneatlantico;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class MainUI extends JFrame{
    private final JPanel mainPanel;
    private final JPanel leftPanel;
    private final JPanel rightPanel;
    private final JComboBox originAirport;
    public MainUI() {
      mainPanel =  new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
      
      leftPanel =  new JPanel();
      leftPanel.setOpaque(true);
      leftPanel.setBackground(Color.decode("#f3f4f6"));
      leftPanel.setMaximumSize(new Dimension(500, 1000));
      
      rightPanel =  new JPanel();
      rightPanel.setOpaque(true);
      rightPanel.setBackground(Color.white);
      rightPanel.setMaximumSize(new Dimension(1100, 1000));
      
      mainPanel.add(leftPanel);
      mainPanel.add(rightPanel);
      
      originAirport =  new JComboBox();
      
      setPreferredSize(new Dimension(1600, 1000));
      getContentPane().setLayout(new GridLayout()); 
      getContentPane().add(mainPanel);  
      pack();
    }
}

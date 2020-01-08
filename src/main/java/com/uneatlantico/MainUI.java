package com.uneatlantico;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class MainUI extends JFrame{
    private final JPanel mainPanel;
    private final JPanel leftPanel;
    private final JPanel rightPanel;
    public MainUI() {
      mainPanel =  new JPanel();
      leftPanel =  new JPanel();
      rightPanel =  new JPanel();
      
      mainPanel.add(leftPanel);
      mainPanel.add(rightPanel);
      setPreferredSize(new Dimension(1000, 1000));
      getContentPane().setLayout(new GridLayout()); 
      getContentPane().add(mainPanel);  
    }
}

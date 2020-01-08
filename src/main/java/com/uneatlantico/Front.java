package com.uneatlantico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Front extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front frame = new Front();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Front() {
		setTitle("Trips");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1600,1000,1600,1000);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		panel.setBackground(Color.decode("#f3f4f6"));
		panel.setBounds(500, 900, 500, 900);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#f3f4f6"));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setBackground(Color.decode("#f3f4f6"));
		
		JLabel whereLabel = new JLabel("Where");
		whereLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		whereLabel.setBorder(new EmptyBorder(20, 70, 0, 100));
		whereLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		whereLabel.setMaximumSize(new Dimension(50, 100));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBorder(new EmptyBorder(-160, 0, 0, 0));
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		panel_3.add(whereLabel);
		panel_3.add(comboBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#f3f4f6"));
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel toLabel = new JLabel("To");
		panel_4.add(toLabel);
		toLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		toLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		toLabel.setBorder(new EmptyBorder(20, 50, 0, 100));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBorder(new EmptyBorder(-160, 0, 0, 0));
		panel_4.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.decode("#f3f4f6"));
		panel.add(panel_2);
		
		
		
	}

}

package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.JTextArea;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import se.mah.k3lara.skaneAPI.xmlparser.UpdateThread;

public class GUI extends JFrame {
	private JPanel contentPane;
	public JTextArea txtrLine;
	
	GUI g = this;
	Parser p = new Parser();
	
	Thread uT = new UpdateThread(p,this);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtrLine = new JTextArea();
		txtrLine.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		txtrLine.setForeground(new Color(218, 165, 32));
		txtrLine.setOpaque(false);
		txtrLine.setEditable(false);
		txtrLine.setBounds(54, 137, 421, 212);
		contentPane.add(txtrLine);
		
		
		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblLinje.setForeground(Color.LIGHT_GRAY);
		lblLinje.setBounds(44, 89, 70, 34);
		contentPane.add(lblLinje);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(Color.LIGHT_GRAY);
		lblDestination.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblDestination.setBounds(143, 90, 135, 34);
		contentPane.add(lblDestination);
		
		JLabel lblAvgr = new JLabel("Avgår");
		lblAvgr.setForeground(Color.LIGHT_GRAY);
		lblAvgr.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblAvgr.setBounds(412, 89, 80, 34);
		contentPane.add(lblAvgr);
		
		JLabel lblUbtshallen = new JLabel("Ubåtshallen");
		lblUbtshallen.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblUbtshallen.setForeground(Color.LIGHT_GRAY);
		lblUbtshallen.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbtshallen.setBounds(131, 26, 264, 52);
		contentPane.add(lblUbtshallen);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/img/skåneskylt.png")));
		lblNewLabel.setBounds(6, 0, 505, 413);
		contentPane.add(lblNewLabel);
		
		Thread uT = new UpdateThread(p,this);
		uT.start();
		
		
		}
	

	public void updateTimes() {
		// TODO Auto-generated method stub
		String searchURL = Constants.getURL("80000","81216",20); //Malm� C = 80000,  Lund C, 81216 Malm� Gatorg 80100, H�ssleholm C 93070
	
		Lines lines = Parser.getStationResults(new Station("80046"));
		txtrLine.setText("");
		for (Line l : lines.getLines()) {
			if(l.getStopPoint().contains("Västra")){
				if(l.getDepTimeDeviation() != ""){
			txtrLine.append(" " +l.getLine() + "      " + l.getStopPoint()+"     "
			+ " "+fixTime(l.getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" +fixTime(l.getDepTime().get(Calendar.MINUTE))+" +" + l.getDepTimeDeviation()+ "\n \n");
			} else{
			txtrLine.append(" " +l.getLine() + "      " + l.getStopPoint()+"     "
			+ " "+fixTime(l.getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" +fixTime(l.getDepTime().get(Calendar.MINUTE)) + "\n \n");
			}
		}
		}
	}
	public String fixTime(int time) {

		String zero = "";

		if (time < 10) {
			zero = "0";
		}

		String fixTimeString = zero + Integer.toString(time);

		zero = "";

		return fixTimeString;
	}
}

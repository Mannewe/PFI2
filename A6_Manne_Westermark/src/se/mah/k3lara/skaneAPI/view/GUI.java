package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.JourneysThread;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.model.StationsThread;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

	public ArrayList<Station> searchStations;
	public JPanel contentPane;
	public JTextField textField;
	public JTextField txtFran;
	public JTextField txtTill;
	public JTextArea txtrResult;
	public JTextArea txtrResultat;

	GUI g = this;
	Parser p = new Parser();
	
	Thread Tj = new JourneysThread(p,this);
	Thread Ts = new StationsThread(p,this);
	
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
		setBounds(100, 100, 664, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 323, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(93, 56, 134, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Resultat", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(0, 144, 323, 300);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 18, 311, 276);
		panel_2.add(scrollPane);
		
		txtrResult = new JTextArea();
		scrollPane.setViewportView(txtrResult);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(341, 6, 317, 444);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtFran = new JTextField();
		txtFran.setBounds(88, 56, 134, 28);
		panel_1.add(txtFran);
		txtFran.setColumns(10);
		
		txtTill = new JTextField();
		txtTill.setBounds(88, 114, 134, 28);
		panel_1.add(txtTill);
		txtTill.setColumns(10);
		
		JLabel lblFrn = new JLabel("Från");
		lblFrn.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrn.setBounds(129, 28, 61, 16);
		panel_1.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till");
		lblTill.setHorizontalAlignment(SwingConstants.CENTER);
		lblTill.setBounds(129, 96, 61, 16);
		panel_1.add(lblTill);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Resultat", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(0, 198, 317, 246);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 18, 305, 222);
		panel_3.add(scrollPane_1);
		
		txtrResultat = new JTextArea();
		scrollPane_1.setViewportView(txtrResultat);
		
		
		JButton btnSok = new JButton("Sök Resa");
		btnSok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread Tj = new JourneysThread(p,g);
				Tj.start();
			}
		});
		btnSok.setBounds(98, 168, 117, 29);
		panel_1.add(btnSok);
		
		JButton btnSearch = new JButton("Sök");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//hämtar alla stationer som innehåller "Malm" och stoppar in de i arraylisten searchStations
				Thread Ts = new StationsThread(p,g);
				Ts.start();
			}
		});
		btnSearch.setBounds(103, 106, 117, 29);
		panel.add(btnSearch);
		
		JLabel lblSkHllplats = new JLabel("Sök Hållplats");
		lblSkHllplats.setBounds(119, 28, 92, 16);
		panel.add(lblSkHllplats);
		
		
	}
}

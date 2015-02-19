import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtHours;
	private JTextField txtMinute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSetAlarm.setBounds(104, 337, 134, 52);
		contentPane.add(btnSetAlarm);
		
		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClearAlarm.setBounds(104, 401, 134, 52);
		contentPane.add(btnClearAlarm);
		
		txtHours = new JTextField();
		txtHours.setBounds(73, 274, 93, 28);
		contentPane.add(txtHours);
		txtHours.setColumns(10);
		
		txtMinute = new JTextField();
		txtMinute.setBounds(178, 274, 93, 28);
		contentPane.add(txtMinute);
		txtMinute.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(104, 252, 46, 16);
		contentPane.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(194, 252, 61, 16);
		contentPane.add(lblMinutes);
	}
}

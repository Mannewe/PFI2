import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class DigitalClockGUI extends JFrame {
	
	//h�r ska du ha en ClockLogic variabel
	
	private ClockLogic clockLogic;
	private JPanel contentPane;
	private JTextField txtHours;
	private JTextField txtMinute;
	private JTextField txtAlarm;
	private JTextField txtClock;
	private boolean alarm = false;


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
		setIconImage(Toolkit.getDefaultToolkit().getImage(DigitalClockGUI.class.getResource("/images/clocka.png")));
		setTitle("My Alarm Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		txtAlarm = new JTextField();
		txtAlarm.setEditable(false);
		txtAlarm.setBounds(73, 6, 182, 28);
		contentPane.add(txtAlarm);
		txtAlarm.setColumns(10);
		
		txtClock = new JTextField();
		txtClock.setEditable(false);
		txtClock.setHorizontalAlignment(SwingConstants.CENTER);
		txtClock.setFont(new Font("Helvetica", Font.PLAIN, 50));
		txtClock.setBounds(18, 46, 305, 177);
		contentPane.add(txtClock);
		txtClock.setColumns(10);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int hourCheck = Integer.parseInt(txtHours.getText());
				int minuteCheck = Integer.parseInt(txtMinute.getText());
				
				if(txtHours == null || txtMinute == null || hourCheck < 0 || hourCheck > 23 || minuteCheck < 0 || minuteCheck > 59){
					txtAlarm.setText("enter valid time");
					
					} else {
						txtAlarm.setText("Alarm set at : " + txtHours.getText() + ":" + txtMinute.getText());
						clockLogic.setAlarm(hourCheck,minuteCheck);
					}
				
				
				
				
				
				
				//if(txtHours.getText().length() < 2 || txtMinute.getText().length() < 2){
					//txtAlarm.setText("enter valid time");
				//} else {
					//setTimeOnLabel(time);
				//}
				//clockLogic.setAlarm(txtHours.getText(Integer.parseInt()) minute);
			}
		});
		btnSetAlarm.setBounds(104, 337, 134, 52);
		contentPane.add(btnSetAlarm);
		
		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAlarm.setText("");
				txtHours.setText("");
				txtMinute.setText("");
				clockLogic.clearAlarm();
			}
		});
		btnClearAlarm.setBounds(104, 401, 134, 52);
		contentPane.add(btnClearAlarm);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/images/clocka.png")));
		lblNewLabel.setBounds(6, 12, 28, 22);
		contentPane.add(lblNewLabel);
		
		clockLogic = new ClockLogic(this);
	
	}
	//h�r ska du ha metoderna "setTimeOnLabel(String time)" och "alarm(boolean activate)""
	public void setTimeOnLabel(String time){
		txtClock.setText(time);
		
	}
	
	
	public void alarm(boolean activate){
		if(activate == true){
			System.out.println("HEJHOPP");
			contentPane.setBackground(Color.MAGENTA);
			
		} else {
			contentPane.setBackground(Color.GRAY);
		}
	}
}




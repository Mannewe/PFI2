import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Human human;
	private Dog dog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGUI frame = new FrameGUI();
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
	public FrameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(36, 230, 508, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 18, 496, 65);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "ErrorMessage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(35, 327, 513, 73);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(6, 18, 501, 49);
		panel_1.add(textArea_1);
		
		JLabel lblHumansDogs = new JLabel("Humans & Dogs");
		lblHumansDogs.setBounds(238, 33, 114, 24);
		contentPane.add(lblHumansDogs);
		
		textField = new JTextField();
		textField.setBounds(30, 101, 193, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(30, 141, 193, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() < 3){
					textArea_1.setText("Ett namn måste ha minst 3 bokstäver");
				} else {
					human = new Human(textField.getText());
					textArea_1.setText("");
				}
			}
		});
		btnNewHuman.setBounds(235, 101, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnNewButton = new JButton("Buy Dog");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(human == null){
					textArea_1.setText("ERROR, Vad heter du?");
				} else{
					dog = new Dog(textField_1.getText());
					human.buyDog(dog);
				}
			}
		});
		btnNewButton.setBounds(238, 141, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Print Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//kolla null check på human
				textArea.setText(human.getInfo());
			}
		});
		btnNewButton_1.setBounds(238, 182, 117, 29);
		contentPane.add(btnNewButton_1);
		
	}
}

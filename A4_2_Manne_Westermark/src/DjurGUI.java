import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;


public class DjurGUI extends JFrame {

	private ArrayList <Animal> djur = new ArrayList<Animal>();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DjurGUI frame = new DjurGUI();
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
	public DjurGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea txtrText = new JTextArea();
		txtrText.setBounds(22, 21, 579, 339);
		contentPane.add(txtrText);

		djur.add(new Snake("Giftorm","snakus giftusus", true));
		djur.add(new Dog("Pudel","Doggus pudlus", 3, true));
		djur.add(new Cat("skogskatt","kattus skogus", 5, 9));
		djur.add(new Dog("lurvis","lurvsus smartus",4,false));
		djur.add(new Snake("snällorm","kobrus snellisusmus", false));
		djur.add(new Cat("klenkatt","kattus klenus", 2, 1));

		for(Animal i: djur){
			txtrText.append(i.getInfo() + "\n");

		}

	}
}

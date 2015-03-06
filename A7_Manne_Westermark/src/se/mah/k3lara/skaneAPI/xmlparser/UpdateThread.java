package se.mah.k3lara.skaneAPI.xmlparser;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.view.GUI;

public class UpdateThread extends Thread {
	private Parser parser;
	private GUI gui;

	public UpdateThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}

	public void run() {
		while (true) {
			gui.updateTimes();
			System.out.println("Updating");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

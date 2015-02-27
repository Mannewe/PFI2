package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.view.GUI;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class JourneysThread extends Thread{
private Parser parser;
private GUI gui;
	public JourneysThread(Parser p, GUI g){
		this.parser = p;
		this.gui = g;
	}
	
	public void run(){
		gui.txtrResultat.setText(null);
		gui.txtrResultat.setText("Searching.....\n");
		
		String searchURL = Constants.getURL(gui.txtFran.getText() + "",gui.txtTill.getText(),1);
		
		Journeys journeys = Parser.getJourneys(searchURL);
		
		for  (Journey journey : journeys.getJourneys()){
			gui.txtrResultat.setText(journey.getStartStation()+" - ");
			gui.txtrResultat.append(journey.getEndStation()+"");
			gui.txtrResultat.append(" : "+journey.getLineOnFirstJourney());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			
			gui.txtrResultat.append("\nDeparts " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. \nAnd it is "+journey.getDepTimeDeviation()+" min late");
			
		} 
	}
}

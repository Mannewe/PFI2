package se.mah.k3lara.skaneAPI.model;

import java.util.ArrayList;

import se.mah.k3lara.skaneAPI.view.GUI;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class StationsThread extends Thread{
private Parser parser;
private GUI gui;


	public StationsThread(Parser p, GUI g){
		this.parser = p;
		this.gui = g;
	}
	
	public void run(){
	
		gui.searchStations = new ArrayList<Station>();
		
		gui.txtrResult.setText("Searching... \n");
		gui.searchStations.addAll(Parser.getStationsFromURL(gui.textField.getText()));
		
		for (Station s: gui.searchStations){
			gui.txtrResult.append(s.getStationName() +" number:" +s.getStationNbr() + "\n");
		}
	}
}

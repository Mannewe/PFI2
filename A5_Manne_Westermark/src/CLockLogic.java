
public class CLockLogic implements ClockInterface{
	private DigitalClockGUI clockGUI;
	private int hours;
	private int minute;
	
	//döp den gärna inte till interface då det är GUIt som ska in här och sättas till instansen av ClockLogic
	public CLockLogic(DigitalClockGUI clockInterface) {

	
	}
	
	public void setAlarm(int hours, int minute){
		this.hours = hours;
		this.minute = minute;
	}
	
	public void clearAlarm(){
		//här ska du cleara det alarmet som är satt
		this.hours = hours;
		this.minute = minute;
	}
	
	//denna ska overrideas
	public void update(int hours, int minute, int second) {
		
		
	}


}

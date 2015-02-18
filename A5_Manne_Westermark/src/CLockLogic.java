
public class CLockLogic implements ClockInterface{
	private DigitalClockGUI clockGUI;
	private int hours;
	private int minute;
	
	public CLockLogic(DigitalClockGUI clockInterface) {
	
	}
	
	public void setAlarm(int hours, int minute){
		this.hours = hours;
		this.minute = minute;
	}
	
	public void clearAlarm(){
		this.hours = hours;
		this.minute = minute;
	}

	public void update(int hours, int minute, int second) {
		
		
	}


}

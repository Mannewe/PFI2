
public class CLockLogic implements ClockInterface{
	private DigitalClockGUI clockGUI;
	private int hours;
	private int minute;
	
	//d�p den g�rna inte till interface d� det �r GUIt som ska in h�r och s�ttas till instansen av ClockLogic
	public CLockLogic(DigitalClockGUI clockIn) {

	
	}
	
	public void setAlarm(int hours, int minute){
		this.hours = hours;
		this.minute = minute;
	}
	
	public void clearAlarm(){
		//h�r ska du cleara det alarmet som �r satt
		this.hours = hours;
		this.minute = minute;
	}
	
	//denna ska overrideas
	@Override
	public void update(int hours, int minute, int second) {
		
		
	}


}

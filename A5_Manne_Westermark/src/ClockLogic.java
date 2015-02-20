
public class ClockLogic implements ClockInterface{
	private DigitalClockGUI clockGUI;
	private int alarmHours;
	private int alarmMinute;
	private int hours;
	private int minute;
	
	
	public ClockLogic(DigitalClockGUI clockIn) {
		this.clockGUI = clockIn;
		
		Thread t = new ClockThread(this);
		t.start();
	
	}
	
	public void setAlarm(int hours, int minute){
		this.alarmHours = hours;
		this.alarmMinute = minute;
	}
	
	public void clearAlarm(){
		this.alarmHours = 100;
		
	}
	

	@Override
	public void update(int hours, int minute, int second) {
		String time = "";
		time = (String.format("%02d", hours) +":"+ String.format("%02d", minute) +":"+ String.format("%02d", second));
		
		clockGUI.setTimeOnLabel(time);
		
		if(alarmHours == hours && alarmMinute == minute){
			clockGUI.alarm(true);
			} else{
			clockGUI.alarm(false);
			}
		
		}


}

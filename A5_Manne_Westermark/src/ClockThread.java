import java.util.Calendar;


public class ClockThread extends Thread{

private ClockInterface clockInterface;



public ClockThread(ClockInterface clockInterface){
	this.clockInterface = clockInterface;
}



	@Override
	public void run(){
		while(true){
			Calendar calendar = Calendar.getInstance();
			int hours = calendar.get(calendar.HOUR_OF_DAY);
			int minute = calendar.get(calendar.MINUTE);
			int second = calendar.get(calendar.SECOND);
			
			clockInterface.update(hours, minute, second);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}

	}

}


public class ClockThread extends Thread{
private ClockInterface clockInterface;
private boolean running = true;

public ClockThread(ClockInterface clockInterface){
	this.clockInterface = clockInterface;
}

@Override
public void run(){
	while(running == true){
		//Thread.sleep(900);
		//clockInterface.update(hours, minute, second);
	}
	
}

}

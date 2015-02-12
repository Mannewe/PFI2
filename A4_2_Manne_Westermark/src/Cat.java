public class Cat extends Mammal{
	private int numberOfLives;

	public Cat(String friendlyName, String latinName, int gestationTime, int numberOfLives){
		super(friendlyName, latinName, gestationTime);
		this.numberOfLives = numberOfLives;
	}

	public int getNumberOfLives() {
		return numberOfLives;
	}

	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}

	@Override
	String getInfo() {
		String info = "";
		
		info = "katten " + super.getFriendlyName() + "/" + super.getLatinName() + " har en dräktighetstid på " + this.getGestationTime() + " månader och har " + this.getNumberOfLives()  + " liv.\n";
		
		return info;
	}
	
	
}

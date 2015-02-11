public class Dog extends Mammal {
	private boolean stupid;

	public Dog(String latinName, int gestationTime, boolean stupid) {
		super(latinName, gestationTime);
		this.stupid = stupid;
	}

	//På denna måste du även inkludera att du sätter en friendlyName
	public Dog(String friendlyName, String latinName, int gestationTime, boolean stupid) {
		super(latinName, gestationTime);
		this.stupid = stupid;
	}

	public boolean isStupid() {
		return this.stupid;
	}
}

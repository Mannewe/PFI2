public class Dog extends Mammal {
	private boolean stupid;


	public Dog(String friendlyName, String latinName, int gestationTime, boolean stupid) {
		super(friendlyName, latinName, gestationTime);
		this.stupid = stupid;
	}

	public boolean isStupid() {
		return this.stupid;
	}

	@Override
	String getInfo() {
		String info = "";
		if(stupid){
			info = "Hunden " + super.getFriendlyName() + "/" + this.getLatinName()+ " har en dräktighettid på " + this.getGestationTime()+ "månader och är puckad.\n";
		}else{
			info = "Hunden " +  super.getFriendlyName() + "/" + this.getLatinName()+ " har en dräktighettid på " + this.getGestationTime() + "månader och är inte puckad.\n";
		}
		return info;
	}
	
	
	
}

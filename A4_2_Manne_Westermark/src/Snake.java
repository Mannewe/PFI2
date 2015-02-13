
public class Snake extends Animal {
	private boolean poisonus;

	public Snake(String friendlyName, String latinName, boolean poisonous){
		super(friendlyName, latinName);
		this.poisonus = poisonous;
	}

	public boolean isPoisonus(){
		return this.poisonus;
	}

	@Override
	public String getInfo() {
		String info = "";

		if(isPoisonus()){
			info = "ormen " + this.getFriendlyName() + "/" + this.getLatinName() + " är giftig. \n";
		} else{
			info = "ormen " + this.getFriendlyName() + "/" + this.getLatinName() + " är ej giftig. \n";
		}
		return info;
	}

}

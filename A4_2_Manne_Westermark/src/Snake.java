
public class Snake extends Animal {
private boolean poisonus;

	public Snake(String latinName, boolean poisonous){
		super(latinName);
		this.poisonus = poisonous;
	}
	
	public boolean isPoisonus(){
		return this.poisonus;
	}
}

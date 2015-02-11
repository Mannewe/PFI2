
public abstract class Animal {
private String latinName;
private String friendlyName;

public Animal(String latinName){
 this.latinName = latinName;

 
}


//abstract getInfo(){
	//return??
//}


public String getFriendlyName() {
	return friendlyName;
}
public void setFriendlyName(String friendlyName) {
	this.friendlyName = friendlyName;
}

}

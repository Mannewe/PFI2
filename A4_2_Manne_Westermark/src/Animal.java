
public abstract class Animal {
private String latinName;
private String friendlyName;

public Animal(String latinName){
 this.latinName = latinName;

 
}


//abstract getInfo(){
	//return??
//}
//Yes det ska bara vara "public abstract String getInfo();" i denna klassen


public String getFriendlyName() {
	return friendlyName;
}
public void setFriendlyName(String friendlyName) {
	this.friendlyName = friendlyName;
}

}

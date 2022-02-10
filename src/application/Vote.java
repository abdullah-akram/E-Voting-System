package application;

public class Vote {
private String party;
private String candidate;
private int count;

public int addcount(){
	setCount(getCount()+1);
	return getCount(); 
}

public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getCandidate() {
	return candidate;
}
public void setCandidate(String candidate) {
	this.candidate = candidate;
}
public String getParty() {
	return party;
}
public void setParty(String party) {
	this.party = party;
}
}

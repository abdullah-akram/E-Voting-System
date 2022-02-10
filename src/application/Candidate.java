package application;

public class Candidate {

	private String name;
	private String party;
	Vote votecount = new Vote();
	
	Candidate(String name,String party){
		this.name = name;
		this.party = party;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}


	
}

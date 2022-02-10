package application;

import java.util.ArrayList;

public class Party {
	private String partyname;
	private String leadername;
	ArrayList<Candidate> candidates = new ArrayList<Candidate>();

	
	public Party(String partyname, String leadername) {
		this.leadername = leadername;
		this.partyname = partyname;
	}
	
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getLeadername() {
		return leadername;
	}
	public void setLeadername(String leadername) {
		this.leadername = leadername;
	}
	
	
	
	public int countvotes() {
		int cnt=0;
		for(int i=0;i<this.candidates.size();i++) {
			cnt +=candidates.get(i).votecount.getCount();
		}
		
		
		return cnt;
		
	}
}

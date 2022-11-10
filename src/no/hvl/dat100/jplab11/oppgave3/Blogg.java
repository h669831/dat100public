package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledige;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		this.nesteledige = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		this.nesteledige = 0;
	}

	public int getAntall() {
		return innleggtabell.length;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for(int i = 0; i < innleggtabell.length; i++) {
			if( innlegg.erLik(innleggtabell [i])){
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
			if (finnInnlegg(innlegg) == -1) {
				return false;
			}
			return true;
	}

	public boolean ledigPlass() {
			if (nesteledige < innleggtabell.length) {
				return true;
			}
			return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
			if (ledigPlass()) {
				this.innleggtabell[nesteledige] = innlegg;
				nesteledige ++;
				return true;
			}
			return false;
	}
	
	public String toString() {
		String output = "";
		output += innleggtabell.length +"\n";
		for(Innlegg innlegg : innleggtabell) {
			output += innlegg.toString();
		}
		return output;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}
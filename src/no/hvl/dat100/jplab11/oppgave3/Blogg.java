package no.hvl.dat100.jplab11.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;

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
		return this.nesteledige;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
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
			nesteledige++;
			return true;
		}
		return false;
	}

	public String toString() {
		String output = "";
		output += nesteledige + "\n";
		for (int t = 0; t < nesteledige; t++) {
			output += innleggtabell[t].toString();
		}
		return output;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		innleggtabell = Arrays.copyOf(innleggtabell, innleggtabell.length * 2);
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!finnes(innlegg)) {
			if (ledigPlass()) {
				innleggtabell[nesteledige] = innlegg;
				nesteledige++;
				return true;
			} else {
				utvid();
				innleggtabell[nesteledige] = innlegg;
				nesteledige++;
				return true;

			}

		}
		return false;

	}

	public boolean slett(Innlegg innlegg) {

		if (finnes(innlegg)) {
			int index = finnInnlegg(innlegg);
			nesteledige--;
			innleggtabell[index] = innleggtabell[nesteledige];
			innleggtabell[nesteledige] = null;
			return true;
		}
		return false;
	}

	public int[] search(String keyword) {

		// come backa later

	}
}
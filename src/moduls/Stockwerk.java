package moduls;

import java.util.ArrayList;
import java.util.List;

public class Stockwerk {

	private int geschoss;
	private List<Zimmer> zimmerListe = new ArrayList<Zimmer>();

	public int getGeschoss() {
		return this.geschoss;
	}

	public void setGeschoss(int geschoss) {
		this.geschoss = geschoss;
	}

	public List<Zimmer> getZimmerListe() {
		return this.zimmerListe;
	}

	public void setZimmerListe(Zimmer zimmer) {
		this.zimmerListe.add(zimmer);
	}

	public void setZimmerListe(List<Zimmer> zimmerListe) {
		this.zimmerListe = zimmerListe;
	}

	@Override
	public String toString() {
		return String.format("Stockwerk [geschoss=%s, zimmerListe=%s]", this.geschoss, this.zimmerListe);
	}

}

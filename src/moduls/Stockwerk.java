package moduls;

import java.util.ArrayList;
import java.util.List;

public class Stockwerk extends Kunde {

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

	@Override
	public String toString() {
		return "Stockwerk [geschoss=" + geschoss + ", zimmerListe=" + zimmerListe + "]";
	}

}

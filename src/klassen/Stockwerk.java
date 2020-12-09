package klassen;

import java.util.ArrayList;
import java.util.List;

public class Stockwerk {

	private String geschoss;
	private List<Zimmer> zimmerListe = new ArrayList<>();

	public String getGeschoss() {
		return this.geschoss;
	}

	public List<Zimmer> getZimmerListe() {
		return this.zimmerListe;
	}

	public void setGeschoss(String geschoss) {
		this.geschoss = geschoss;
	}

	public void setZimmerListe(List<Zimmer> zimmerListe) {
		this.zimmerListe = zimmerListe;
	}

	public void setZimmerListe(Zimmer zimmer) {
		this.zimmerListe.add(zimmer);
	}

	@Override
	public String toString() {
		return String.format("Stockwerk [geschoss=%s, zimmerListe=%s]", this.geschoss, this.zimmerListe);
	}

}

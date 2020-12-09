package klassen;

import java.util.ArrayList;
import java.util.List;

public class Zimmer {
	private int zNummer;
	private ZimmerStatus status;
	private ZimmerKategorie kategorie;
	private boolean bezahlt;
	private List<Kunde> gebuchteKunden = new ArrayList<>();
	private List<Kunde> aktuelleKunden = new ArrayList<>();

	public List<Kunde> getAktuelleKunden() {
		return this.aktuelleKunden;
	}

	public List<Kunde> getGebuchteKunden() {
		return this.gebuchteKunden;
	}

	public ZimmerKategorie getKategorie() {
		return this.kategorie;
	}

	public ZimmerStatus getStatus() {
		return this.status;
	}

	public int getzNummer() {
		return this.zNummer;
	}

	public boolean isBezahlt() {
		return bezahlt;
	}

	public void setAktuelleKunden(List<Kunde> aktuelleKunden) {
		this.aktuelleKunden = aktuelleKunden;
	}

	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

	public void setGebuchteKunden(List<Kunde> gebuchteKunden) {
		this.gebuchteKunden = gebuchteKunden;
	}

	public void setKategorie(ZimmerKategorie kategorie) {
		this.kategorie = kategorie;
	}

	public void setStatus(ZimmerStatus status) {
		this.status = status;
	}

	public void setzNummer(int zNummer) {
		this.zNummer = zNummer;
	}

	@Override
	public String toString() {
		return String.format(
				"Zimmer [zNummer=%s, status=%s, kategorie=%s, bezahlt=%s, gebuchteKunden=%s, aktuelleKunden=%s]",
				zNummer, status, kategorie, bezahlt, gebuchteKunden, aktuelleKunden);
	}

}

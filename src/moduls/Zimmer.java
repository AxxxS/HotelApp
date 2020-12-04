package moduls;

import java.util.ArrayList;
import java.util.List;

public class Zimmer extends Stockwerk {
	private int zNummer;
	private int geschoss;
	private Status status;
	private ZimmerTyp typ;
	private List<Kunde> gebuchteKunden = new ArrayList<Kunde>();
	private List<Kunde> aktuelleKunden = new ArrayList<Kunde>();
	private boolean bezahlt;

	public int getzNummer() {
		return zNummer;
	}

	public void setzNummer(int zNummer) {
		this.zNummer = zNummer;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ZimmerTyp getTyp() {
		return typ;
	}

	public void setTyp(ZimmerTyp typ) {
		this.typ = typ;
	}

	public List<Kunde> getGebuchteKunden() {
		return gebuchteKunden;
	}

	public List<Kunde> getAktuelleKunden() {
		return aktuelleKunden;
	}

	public List<Kunde> setAktuelleKunden(List<Kunde> list) {
		return aktuelleKunden = list;
	}

	public boolean isBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

	public int getGeschoss() {
		return geschoss;
	}

	public void setGeschoss(int geschoss) {
		this.geschoss = geschoss;
	}

	@Override
	public String toString() {
		return String.format(
				"Zimmer [zNummer=%s, geschoss=%s, status=%s, typ=%s, gebuchteKunden=%s, aktuelleKunden=%s, bezahlt=%s]",
				zNummer, geschoss, status, typ, gebuchteKunden, aktuelleKunden, bezahlt);
	}

}

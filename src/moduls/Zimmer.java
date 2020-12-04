package moduls;

import java.util.ArrayList;
import java.util.List;

public class Zimmer {
	private int zNummer;
	private int zgeschoss;
	private Status status;
	private ZimmerTyp typ;
	private List<Kunde> gebuchteKunden = new ArrayList<Kunde>();
	private List<Kunde> aktuelleKunden = new ArrayList<Kunde>();
	private boolean bezahlt;

	public int getzNummer() {
		return this.zNummer;
	}

	public void setzNummer(int zNummer) {
		this.zNummer = zNummer;
	}

	public int getZgeschoss() {
		return this.zgeschoss;
	}

	public void setZgeschoss(int zgeschoss) {
		this.zgeschoss = zgeschoss;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ZimmerTyp getTyp() {
		return this.typ;
	}

	public void setTyp(ZimmerTyp typ) {
		this.typ = typ;
	}

	public List<Kunde> getGebuchteKunden() {
		return this.gebuchteKunden;
	}

	public void setGebuchteKunden(List<Kunde> gebuchteKunden) {
		this.gebuchteKunden = gebuchteKunden;
	}

	public List<Kunde> getAktuelleKunden() {
		return this.aktuelleKunden;
	}

	public void setAktuelleKunden(List<Kunde> aktuelleKunden) {
		this.aktuelleKunden = aktuelleKunden;
	}

	public boolean isBezahlt() {
		return this.bezahlt;
	}

	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

	@Override
	public String toString() {
		return String.format("Nr.%s, %s.OG, Typ:%s, Kunden: %s Bezahlt?: %s", this.zNummer, this.zgeschoss, this.typ, this.aktuelleKunden, this.bezahlt);
	}

}

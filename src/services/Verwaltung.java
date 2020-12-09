package services;

import klassen.Kunde;
import klassen.Stockwerk;
import klassen.Zimmer;
import klassen.ZimmerKategorie;
import klassen.ZimmerStatus;

public class Verwaltung extends StockwerkService {
	private static double einahmen;
	private final String pass = "gutesPasswort123";

	public void belegen(int zNummer) {

		Zimmer zimmer = this.nachZimmerSuchen(zNummer);
		if (zimmer.getStatus() == ZimmerStatus.GEBUCHT) {

			zimmer.setStatus(ZimmerStatus.BELEGT);
			for (Kunde kunde : zimmer.getAktuelleKunden()) {
				kunde.setKundenStatus(ZimmerStatus.BELEGT);
			}
			zimmer.setAktuelleKunden(zimmer.getGebuchteKunden());

			System.out.println("ZimmerNr." + zNummer + " wurde belegt!");
		}
	}

	public void buchen(String name, String nachName, int zNummer) {

		Zimmer zimmer = this.nachZimmerSuchen(zNummer);
		Kunde kunde = this.suche(name, nachName);

		if (kunde.getKreis().isPraesSuiteErlaubt() == false && zimmer.getKategorie() == ZimmerKategorie.PS) {

			System.err.println("Präsidentensuits sind für Standart member nicht verfügbar!! ZimmerNr." + zNummer
					+ " wurde nicht gebucht.");
			return;

		} else if (zimmer.getGebuchteKunden().size() == zimmer.getKategorie().getBett()) {

			System.err.println("ZimmerNr." + zNummer + " ist voll! ZimmerNr." + zNummer + " wurde nicht gebucht.");
			return;

		} else if (zimmer.getStatus() == ZimmerStatus.BELEGT) {

			System.err.println(
					"ZimmerNr." + zNummer + "ist bereits belegt! ZimmerNr." + zNummer + " wurde nicht gebucht.");
			return;

		} else if (zimmer.getStatus() == ZimmerStatus.GEBUCHT) {

			System.err.println(
					"ZimmerNr." + zNummer + "ist bereits gebucht! ZimmerNr." + zNummer + " wurde nicht gebucht.");
			return;
		}
		{
			kunde.setKundenStatus(ZimmerStatus.GEBUCHT);
			kunde.setRechnung(zimmer.getKategorie().getPreis() * kunde.getKreis().getRabatt());
			kunde.setKundenZimmer(zimmer);

			zimmer.setStatus(ZimmerStatus.GEBUCHT);
			zimmer.getGebuchteKunden().add(kunde);
			System.out.println("ZimmerNr." + zNummer + " wurde für " + kunde.getName() + " gebucht");
		}

	}

	public void feuerAlarm(String passWort) {
		int gesamtKundenAnzahl = 0;
		if (passWort != this.pass) {
			System.out.println();
			System.err.println("Falsches Passwort! Zugriff verweigert!!!");
			System.out.println(
					"Ihr müsst leider alle verbrennen weil ich das Passwort vergessen habe (ツ), echt sinnvolle Funktion!! Genial!");
			return;
		} else {
			System.out.println("!!!!");
			System.out.println("FEUERALARM!");
			System.out.println("!!!!");
			for (Stockwerk stockwerk : this.getStockwerke().values()) {
				gesamtKundenAnzahl = gesamtKundenAnzahl + this.readKundenInStockwerk(stockwerk.getGeschoss()).size();
				System.out.println("Kundenanzahl im " + stockwerk.getGeschoss() + ".Geschoss: "
						+ this.readKundenInStockwerk(stockwerk.getGeschoss()).size() + ".");

				System.out
						.println("Belegte Zimmer: " + this.readByStatus(stockwerk.getGeschoss(), ZimmerStatus.BELEGT));
				System.out.println();
			}
			System.out.println(gesamtKundenAnzahl + " Kunden im Hotel.");
		}

	}

	public void freiSetzen(int zNummer) {

		Zimmer zimmer = this.nachZimmerSuchen(zNummer);

		if (zimmer.getStatus() == ZimmerStatus.FREI) {
			System.out.println("ZimmerNr." + zNummer + " bereits freigestellt.");
			return;
		}
		if (zimmer.getStatus().isBezahlt() == true) {
			System.out.println("ZimmerNr." + zNummer + " wurde bezahlt.");
		}
		System.out.println("ZimmerNr." + zNummer + " ist noch nicht bezahlt.");

		zimmer.setStatus(ZimmerStatus.FREI);
		zimmer.getAktuelleKunden().clear();
		zimmer.getGebuchteKunden().clear();

		System.out.println("ZimmerNr." + zNummer + " ist jetzt Frei!");
	}

	public void proStockwerkAlleZimmerErstellen(String geschoss, int ez, int dz, int pd, int su, int ps) {
		stockwerkLesen(geschoss).getZimmerListe().addAll(this.erstelleZimmer(ez, ZimmerKategorie.EZ, geschoss));
		stockwerkLesen(geschoss).getZimmerListe().addAll(this.erstelleZimmer(dz, ZimmerKategorie.DZ, geschoss));
		stockwerkLesen(geschoss).getZimmerListe().addAll(this.erstelleZimmer(pd, ZimmerKategorie.PD, geschoss));
		stockwerkLesen(geschoss).getZimmerListe().addAll(this.erstelleZimmer(su, ZimmerKategorie.SU, geschoss));
		stockwerkLesen(geschoss).getZimmerListe().addAll(this.erstelleZimmer(ps, ZimmerKategorie.PS, geschoss));

	}

	public void tagesEinahmen() {

		for (Stockwerk stockwerk : this.getStockwerke().values()) {
			for (Zimmer zimmer : stockwerk.getZimmerListe()) {
				if (zimmer.getStatus() == ZimmerStatus.BELEGT) {
					for (Kunde kunde : zimmer.getAktuelleKunden()) {
						einahmen = einahmen + kunde.getRechnung();
					}
				}
			}
		}
		System.out.println("Zu erwartende Tageseinahmen: " + einahmen + "€.");
	}
}

package impls;

import moduls.Kunde;
import moduls.Status;
import moduls.Stockwerk;
import moduls.Zimmer;
import moduls.ZimmerTyp;
import services.VerwaltungService;

public class VerwaltungsServiceImpl extends StockwerkServsImpl implements VerwaltungService {
	private final String pass = "gutesPasswort123";
	private static double einahmen;

	@Override
	public void feueralarm(String passWort) {
		if (passWort != pass) {
			System.out.println("Falsches Passwort! Zugriff verweigert.");
			return;
		} else {
			for (Stockwerk stockwerk : getStockwerke().values()) {

				System.out.println("Für folgendes Stockwerk: " + stockwerk.getGeschoss() + " Kundenanzahl "
						+ readKundenInZimmer(stockwerk.getGeschoss()).size() + " Belegte Zimmer: "
						+ readByStatus(stockwerk.getGeschoss(), Status.BELEGT));
			}

		}

	}

	@Override
	public void tageseinahmen() {

		for (Stockwerk stockwerk : getStockwerke().values()) {

			for (Zimmer zimmer : stockwerk.getZimmerListe()) {

				if (zimmer.getStatus() == Status.BELEGT) {
					for (Kunde kunde : zimmer.getAktuelleKunden())
						einahmen = einahmen + (zimmer.getTyp().getPreis() * kunde.getKreis().getRabatt());

				}
			}
		}
		System.out.println("TagesEinahmen: " + einahmen);
	}

	@Override
	public void freiSetzen(int zNummer) {

		if (getAlleZimmer().get(zNummer).getStatus() == Status.FREI) {
			System.out.println("ZimmerNr." + zNummer + " bereits freigestellt");
			return;
		}
		if (getAlleZimmer().get(zNummer).isBezahlt() == true) {
			System.out.println("ZimmerNr." + zNummer + " wurde bezahlt");
		}
		System.out.println("ZimmerNr. " + zNummer + " ist noch nicht bezahlt");

		getAlleZimmer().get(zNummer).setStatus(Status.FREI);

		System.out.println("ZimmerNr. " + zNummer + " ist jetzt Frei!");
	}

	@Override
	public void belegen(int zNummer) {
		if (readZ(zNummer).getStatus() == Status.GEBUCHT) {
			readZ(zNummer).setStatus(Status.BELEGT);
			readZ(zNummer).setAktuelleKunden(readZ(zNummer).getGebuchteKunden());
			System.out.println("Zimmer " + zNummer + " wurde von " + readZ(zNummer).getGebuchteKunden() + "belegt!");
		}
	}

	@Override
	public void buchen(Kunde kunde, Zimmer zimmer) {

		if (kunde.getKreis().isPraesSuiteErlaubt() == false && zimmer.getTyp() == ZimmerTyp.PS) {
			System.err.println("Präsidentensuits sind für Standart member nicht verfügbar!!");
			return;
		} else {
			kunde.setKundenStatus(Status.GEBUCHT);
			zimmer.setStatus(Status.GEBUCHT);
			zimmer.getGebuchteKunden().add(kunde);

			System.out.println("Zimmer " + zimmer.getzNummer() + " wurde für " + kunde.getName() + " gebucht");

		}

	}
}

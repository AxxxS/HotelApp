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
	public void feuerAlarm(String passWort) {
		if (passWort != pass) {
			System.out.println("Falsches Passwort! Zugriff verweigert.");
			return;
		} else {
			System.out.println("FEUERALARM!");
			for (Stockwerk stockwerk : getStockwerke().values()) {

				System.out.println(stockwerk.getGeschoss() + ".Geschoss, Kunden: "
						+ readKundenInZimmer(stockwerk.getGeschoss()).size() + ", Belegte Zimmer: "
						+ readByStatus(stockwerk.getGeschoss(), Status.BELEGT));
			}

		}

	}

	@Override
	public void tagesEinahmen() {

		for (Stockwerk stockwerk : getStockwerke().values()) {

			for (Zimmer zimmer : stockwerk.getZimmerListe()) {

				if (zimmer.getStatus() == Status.BELEGT) {
					for (Kunde kunde : zimmer.getAktuelleKunden())
						einahmen = einahmen + kunde.getRechnung();

				}
			}
		}
		System.out.println("Tageseinahmen: " + einahmen + "€.");
	}

	@Override
	public void freiSetzen(int zNummer) {

		if (getAlleZimmer().get(zNummer).getStatus() == Status.FREI) {
			System.out.println("ZimmerNr." + zNummer + " bereits freigestellt.");
			return;
		}
		if (getAlleZimmer().get(zNummer).isBezahlt() == true) {
			System.out.println("ZimmerNr." + zNummer + " wurde bezahlt.");
		}
		System.out.println("ZimmerNr." + zNummer + " ist noch nicht bezahlt.");

		getAlleZimmer().get(zNummer).setStatus(Status.FREI);

		System.out.println("ZimmerNr." + zNummer + " ist jetzt Frei!");
	}

	@Override
	public void belegen(int zNummer) {
		if (readZ(zNummer).getStatus() == Status.GEBUCHT) {
			readZ(zNummer).setStatus(Status.BELEGT);
			readZ(zNummer).setAktuelleKunden(readZ(zNummer).getGebuchteKunden());
			System.out.println("ZimmerNr." + zNummer + " wurde belegt!");
		}
	}

	@Override
	public void buchen(Kunde kunde, Zimmer zimmer) {

		if (kunde.getKreis().isPraesSuiteErlaubt() == false && zimmer.getTyp() == ZimmerTyp.PS) {
			System.err.println("Präsidentensuits sind für Standart member nicht verfügbar!! ZimmerNr."
					+ zimmer.getzNummer() + " wurde nicht gebucht.");
			return;
		} else if (zimmer.getGebuchteKunden().size() == zimmer.getTyp().getBett()) {
			System.err.println("ZimmerNr." + zimmer.getzNummer() + " ist voll! ZimmerNr." + zimmer.getzNummer()
					+ " wurde nicht gebucht.");
			return;
		} else if (zimmer.getStatus() == Status.BELEGT) {
			System.err.println("ZimmerNr." + zimmer.getzNummer() + "ist bereits belegt! ZimmerNr." + zimmer.getzNummer()
					+ " wurde nicht gebucht.");
			return;
		} else if (zimmer.getStatus() == Status.GEBUCHT) {
			System.err.println("ZimmerNr." + zimmer.getzNummer() + "ist bereits gebucht! ZimmerNr."
					+ zimmer.getzNummer() + " wurde nicht gebucht.");
			return;
		}
		{
			kunde.setKundenStatus(Status.GEBUCHT);
			kunde.setRechnung(zimmer.getTyp().getPreis() * kunde.getKreis().getRabatt());
			zimmer.setStatus(Status.GEBUCHT);
			zimmer.getGebuchteKunden().add(kunde);
			System.out.println("ZimmerNr." + zimmer.getzNummer() + " wurde für " + kunde.getName() + " gebucht");

		}

	}
}

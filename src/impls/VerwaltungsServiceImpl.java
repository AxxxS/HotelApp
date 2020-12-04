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
		if (passWort != this.pass) {
			System.out.println("Falsches Passwort! Zugriff verweigert.");
			return;
		} else {
			System.out.println("FEUERALARM!");
			for (Stockwerk stockwerk : this.getStockwerke().values()) {

				System.out.println(stockwerk.getGeschoss() + ".Geschoss, Kunden: " + this.readKundenInStockwerk(stockwerk.getGeschoss()) + ", Belegte Zimmer: "
				        + this.readByStatus(stockwerk.getGeschoss(), Status.BELEGT));
			}

		}

	}

	@Override
	public void tagesEinahmen() {

		for (Stockwerk stockwerk : this.getStockwerke().values()) {

			for (Zimmer zimmer : stockwerk.getZimmerListe()) {

				if (zimmer.getStatus() == Status.BELEGT) {
					for (Kunde kunde : zimmer.getAktuelleKunden()) {
						einahmen = einahmen + kunde.getRechnung();
					}
				}
			}
		}
		System.out.println("Tageseinahmen: " + einahmen + "€.");
	}

	@Override
	public void freiSetzen(int zNummer) {

		Zimmer zimmer = this.readZ(zNummer);

		if (zimmer.getStatus() == Status.FREI) {
			System.out.println("ZimmerNr." + zNummer + " bereits freigestellt.");
			return;
		}
		if (zimmer.isBezahlt() == true) {
			System.out.println("ZimmerNr." + zNummer + " wurde bezahlt.");
		}
		System.out.println("ZimmerNr." + zNummer + " ist noch nicht bezahlt.");

		zimmer.setStatus(Status.FREI);
		zimmer.getAktuelleKunden().clear();
		zimmer.getGebuchteKunden().clear();

		System.out.println("ZimmerNr." + zNummer + " ist jetzt Frei!");
	}

	@Override
	public void belegen(int zNummer) {

		Zimmer zimmer = this.readZ(zNummer);

		if (zimmer.getStatus() == Status.GEBUCHT) {

			zimmer.setStatus(Status.BELEGT);
			zimmer.setAktuelleKunden(zimmer.getGebuchteKunden());

			System.out.println("ZimmerNr." + zNummer + " wurde belegt!");
		}
	}

	@Override
	public void buchen(String name, String nachName, int zNummer) {

		Zimmer zimmer = this.readZ(zNummer);
		Kunde kunde = this.readByFullName(name, nachName);

		if (kunde.getKreis().isPraesSuiteErlaubt() == false && zimmer.getTyp() == ZimmerTyp.PS) {

			System.err.println("Präsidentensuits sind für Standart member nicht verfügbar!! ZimmerNr." + zNummer + " wurde nicht gebucht.");

			return;
		} else if (zimmer.getGebuchteKunden().size() == zimmer.getTyp().getBett()) {

			System.err.println("ZimmerNr." + zNummer + " ist voll! ZimmerNr." + zNummer + " wurde nicht gebucht.");

			return;
		} else if (zimmer.getStatus() == Status.BELEGT) {

			System.err.println("ZimmerNr." + zNummer + "ist bereits belegt! ZimmerNr." + zNummer + " wurde nicht gebucht.");

			return;
		} else if (zimmer.getStatus() == Status.GEBUCHT) {

			System.err.println("ZimmerNr." + zNummer + "ist bereits gebucht! ZimmerNr." + zNummer + " wurde nicht gebucht.");

			return;
		}
		{
			kunde.setKundenStatus(Status.GEBUCHT);
			kunde.setRechnung(zimmer.getTyp().getPreis() * kunde.getKreis().getRabatt());
			kunde.setKundenZimmer(zimmer);

			zimmer.setStatus(Status.GEBUCHT);
			zimmer.getGebuchteKunden().add(kunde);
			System.out.println("ZimmerNr." + zNummer + " wurde für " + kunde.getName() + " gebucht");

		}

	}
}

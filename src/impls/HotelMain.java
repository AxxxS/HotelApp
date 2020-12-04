package impls;

import moduls.Kreis;
import services.KundenService;
import services.StockwerkService;
import services.VerwaltungService;
import services.ZimmerService;

public class HotelMain {

	public static void main(String[] args) {

		VerwaltungService vService = new VerwaltungsServiceImpl();
		StockwerkService sService = new StockwerkServsImpl();
		ZimmerService zService = new ZimmerServiceImpl();
		KundenService kService = new KundenServiceImpl();
		// Service Klassen iniziert.

		sService.create(7);
		// Stockwerke erstellt und geschoss nummern zugewiesen (1-7).

		sService.addZimmer(1, 10, 0, 0, 0, 0);
		sService.addZimmer(2, 10, 8, 0, 0, 0);
		sService.addZimmer(3, 0, 10, 4, 0, 0);
		sService.addZimmer(4, 0, 0, 6, 2, 0);
		sService.addZimmer(5, 0, 0, 0, 3, 0);
		sService.addZimmer(6, 0, 0, 0, 0, 3);
		sService.addZimmer(7, 0, 0, 0, 0, 2);
		// pro Geschoss (erste zahl) werden Zimmer erstellt. Die weiteren zahlen stehen
		// für die Anzahl der Zimmer, von links nach rechts Einzelzimmer bis
		// Präsidentensuits.

		kService.create("Max", "Mustermann", Kreis.STANDART);
		kService.create("Amir", "Sodah", Kreis.PLATIN);
		// Kunden erstellt, benannt und Kreis zugwiesen.

		vService.buchen("Amir", "Sodah", 56);
		vService.buchen("Max", "Mustermann", 55);
		vService.buchen("Max", "Mustermann", 1);
		// ZimmerNr. 56 und 55 werden gebucht. Wenn nicht-Platin Kunden eine PS buchen
		// wollen, das Zimmer bereits gebucht/belegt ist wird die Methode beendet und
		// gibt eine Meldung heraus.

		vService.belegen(56);
		vService.belegen(1);
		// Gebuchte Zimmer werden mit den Kunden belegt, Kunden bekommen eine Rechnung
		// und Zimmer wird auf "zu bezahlen" gesetzt

		vService.freiSetzen(1);
		// Belegtes oder gebuchtes Zimmer wird frei gesetzt. Wird angezeigt, ob das
		// Zimmer bezahlt wurde oder nicht.

		vService.tagesEinahmen();
		// Für jedes belegte Zimmer werden die zu bezahlenden Rechnungen
		// zusammengerechnet. Kunden mit dem Kreis Platin wird der Zimmerpreis um 5%
		// reduziert.

		vService.feuerAlarm("gutesPasswort123");
		// Für jedes Stockwerk werden die belegten Zimmer aufgezählt und die Gesamtzahl
		// der Kunden angezeigt. Benötigt ein Passwort, bei falscher Eingabe wird die
		// Methode mit einer Fehlermeldung beendet.

		vService.feuerAlarm("lol");
		// Beispiel falsches Passwort.

	}
}
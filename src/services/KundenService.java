package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import klassen.Kunde;
import klassen.KundenKreis;
import klassen.Zimmer;
import klassen.ZimmerStatus;

public class KundenService {

	private static int id;
	private static HashMap<Integer, Kunde> kunden = new HashMap<>();

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		KundenService.id = id;
	}

	public Kunde erstelleKunde(String name, String nachname, KundenKreis kreis) {
		System.out.println(kreis + " Kunde " + name + " " + nachname + " wurde erstellt.");
		return this.erstelleKundeUndBuche(name, nachname, kreis, null, null);
	}

	public Kunde erstelleKundeUndBuche(String name, String nachname, KundenKreis kreis, Zimmer kundenZimmer,
			ZimmerStatus kundenStatus) {
		Kunde kunde = new Kunde();
		kunde.setName(name);
		kunde.setNachname(nachname);
		kunde.setId(++id);
		kunde.setKundenZimmer(kundenZimmer);
		kunde.setKundenKreis(kreis);
		kunden.put(id, kunde);
		return kunde;

	}

	public HashMap<Integer, Kunde> getKunden() {
		return kunden;
	}

	public void loescheKundenZimmer(Kunde kunde) {
		kunde.setKundenZimmer(null);

	}

	public Kunde suche(String name, String nachName) {
		for (Kunde kunde : kunden.values()) {
			if (kunde.getName() == name && kunde.getNachname() == nachName) {
				return kunde;
			}
		}
		return null;
	}

	public List<Kunde> sucheKundenNachKreis(KundenKreis kreis) {
		List<Kunde> ergebnis = new ArrayList<>();
		for (Kunde kunde : kunden.values()) {
			if (kunde.getKreis() == kreis) {
				ergebnis.add(kunde);
			}
		}
		return ergebnis;
	}

}
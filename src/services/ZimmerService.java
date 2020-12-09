package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import klassen.Zimmer;
import klassen.ZimmerKategorie;
import klassen.ZimmerStatus;

public class ZimmerService extends KundenService {
	private static HashMap<Integer, Zimmer> alleZimmer = new HashMap<>();
	private static int zNummer;

	public List<Zimmer> erstelleZimmer(int anzahl, ZimmerKategorie kategorie, String geschoss) {
		List<Zimmer> ergebnisListe = new ArrayList<>();
		for (Integer i = 0; i < anzahl; i++) {

			Zimmer zimmer = this.erstelleZimmer(kategorie);
			zimmer.setzNummer(++zNummer);
			alleZimmer.put(zimmer.getzNummer(), zimmer);
			ergebnisListe.add(zimmer);
		}
		return ergebnisListe;
	}

	public Zimmer erstelleZimmer(ZimmerKategorie kategorie) {
		Zimmer zimmer = new Zimmer();
		zimmer.setKategorie(kategorie);
		return zimmer;
	}

	public HashMap<Integer, Zimmer> getAlleZimmer() {
		return alleZimmer;
	}

	public Zimmer nachZimmerSuchen(int zNummer) {
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.getzNummer() == zNummer) {
				return zimmer;
			}
		}
		return null;
	}

	public List<Zimmer> sucheNachBezahlteZimmer() {
		List<Zimmer> ergebnisListe = new ArrayList<>();
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.isBezahlt() == true) {
				ergebnisListe.add(zimmer);
			}
		}
		return ergebnisListe;
	}

	public List<Zimmer> sucheNachZimmerKategorie(ZimmerKategorie kategorie) {
		List<Zimmer> ergebnisListe = new ArrayList<>();
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.getKategorie() == kategorie) {
				ergebnisListe.add(zimmer);
			}
		}
		return ergebnisListe;
	}

	public List<Zimmer> sucheNachZimmerStatus(ZimmerStatus status) {
		List<Zimmer> ergebnisListe = new ArrayList<>();
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.getStatus() == status) {
				ergebnisListe.add(zimmer);
			}
		}
		return ergebnisListe;
	}

}

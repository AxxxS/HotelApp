package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import klassen.Kunde;
import klassen.Stockwerk;
import klassen.Zimmer;
import klassen.ZimmerKategorie;
import klassen.ZimmerStatus;

public class StockwerkService extends ZimmerService {

	private static HashMap<String, Stockwerk> stockwerke = new HashMap<>();
	String[] geschosse = { "EG", "1.OG", "2.OG", "3.OG", "4.OG", "5.OG", "6.OG" };

	public void erstelleStockwerke(int stockwerkAnzahl) {
		for (int i = 0; i < stockwerkAnzahl; i++) {
			Stockwerk stockwerk = new Stockwerk();

			for (int j = 0; j < geschosse.length; j++) {

				stockwerk.setGeschoss(geschosse[j]);
				stockwerke.put(stockwerk.getGeschoss(), stockwerk);
			}

		}

	}

	public HashMap<String, Stockwerk> getStockwerke() {
		return stockwerke;
	}

	public List<Zimmer> readByStatus(String status, ZimmerStatus belegt) {
		List<Zimmer> ergebnisliste = new ArrayList<>();
		for (Zimmer zimmer : stockwerke.get(status).getZimmerListe()) {
			if (zimmer.getStatus() == belegt) {
				ergebnisliste.add(zimmer);
			}
		}
		return ergebnisliste;
	}

	public List<Zimmer> readByZimmerTyp(String geschoss, ZimmerKategorie kategorie) {
		List<Zimmer> ergebnisliste = new ArrayList<>();
		for (Zimmer zimmer : stockwerke.get(geschoss).getZimmerListe()) {
			if (zimmer.getKategorie() == kategorie) {
				ergebnisliste.add(zimmer);
			}
		}
		return ergebnisliste;

	}

	public List<Kunde> readKundenInStockwerk(String geschoss) {
		List<Kunde> ergebnisListe = new ArrayList<>();
		for (Stockwerk stockwerk : stockwerke.values()) {
			if (stockwerk.getGeschoss() == geschoss) {
				for (Zimmer zimmer : stockwerk.getZimmerListe()) {
					ergebnisListe.addAll(zimmer.getAktuelleKunden());
				}

			}
		}
		return ergebnisListe;

	}

	public Stockwerk stockwerkLesen(String geschoss) {
		for (Stockwerk stockwerk : stockwerke.values()) {
			if (stockwerk.getGeschoss() == geschoss) {

			}
			return stockwerk;
		}
		return null;

	}

}

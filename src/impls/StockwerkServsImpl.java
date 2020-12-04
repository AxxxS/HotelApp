package impls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import moduls.Kunde;
import moduls.Status;
import moduls.Stockwerk;
import moduls.Zimmer;
import moduls.ZimmerTyp;
import services.StockwerkService;

public class StockwerkServsImpl extends ZimmerServiceImpl implements StockwerkService {

	public static int geschoss;

	private static HashMap<Integer, Stockwerk> stockwerke = new HashMap<Integer, Stockwerk>();

	@Override
	public void create(int stockwerkAnzahl) {
		for (int i = 0; i < stockwerkAnzahl; i++) {
			create();
		}

	}

	@Override
	public HashMap<Integer, Stockwerk> getStockwerke() {
		return stockwerke;
	}

	@Override
	public List<Zimmer> readByZimmerTyp(int geschoss, ZimmerTyp typ) {
		List<Zimmer> ergebnisliste = new ArrayList<Zimmer>();
		for (Zimmer zimmer : stockwerke.get(geschoss).getZimmerListe()) {
			if (zimmer.getTyp() == typ) {
				ergebnisliste.add(zimmer);
			}
		}
		return ergebnisliste;

	}

	@Override
	public List<Kunde> readKundenInZimmer(int geschoss) {
		List<Kunde> ergebnisliste = new ArrayList<Kunde>();
		for (Zimmer zimmer : stockwerke.get(geschoss).getZimmerListe()) {
			ergebnisliste.addAll(zimmer.getAktuelleKunden());
		}
		return ergebnisliste;
	}

	@Override
	public List<Zimmer> readByStatus(int geschoss, Status status) {
		List<Zimmer> ergebnisliste = new ArrayList<Zimmer>();
		for (Zimmer zimmer : stockwerke.get(geschoss).getZimmerListe()) {
			if (zimmer.getStatus() == status) {
				ergebnisliste.add(zimmer);
			}
		}
		return ergebnisliste;
	}

	@Override
	public void addZimmer(int geschoss, int ez, int dz, int pd, int su, int ps) {

		read(geschoss).getZimmerListe().addAll(createZimmer(ez, ZimmerTyp.EZ, geschoss));
		read(geschoss).getZimmerListe().addAll(createZimmer(dz, ZimmerTyp.DZ, geschoss));
		read(geschoss).getZimmerListe().addAll(createZimmer(pd, ZimmerTyp.PD, geschoss));
		read(geschoss).getZimmerListe().addAll(createZimmer(su, ZimmerTyp.SU, geschoss));
		read(geschoss).getZimmerListe().addAll(createZimmer(ps, ZimmerTyp.PS, geschoss));

	}

	public static void setStockwerke(HashMap<Integer, Stockwerk> stockwerke) {
		StockwerkServsImpl.stockwerke = stockwerke;
	}

	@Override
	public Stockwerk read(int geschoss) {
		for (Stockwerk stockwerk : stockwerke.values()) {
			if (stockwerk.getGeschoss() == geschoss) {
				return stockwerk;
			}
		}
		return null;

	}

	@Override
	public Stockwerk create() {
		Stockwerk stockwerk = new Stockwerk();
		stockwerk.setGeschoss(++geschoss);
		stockwerke.put(stockwerk.getGeschoss(), stockwerk);
		return stockwerk;
	}

}

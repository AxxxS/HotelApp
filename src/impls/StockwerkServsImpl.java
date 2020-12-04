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
			this.create();
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
	public List<Kunde> readKundenInStockwerk(int geschoss) {
		List<Kunde> ergebnisListe = new ArrayList<Kunde>();
		for (Stockwerk stockwerk : stockwerke.values()) {
			if (stockwerk.getGeschoss() == geschoss) {
				for (Zimmer zimmer : stockwerk.getZimmerListe()) {
					ergebnisListe.addAll(zimmer.getAktuelleKunden());
				}

			}
		}
		return ergebnisListe;

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

		this.read(geschoss).getZimmerListe().addAll(this.createZimmer(ez, ZimmerTyp.EZ, geschoss));
		this.read(geschoss).getZimmerListe().addAll(this.createZimmer(dz, ZimmerTyp.DZ, geschoss));
		this.read(geschoss).getZimmerListe().addAll(this.createZimmer(pd, ZimmerTyp.PD, geschoss));
		this.read(geschoss).getZimmerListe().addAll(this.createZimmer(su, ZimmerTyp.SU, geschoss));
		this.read(geschoss).getZimmerListe().addAll(this.createZimmer(ps, ZimmerTyp.PS, geschoss));

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

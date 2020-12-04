package impls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import moduls.Status;
import moduls.Zimmer;
import moduls.ZimmerTyp;
import services.ZimmerService;

public class ZimmerServiceImpl extends KundenServiceImpl implements ZimmerService {
	private static HashMap<Integer, Zimmer> alleZimmer = new HashMap<>();
	private static int zNummer;

	@Override
	public Zimmer createZimmer(ZimmerTyp typ) {
		Zimmer zimmer = new Zimmer();
		zimmer.setzNummer(++zNummer);
		zimmer.setTyp(typ);
		alleZimmer.put(zimmer.getzNummer(), zimmer);
		return zimmer;
	}

	@Override
	public List<Zimmer> createZimmer(int anzahl, ZimmerTyp typ, int geschoss) {
		List<Zimmer> ergebnisListe = new ArrayList<Zimmer>();
		for (int i = 0; i < anzahl; i++) {
			Zimmer zimmer = createZimmer(typ);
			zimmer.setGeschoss(geschoss);
			ergebnisListe.add(zimmer);
		}
		return ergebnisListe;
	}

	public HashMap<Integer, Zimmer> getAlleZimmer() {
		return alleZimmer;
	}

	@Override
	public List<Zimmer> readByStatus(Status status) {
		List<Zimmer> ergebnisListe = new ArrayList<Zimmer>();
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.getStatus() == status) {
				ergebnisListe.add(zimmer);
			}
		}
		return ergebnisListe;
	}

	@Override
	public List<Zimmer> readBezahlteZimmer() {
		List<Zimmer> ergebnisListe = new ArrayList<Zimmer>();
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.isBezahlt() == true) {
				ergebnisListe.add(zimmer);
			}
		}
		return ergebnisListe;
	}

	@Override
	public List<Zimmer> readByZimmerTyp(ZimmerTyp typ) {
		List<Zimmer> ergebnisListe = new ArrayList<Zimmer>();
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.getTyp() == typ) {
				ergebnisListe.add(zimmer);
			}
		}
		return ergebnisListe;
	}

	@Override
	public Zimmer readZ(int zNummer) {
		for (Zimmer zimmer : alleZimmer.values()) {

			if (zimmer.getzNummer() == zNummer) {
				return zimmer;
			}
		}
		return null;
	}

}

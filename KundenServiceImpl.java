package impls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import moduls.Kreis;
import moduls.Kunde;
import moduls.Status;
import moduls.Zimmer;
import services.KundenService;

public class KundenServiceImpl implements KundenService {

	private static int id;
	private static HashMap<Integer, Kunde> kunden = new HashMap<Integer, Kunde>();

	@Override
	public Kunde create(String name, String nachname, Kreis kreis) {
		return this.createUndBuchen(name, nachname, kreis, null, null);
	}

	@Override
	public boolean updateKreis(int id, Kreis newKreis) {
		if (kunden.get(id).getKreis() == newKreis) {
			return false;
		}
		kunden.get(id).setKreis(newKreis);
		return true;
	}

	@Override
	public List<Kunde> readKundenInZimmer(int zNummer) {
		List<Kunde> ergebnis = new ArrayList<Kunde>();
		for (Kunde kunde : kunden.values()) {
			if (kunde.getKundenZimmer().getzNummer() == zNummer) {
				ergebnis.add(kunde);
			}
		}
		return ergebnis;
	}

	@Override
	public Kunde createUndBuchen(String name, String nachname, Kreis kreis, Zimmer kundenZimmer, Status kundenStatus) {
		Kunde kunde = new Kunde();
		kunde.setName(name);
		kunde.setNachname(nachname);
		kunde.setId(++id);
		kunde.setKundenZimmer(kundenZimmer);
		kunde.setKreis(kreis);
		kunden.put(id, kunde);
		return kunde;

	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		KundenServiceImpl.id = id;
	}

	public HashMap<Integer, Kunde> getKunden() {
		return kunden;
	}

	@Override
	public List<Kunde> readByName(String name) {
		List<Kunde> ergebnisListe = new ArrayList<Kunde>();
		for (Kunde kunde : kunden.values()) {
			if (kunde.getName() == name) {
				ergebnisListe.add(kunde);
			}

		}
		return ergebnisListe;

	}

	@Override
	public Kunde readByFullName(String name, String nachName) {
		for (Kunde kunde : kunden.values()) {
			if (kunde.getName() == name && kunde.getNachname() == nachName) {
				return kunde;
			}
		}
		return null;
	}

	@Override
	public List<Kunde> readByNachName(String nachName) {
		List<Kunde> ergebnis = new ArrayList<Kunde>();
		for (Kunde kunde : kunden.values()) {
			if (kunde.getNachname() == nachName) {
				ergebnis.add(kunde);
			}
		}
		return ergebnis;
	}

	@Override
	public List<Kunde> readByKreis(Kreis kreis) {
		List<Kunde> ergebnis = new ArrayList<Kunde>();
		for (Kunde kunde : kunden.values()) {
			if (kunde.getKreis() == kreis) {
				ergebnis.add(kunde);
			}
		}
		return ergebnis;
	}

}
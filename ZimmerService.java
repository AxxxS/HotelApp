package services;

import java.util.HashMap;
import java.util.List;

import moduls.Kunde;
import moduls.Status;
import moduls.Zimmer;
import moduls.ZimmerTyp;

public interface ZimmerService {
	Zimmer createZimmer(ZimmerTyp typ);

	Zimmer readZ(int zNummer);

	List<Kunde> readKundenInZimmer(int zNummer);

	List<Zimmer> readByStatus(Status status);

	List<Zimmer> readByZimmerTyp(ZimmerTyp typ);

	List<Zimmer> readBezahlteZimmer();

	HashMap<Integer, Zimmer> getAlleZimmer();

	List<Zimmer> createZimmer(int anzahl, ZimmerTyp typ, int geschoss);

}

package services;

import java.util.HashMap;
import java.util.List;

import moduls.Kreis;
import moduls.Kunde;
import moduls.Status;
import moduls.Zimmer;

public interface KundenService {

	Kunde create(String name, String nachname, Kreis kreis);

	Kunde readByFullName(String name, String nachName);

	List<Kunde> readByNachName(String Nachname);

	List<Kunde> readByKreis(Kreis kreis);

	Kunde createUndBuchen(String name, String nachname, Kreis kreis, Zimmer kundenZimmer, Status kundenStatus);

	boolean updateKreis(int id, Kreis newKreis);

	void deleteKundenZimmer(Kunde kunde);

	List<Kunde> readByName(String name);

	HashMap<Integer, Kunde> getKunden();
}

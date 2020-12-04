package services;

import moduls.Kunde;
import moduls.Zimmer;

public interface VerwaltungService {

	void freiSetzen(int zNummer);

	void buchen(Kunde kunde, Zimmer zimmer);

	void feueralarm(String passwort);

	void tageseinahmen();

	void belegen(int zNummer);

}

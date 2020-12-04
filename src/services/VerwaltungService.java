package services;

import moduls.Kunde;
import moduls.Zimmer;

public interface VerwaltungService {

	void freiSetzen(int zNummer);

	void buchen(Kunde kunde, Zimmer zimmer);

	void feuerAlarm(String passwort);

	void tagesEinahmen();

	void belegen(int zNummer);

}

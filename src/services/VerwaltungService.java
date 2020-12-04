package services;

public interface VerwaltungService {

	void freiSetzen(int zNummer);

	void buchen(String name, String nachNahme, int zNummer);

	void feuerAlarm(String passwort);

	void tagesEinahmen();

	void belegen(int zNummer);

}

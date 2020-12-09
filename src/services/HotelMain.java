package services;

import klassen.KundenKreis;

public class HotelMain extends Verwaltung {
	public static void main(String[] args) {
		HotelMain hotel = new HotelMain();
		hotel.erstelleStockwerke(7);
		hotel.proStockwerkAlleZimmerErstellen("EG", 10, 0, 0, 0, 0);
		hotel.erstelleKunde("Amir", "Sodah", KundenKreis.PLATIN);
		hotel.buchen("Amir", "Sodah", 1);
		hotel.belegen(1);
		hotel.feuerAlarm("123");
		hotel.feuerAlarm("gutesPasswort123");
		hotel.tagesEinahmen();

	}
}
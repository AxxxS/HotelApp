package impls;

import moduls.Kreis;
import moduls.ZimmerTyp;
import services.KundenService;
import services.StockwerkService;
import services.VerwaltungService;
import services.ZimmerService;

public class HotelMain {

	public static void main(String[] args) {
		VerwaltungService vService = new VerwaltungsServiceImpl();
		StockwerkService sService = new StockwerkServsImpl();
		ZimmerService zService = new ZimmerServiceImpl();
		KundenService kService = new KundenServiceImpl();
		sService.create(7);
		sService.addZimmer(1, 10, 0, 0, 0, 0);
		sService.addZimmer(2, 10, 8, 0, 0, 0);
		sService.addZimmer(3, 0, 10, 4, 0, 0);
		sService.addZimmer(4, 0, 0, 6, 2, 0);
		sService.addZimmer(5, 0, 0, 0, 3, 0);
		sService.addZimmer(6, 0, 0, 0, 0, 3);
		sService.addZimmer(7, 0, 0, 0, 0, 2);

		kService.create("Max", "Mustermann", Kreis.STANDART);
		kService.create("Amir", "Sodah", Kreis.PLATIN);

		vService.buchen(kService.readByFullName("Amir", "Sodah"), zService.readZ(12));

		vService.buchen(kService.readByFullName("Max", "Mustermann"), zService.readZ(55));
		vService.belegen(12);

		vService.belegen(2);
		vService.freiSetzen(2);
		System.out.println(zService.readByZimmerTyp(ZimmerTyp.PS));
		vService.tageseinahmen();
		vService.feueralarm("lol");
		vService.feueralarm("gutesPasswort123");

	}
}
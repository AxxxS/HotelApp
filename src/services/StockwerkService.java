package services;

import java.util.HashMap;
import java.util.List;

import moduls.Status;
import moduls.Stockwerk;
import moduls.Zimmer;
import moduls.ZimmerTyp;

public interface StockwerkService {
	Stockwerk create();

	HashMap<Integer, Stockwerk> getStockwerke();

	void create(int stockwerkAnzahl);

	void addZimmer(int geschoss, int ez, int dz, int pd, int su, int ps);

	List<Zimmer> readByStatus(int geschoss, Status status);

	List<Zimmer> readByZimmerTyp(int geschoss, ZimmerTyp typ);

	Stockwerk read(int geschoss);

}

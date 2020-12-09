package klassen;

public enum ZimmerKategorie {
	EZ(50, 1), DZ(100, 2), PD(150, 2), SU(250, 4), PS(500, 4);

	private final double preis;
	private final double bett;

	ZimmerKategorie(double i, int j) {
		this.preis = i;
		this.bett = j;
	}

	public double getBett() {
		return bett;
	}

	public double getPreis() {
		return preis;
	}

}

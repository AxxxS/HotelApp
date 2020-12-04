package moduls;

public enum ZimmerTyp {
	EZ(50, 1), DZ(100, 2), PD(150, 2), SU(250, 4), PS(500, 4);

	private final double preis;
	private final double bett;

	ZimmerTyp(double i, int j) {
		this.preis = i;
		this.bett = j;
	}

	public double getPreis() {
		return preis;
	}

	public double getBett() {
		return bett;
	}

}

package klassen;

public enum KundenKreis {
	STANDART(false, 1), GOLD(true, 1), PLATIN(true, 0.95);

	private final boolean praesSuiteErlaubt;
	private final double rabatt;

	KundenKreis(boolean b, double d) {
		this.praesSuiteErlaubt = b;
		this.rabatt = d;

	}

	public double getRabatt() {
		return rabatt;
	}

	public boolean isPraesSuiteErlaubt() {
		return praesSuiteErlaubt;
	}

}

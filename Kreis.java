package moduls;

public enum Kreis {
	STANDART(false, 1), GOLD(true, 1), PLATIN(true, 0.95);

	private final boolean praesSuiteErlaubt;
	private final double rabatt;

	Kreis(boolean b, double d) {
		this.praesSuiteErlaubt = b;
		this.rabatt = d;

	}

	public boolean isPraesSuiteErlaubt() {
		return praesSuiteErlaubt;
	}

	public double getRabatt() {
		return rabatt;
	}

}

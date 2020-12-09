package klassen;

public enum ZimmerStatus {
	FREI, GEBUCHT, BELEGT,;

	private boolean bezahlt;

	public boolean isBezahlt() {
		return bezahlt;
	}

	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}

}

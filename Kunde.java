package moduls;

public class Kunde {
	private int id;
	private String name;
	private String nachname;
	private Status kundenStatus;
	private Kreis kreis;
	private double rechnung;
	private Zimmer kundenZimmer;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Kreis getKreis() {
		return this.kreis;
	}

	public void setKreis(Kreis kreis) {
		this.kreis = kreis;
	}

	public double getRechnung() {
		return this.rechnung;
	}

	public void setRechnung(double rechnung) {
		this.rechnung = rechnung;
	}

	public Status getKundenStatus() {
		return kundenStatus;
	}

	public void setKundenStatus(Status kundenStatus) {
		this.kundenStatus = kundenStatus;
	}

	public Zimmer getKundenZimmer() {
		return kundenZimmer;
	}

	public void setKundenZimmer(Zimmer kundenZimmer) {
		this.kundenZimmer = kundenZimmer;
	}

	@Override
	public String toString() {
		return String.format(
				"Kunde [id=%s, name=%s, nachname=%s, kundenStatus=%s, kreis=%s, rechnung=%s, kundenZimmer=%s]", id,
				name, nachname, kundenStatus, kreis, rechnung, kundenZimmer);
	}
}
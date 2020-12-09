package klassen;

public class Kunde {

	private String name;
	private String nachname;
	private int id;
	private ZimmerStatus kundenStatus;
	private KundenKreis kreis;
	private double rechnung;
	private Zimmer kundenZimmer;

	public int getId() {
		return this.id;
	}

	public KundenKreis getKreis() {
		return this.kreis;
	}

	public ZimmerStatus getKundenStatus() {
		return this.kundenStatus;
	}

	public Zimmer getKundenZimmer() {
		return this.kundenZimmer;
	}

	public String getNachname() {
		return this.nachname;
	}

	public String getName() {
		return this.name;
	}

	public double getRechnung() {
		return this.rechnung;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKundenKreis(KundenKreis kreis) {
		this.kreis = kreis;
	}

	public void setKundenStatus(ZimmerStatus kundenStatus) {
		this.kundenStatus = kundenStatus;
	}

	public void setKundenZimmer(Zimmer zimmer) {
		this.kundenZimmer = zimmer;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRechnung(double rechnung) {
		this.rechnung = rechnung;
	}

	@Override
	public String toString() {
		return String.format("Kunde: %s %s, ID:%s, %s Member, Rechnung: %s€ ", this.name, this.nachname, this.id,
				this.kreis, this.rechnung);
	}

}
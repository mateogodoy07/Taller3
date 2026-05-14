package Package;

public class Fuego extends Hechizos {
	private int DuracionQuemadura;

	public Fuego(String NombreHechizo, String Tipo, int Daño,int DuracionQuemadura) {
		super(NombreHechizo, Tipo, Daño);
		this.DuracionQuemadura = DuracionQuemadura;
		
	}

	public int getDuracionQuemadura() {
		return DuracionQuemadura;
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		DuracionQuemadura = duracionQuemadura;
	}

}

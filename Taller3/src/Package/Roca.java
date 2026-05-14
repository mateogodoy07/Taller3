package Package;

public class Roca extends Hechizos {
		private int MejoraDefensa;

	public Roca(String NombreHechizo, String Tipo, int Daño,int MejoraDefensa) {
		super(NombreHechizo, Tipo, Daño);
		this.MejoraDefensa = MejoraDefensa;
		
	}

	public int getMejoraDefensa() {
		return MejoraDefensa;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		MejoraDefensa = mejoraDefensa;
	}

}

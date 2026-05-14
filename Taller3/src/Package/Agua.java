package Package;

public class Agua extends Hechizos{
	private int CantidadHeal;
	private int PresionDelAgua;

	public Agua(String NombreHechizo, String Tipo, int Daño,int CantidadHeal,int PresionDelAgua) {
		super(NombreHechizo, Tipo, Daño);
		this.CantidadHeal = CantidadHeal;
		this.PresionDelAgua =PresionDelAgua;
		
	}

	public int getCantidadHeal() {
		return CantidadHeal;
	}

	public void setCantidadHeal(int cantidadHeal) {
		CantidadHeal = cantidadHeal;
	}

	public int getPresionDelAgua() {
		return PresionDelAgua;
	}

	public void setPresionDelAgua(int presionDelAgua) {
		PresionDelAgua = presionDelAgua;
	}

}

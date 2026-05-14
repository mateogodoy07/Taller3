package Package;

public class Planta extends Hechizos {
	private int DuracionStun;
	private int CantPlantas;

	public Planta(String NombreHechizo, String Tipo, int Daño, int DuracionStun, int CantPlantas) {
		super(NombreHechizo, Tipo, Daño);
		this.DuracionStun = DuracionStun;
		this.CantPlantas = CantPlantas;
		
	}

	public int getDuracionStun() {
		return DuracionStun;
	}

	public void setDuracionStun(int duracionStun) {
		DuracionStun = duracionStun;
	}

	public int getCantPlantas() {
		return CantPlantas;
	}

	public void setCantPlantas(int cantPlantas) {
		CantPlantas = cantPlantas;
	}

}

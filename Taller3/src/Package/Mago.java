package Package;

import java.util.ArrayList;

public class Mago {
	private String Nombre;
	ArrayList<Hechizos> Hechizos = new ArrayList<>();
	
	public Mago(String Nombre) {
		this.Nombre = Nombre;
		this.Hechizos = new ArrayList<>();
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

}

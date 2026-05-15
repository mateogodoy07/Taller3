package Package;

import java.util.ArrayList;

public class Mago {
	private String Nombre;
	private String[] Hechizo;
	ArrayList<Hechizos> Hechizos = new ArrayList<>();
	
	public Mago(String Nombre,String[] Hechizo) {
		this.Nombre = Nombre;
		this.Hechizo = Hechizo;
		this.Hechizos = new ArrayList<>();
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String[] getHechizo() {
		return Hechizo;
	}

	public void setHechizo(String[] hechizo) {
		Hechizo = hechizo;
	}

}

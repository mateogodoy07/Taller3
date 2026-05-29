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
	public ArrayList<Hechizos> getHechizos(){
		ArrayList<Hechizos>MagoHechizo = new ArrayList<>();
		for(int i = 0; i < Hechizos.size();i++) {
			if(Hechizos.get(i)!=null) {
				MagoHechizo.add(Hechizos.get(i));
			}
		}
		return MagoHechizo;
		
	}
	public void agregarHechizo(Hechizos hechizo) {
	    Hechizos.add(hechizo);
	}
	

}

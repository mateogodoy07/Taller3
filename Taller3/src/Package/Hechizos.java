package Package;

public class Hechizos {
	private String NombreHechizo;
	private String Tipo;
	private int Daño;
	
	public Hechizos(String NombreHechizo,String Tipo,int Daño) {
		this.NombreHechizo = NombreHechizo;
		this.Tipo = Tipo;
		this.Daño = Daño;
		
	}

	public String getNombreHechizo() {
		return NombreHechizo;
	}

	public void setNombreHechizo(String nombreHechizo) {
		NombreHechizo = nombreHechizo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public int getDaño() {
		return Daño;
	}

	public void setDaño(int daño) {
		Daño = daño;
	}

}

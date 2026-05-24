package Package;

import java.util.ArrayList;

public class Implementacion_Interface implements Interface {

	@Override
	public void AgregarMago(String Archivo, String NM, int CH) {
		
		
	}

	@Override
	public void ModificarMago(String Mago, String Archivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarMago(String Mago, String Archivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AgregarHechizo(String Hechizo, String Archivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModificarHechizo(String Hechizo, String Archivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EliminarHechizo(String Hechizo, String Archivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Mejores10Hechizos(ArrayList<Hechizos> Hechizos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Top3Magos(ArrayList<Mago> Magos, ArrayList<Hechizos> Hechizos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MostrarHechizos(ArrayList<Hechizos> Hechizos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MostrarMagos(ArrayList<Mago> Magos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MostrarPuntacionHechizos(ArrayList<Hechizos> Hechizos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MostrarPuntacionMagos(ArrayList<Mago> Magos, ArrayList<Hechizos> Hechizos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int CalculoPuntuacionHechizoFuego(String NombreHechizo, int DañoQuemadura, int DuracionQuemadura) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CalculoPuntuacionHechizoTierra(String NombreHechizo, int DañoTierra, int MejoraDefensa) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CalculoPuntuacionHechizoPlanta(String NombreHechizo, int DañoPlanta, int DuracionStun,
			int CantidadPlantas) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CalculoPuntuacionHechizoAgua(String NombreHechizo, int DañoAgua, int CantidadCurada, int PresionAgua) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}

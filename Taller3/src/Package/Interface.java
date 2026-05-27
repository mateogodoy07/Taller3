package Package;

import java.util.ArrayList;

public interface Interface {
	//Administrador
	 void AgregarMago(String Archivo); // NM = Nuevo Mago , CH = Cantidad Hechizos
	 void ModificarMago(String Archivo,ArrayList<Mago>Magos,ArrayList<Hechizos> hechizos);
	 void EliminarMago(String Mago, String Archivo);
	 void AgregarHechizo(String Hechizo, String Archivo);
	 void ModificarHechizo(String Hechizo, String Archivo);
	 void EliminarHechizo(String Hechizo, String Archivo);
	
	//Analista
	 void Mejores10Hechizos(ArrayList<Hechizos>Hechizos); // Mostrar los 10 mejores
	 void Top3Magos(ArrayList<Mago>Magos,ArrayList<Hechizos>Hechizos);
	 void MostrarHechizos(ArrayList<Hechizos>Hechizos);
	 void MostrarMagos(ArrayList<Mago>Magos);
	 void MostrarPuntacionHechizos(ArrayList<Hechizos>Hechizos);
	 void MostrarPuntacionMagos(ArrayList<Mago> Magos,ArrayList<Hechizos>Hechizos);
	 
	 //Funciones 
	 int CalculoPuntuacionHechizoFuego(String NombreHechizo, int DañoQuemadura, int DuracionQuemadura);
	 int CalculoPuntuacionHechizoTierra(String NombreHechizo, int DañoTierra,int MejoraDefensa);
	 int CalculoPuntuacionHechizoPlanta(String NombreHechizo, int DañoPlanta,int DuracionStun, int CantidadPlantas);
	 int CalculoPuntuacionHechizoAgua(String NombreHechizo, int DañoAgua, int CantidadCurada, int PresionAgua);
	 public void Menu (int opciones);

}

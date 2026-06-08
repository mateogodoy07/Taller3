package Package;

import java.util.ArrayList;

public interface Interface {
	//Administrador
	 void AgregarMago(String Archivo); // NM = Nuevo Mago , CH = Cantidad Hechizos
	 void ModificarMago(String Archivo,ArrayList<Mago>Magos,ArrayList<Hechizos> hechizos);
	 void EliminarMago(ArrayList<Mago> MagoElegido,String Archivo);
	 void AgregarHechizo(String Archivo,ArrayList<Hechizos>Hechizos);
	 void ModificarHechizo(String Archivo,ArrayList<Hechizos>Hechizos);
	 void EliminarHechizo(ArrayList<Hechizos>Hechizos, String Archivo);
	
	//Analista
	 void Mejores10Hechizos(ArrayList<Hechizos>Hechizos); // Mostrar los 10 mejores
	 void Top3Magos(ArrayList<Mago>Magos,ArrayList<Hechizos>Hechizos);
	 void MostrarHechizos(ArrayList<Hechizos>Hechizos);
	 void MostrarMagos(ArrayList<Mago>Magos);
	 void MostrarPuntacionHechizos(ArrayList<Hechizos>Hechizos);
	 void MostrarPuntacionMagos(ArrayList<Mago> Magos,ArrayList<Hechizos>Hechizos);
	 
	 //Funciones 
	 int CalculoPuntuacionHechizoFuego( int DañoQuemadura, int DuracionQuemadura);

	 int CalculoPuntuacionHechizoTierra( int DañoTierra,int MejoraDefensa);

	 int CalculoPuntuacionHechizoPlanta( int DañoPlanta,int DuracionStun, int CantidadPlantas);

	 int CalculoPuntuacionHechizoAgua( int DañoAgua, int CantidadCurada, int PresionAgua);
	 
	 void AgregarEnArchivo(String dato, String Archivo);


}

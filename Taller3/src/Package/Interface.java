package Package;

public interface Interface {
	//Administrador
	 void AgregarMago(String Archivo,String NM,int CH); // NM = Nuevo Mago , CH = Cantidad Hechizos
	 void ModificarMago(String Mago);
	 void EliminarMago(String Mago);
	 void AgregarHechizo();
	 void ModificarHechizo();
	 void EliminarHechizo();
	
	//Analista
	 void MejoresHechizos();
	 void Top3Magos();
	 void MostrarHechizos();
	 void MostrarMagos();
	 void MostrarPuntacionHechizos();
	 void MostrarPuntacionMagos();

}

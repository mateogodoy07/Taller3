package Package;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller3 {

	public static void main(String[] args) {
		ArrayList<Hechizos> hechizos = new ArrayList<>();
		
		try {
			File Mago = new File("Magos.txt");
			Scanner lector = new Scanner(Mago);
			String linea;
			
			while(lector.hasNextLine()) {
				linea = lector.nextLine();
				String[] partes = linea.split(";");
				String NombreMago = partes[0];
				for(int i = 0; i <partes.length;i++) {
					if(partes[i]!=null) {
						linea = lector.nextLine();
						String partes2[] = linea.split("|");
						String Hechizos = partes2[i+1];
					}
				}
				
			}
			
		}catch(IOException e) {}
		
		try {
			File Hechizos = new File("Hechizos.txt");
			Scanner lector = new Scanner(Hechizos);
			String linea;
			
			while(lector.hasNextLine()) {
				linea = lector.nextLine();
				String[] partes = linea.split(";");
				String NombreHechizo = partes[0];
				String Tipo = partes[1];
				int Daño = Integer.valueOf(partes[2]);
				if(Tipo == "Fuego") {
					int DQ = Integer.valueOf(partes[3]); //DQ = Daño Quemadura
					Fuego fuego = new Fuego(NombreHechizo,Tipo,Daño,DQ);
					hechizos.add(fuego);
				}
				if(Tipo == "Rocas") {
					int MD = Integer.valueOf(partes[3]); // MD = Mejor Defensa
					Roca roca = new Roca(NombreHechizo,Tipo,Daño,MD);
					hechizos.add(roca);
					
				}
				if(Tipo == "Planta") {
					int DS = Integer.valueOf(partes[3]); // Duracion Stun
					int CP = Integer.valueOf(partes[4]); // Cantidad Plantas
					
					Planta planta = new Planta(NombreHechizo,Tipo,Daño,DS,CP);
					hechizos.add(planta);
					
				}
				if(Tipo == "Agua") {
					int CH = Integer.valueOf(partes[3]); // CH =  Cantidad Heal
					int PA = Integer.valueOf(partes[4]); // PA = Presion Agua
					
					Agua agua = new Agua(NombreHechizo,Tipo,Daño,CH,PA);
					hechizos.add(agua);

					
				}
				
			}
			
		}catch(IOException e) {}

	}
	

}


	


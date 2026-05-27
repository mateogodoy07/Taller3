package Package;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Taller3 {
	

	public static void main(String[] args) {
		Interface sistema = new Implementacion_Interface();
		ArrayList<Mago> Magos = new ArrayList<>();
		ArrayList<Hechizos> hechizos = new ArrayList<>();
		
		try {
			File Mago = new File("Magos.txt");
			Scanner lector = new Scanner(Mago);
			String linea;
			
			while(lector.hasNextLine()) {
				linea = lector.nextLine();
				String[] partes = linea.split(";");
				String NombreMago = partes[0];
				String[] Hechizos = partes[1].split("//|");
				for(int i = 0; i <partes.length;i++) {
					if(partes[i]!=null) {
						Mago mago = new Mago(NombreMago);
						Magos.add(mago);
						//lectura mago
						
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
					
					// falta partir el agua y planta con , en sus datos

					
				}
				
			}
			
		}catch(IOException e) {}
		int opciones = 0;
		
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("1) Menu Administrador");
			System.out.println("2) Menu Analista");
			System.out.println("3) Salir.");
			System.out.println("");
			System.out.print("Escoja su opcion: ");
			opciones = Integer.valueOf(scanner.nextLine());	
			if(opciones == 1) {
				do {
					System.out.println("1. Agregar Mago");
					System.out.println("2. Modificar Mago");
					System.out.println("3. Eliminar Mago");
					System.out.println("4. Agregar Hechizo");
					System.out.println("5. Modificar Hechizo");
					System.out.println("6. Eliminar Hechizo");
					System.out.println("7. Salir");
					System.out.print("Escoja su opcion: ");
					opciones = Integer.valueOf(scanner.nextLine());	
					if(opciones == 1) {
						sistema.AgregarMago("Magos.txt");
					}
					if(opciones == 2) {
						
					}
					if(opciones== 3) {
						
					}
					if(opciones == 4) {
						
					}
					if(opciones == 5) {
						
					}
					if(opciones ==6) {
						
					}
					
				}while(opciones !=7);
				
				
			}
			if(opciones == 2) {
				do {
					System.out.println("1. Top 10 Mejores Hechizos ");
					System.out.println("2. Top 3 Mejores Magos");
					System.out.println("3.Mostrar Todos Los Hechizos");
					System.out.println("4. Mostrar Todos Los Magos");
					System.out.println("5. Mostrar Todos Los Hechizos Junto a Su Puntuacion");
					System.out.println("6. Mostrar Todos Los Magos Junto A Su Puntuacion");
					System.out.println("7. Salir");
					
					if(opciones ==1) {
						
					}
					if(opciones == 2) {
						
					}
					if(opciones == 3) {
						
					}
					if(opciones == 4) {
						
					}
					if(opciones == 5) {
						
					}
					if(opciones == 6) {
						
					}
					
					
				}while(opciones !=7);
				
			}
				
			
		}while(opciones !=3);
		
		
		
		
		

	}
	
	

}


	


//Integrante 1: Mateo Godoy Carrasco - 21924663-3 - mateogodoy07
//Carrera: Ingenieria Civil Industrial
//Link repositorio: https://github.com/mateogodoy07/Taller3



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
			File Hechizos = new File("Hechizos.txt");
			Scanner lector = new Scanner(Hechizos);
			String linea;
			
			while(lector.hasNextLine()) {
				linea = lector.nextLine();
				String[] partes = linea.split(";");
				String NombreHechizo = partes[0];
				String Tipo = partes[1];
				int Daño = Integer.valueOf(partes[2]);
				if(Tipo.equals("Fuego")) {
					int DQ = Integer.valueOf(partes[3]); //DQ = Daño Quemadura
					Fuego fuego = new Fuego(NombreHechizo,Tipo,Daño,DQ);
					hechizos.add(fuego);
				}
				if(Tipo.equals("Tierra")) {
					int MD = Integer.valueOf(partes[3]); // MD = Mejor Defensa
					Roca roca = new Roca(NombreHechizo,Tipo,Daño,MD);
					hechizos.add(roca);
					
				}
				if(Tipo.equals("Planta")) {
				    String[] partes2 = partes[3].split(",");
				    int DS = Integer.valueOf(partes2[0]); // DS = Duracion Stun
				    int CP = Integer.valueOf(partes2[1]); // CP = Cantidad Plantas
				    hechizos.add(new Planta(NombreHechizo, Tipo, Daño, DS, CP));
				}
				if(Tipo.equals("Agua")) {
				    String[] partes2 = partes[3].split(","); 
				    int CH = Integer.valueOf(partes2[0]); // CH = CantidadHeal
				    int PA = Integer.valueOf(partes2[1]); // PA = Presion Agua
				    hechizos.add(new Agua(NombreHechizo, Tipo, Daño, CH, PA));
				}
				
			}
			
		}catch(IOException e) {}
		try {
		    File ArchivoMago = new File("Magos.txt");
		    Scanner lector = new Scanner(ArchivoMago);
		    String linea;

		    while(lector.hasNextLine()) {
		        linea = lector.nextLine();
		        String[] partes = linea.split(";");
		        String NombreMago = partes[0];
		        String[] hechizosNombre = partes[1].split("\\|");

		        Mago mago = new Mago(NombreMago); 

		        for(int i = 0; i < hechizosNombre.length; i++) {
		            for(int j = 0; j < hechizos.size(); j++) {
		                if(hechizos.get(j).getNombreHechizo().equals(hechizosNombre[i])) {
		                    mago.agregarHechizo(hechizos.get(j)); 
		                    break; 
		                }
		            }
		        }

		        Magos.add(mago); 
		    }
		    

		} catch(IOException e) {}
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
					System.out.println("");
					System.out.println("1. Agregar Mago");
					System.out.println("2. Modificar Mago");
					System.out.println("3. Eliminar Mago");
					System.out.println("4. Agregar Hechizo");
					System.out.println("5. Modificar Hechizo");
					System.out.println("6. Eliminar Hechizo");
					System.out.println("7. Salir");
					System.out.println("");
					System.out.print("Escoja su opcion: ");
					opciones = Integer.valueOf(scanner.nextLine());	
					if(opciones == 1) {
						sistema.AgregarMago("Magos.txt");
					}
					if(opciones == 2) {
						sistema.ModificarMago("Magos.txt", Magos, hechizos);		
					}
					if(opciones== 3) {
						sistema.EliminarMago(Magos, "Magos.txt");
					}
					if(opciones == 4) {
						sistema.AgregarHechizo("Hechizos.txt", hechizos);
					}
					if(opciones == 5) {
						sistema.ModificarHechizo("Hechizos.txt", hechizos);
						
					}
					if(opciones ==6) {
						sistema.EliminarHechizo(hechizos, "Hechizos.txt");
					}
					
				}while(opciones !=7);
				
				
			}
			if(opciones == 2) {
				do {
					System.out.println("");
					System.out.println("1. Top 10 Mejores Hechizos ");
					System.out.println("2. Top 3 Mejores Magos");
					System.out.println("3. Mostrar Todos Los Hechizos");
					System.out.println("4. Mostrar Todos Los Magos");
					System.out.println("5. Mostrar Todos Los Hechizos Junto a Su Puntuacion");
					System.out.println("6. Mostrar Todos Los Magos Junto A Su Puntuacion");
					System.out.println("7. Salir");
					System.out.println("");
					System.out.print("Escoja su opcion: ");
					opciones = Integer.valueOf(scanner.nextLine());	
					
					if(opciones ==1) {
						sistema.Mejores10Hechizos(hechizos);
					}
					if(opciones == 2) {
						sistema.Top3Magos(Magos, hechizos);
					}
					if(opciones == 3) {
						sistema.MostrarHechizos(hechizos);
					}
					if(opciones == 4) {
						sistema.MostrarMagos(Magos); 
					}
					if(opciones == 5) {
						sistema.MostrarPuntacionHechizos(hechizos);
					}
					if(opciones == 6) {
						sistema.MostrarPuntacionMagos(Magos, hechizos);
					}
					
					
				}while(opciones !=7);
				
			}
				
			
		}while(opciones !=3);
		
		
		
		
		

	}
	
	

}


	


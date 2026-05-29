package Package;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Implementacion_Interface implements Interface {
	Scanner scanner = new Scanner(System.in);

	
	public void AgregarMago(String Archivo) {
		try {
			BufferedWriter Magos = new BufferedWriter(new FileWriter(Archivo,true));
			System.out.print("Ingrese el nombre de su nuevo mago: ");
			String Mago = String.valueOf(scanner.nextLine());
			System.out.print("Ingrese la cantidad de hechizos que tendra su nuevo mago: ");
			int CantidadHechizos = Integer.valueOf(scanner.nextLine());
			String CapacidadHechizos = "";
			for(int i = 0; i < CantidadHechizos; i++) {
				if(i < CantidadHechizos-1) {
					CapacidadHechizos += "vacio|";
				}
				else {
					CapacidadHechizos += "vacio";
				}
				
			}
			String NuevoMago = Mago +";"+ CapacidadHechizos;
			Magos.newLine();
			Magos.write(NuevoMago);
			Magos.close();
			System.out.println("");
			System.out.println("Se ha agredado su nuevo mago con exito!!");
		}catch(IOException e) {}
		
	}

	
	public void ModificarMago( String Archivo,ArrayList<Mago>Magos,ArrayList<Hechizos> hechizos) {
		try {
			BufferedWriter Magos2 = new BufferedWriter(new FileWriter(Archivo,false));
			System.out.println("Que mago desea modificar");
			String MagoSeleccionado = String.valueOf(scanner.nextLine());
			for (Mago mago : Magos) {
				if(mago != null) {
					if(mago.equals(MagoSeleccionado)) {
						System.out.println("Que deseas modificar de: "+MagoSeleccionado+".");
						System.out.println("1) Su nombre");
						System.out.println("2) Algunos de sus Hechizos");
						System.out.println("3) Salir");
						int opcion = Integer.valueOf(scanner.nextLine());
						if(opcion == 1) {
							System.out.print("Coloque el Nuevo nombre que le pondra a su mago: ");
							String NuevoNombre = scanner.nextLine();
							MagoSeleccionado = NuevoNombre;
							mago.setNombre(NuevoNombre);
							for(Mago M: Magos) {
								if(M != null) {
									Magos2.write(M.getNombre() + ";");
									hechizos = M.getHechizos();
									for(int j = 0 ; j < hechizos.size(); j++) {
										Magos2.write(hechizos.get(j).getNombreHechizo());
										if(j < hechizos.size()-1) {
											Magos2.write("|");
										}
									}
									Magos2.newLine();
								}
							}
							Magos2.close();
							
							System.out.println("Nombre de su mago cambiado con exito!!");
							//ver si esta correcta la funcion,ademas de cambiarlo en el wutehred writer y agregarle la lista de ehcizos de un inicio
						}
						if(opcion == 2) {
							System.out.println("Hechizos de "+MagoSeleccionado);
							 
							ArrayList<Hechizos>HechizosMagoSeleccionado = mago.getHechizos();
							for(int k = 0; k < HechizosMagoSeleccionado.size();k++) {
								System.out.println(k+1+") "+HechizosMagoSeleccionado.get(k).getNombreHechizo());
							}
							
						}
						if(opcion == 3) {
							System.out.println("Regresando al Menu..");
							// Arreglar el de regresar 
						}return;
					}
				}
			}
			
		}catch(IOException e) {}
		
		
	}

	@Override
	public void EliminarMago(String Mago, String Archivo) {
		// TODO Auto-generated method stub
		
	}

	
	public void AgregarHechizo(String Hechizo, String Archivo,ArrayList<Hechizos>Hechizos) {
		String NuevoHechizo;
		System.out.print("Cual Sera el nomrbe de su nuevo hechizo: ");
		String Nombre = scanner.nextLine();
		System.out.print("De que tipo sera su hechizo(Fuego/Tierra/Planta/Agua): ");
		String Tipo = scanner.nextLine();
		System.out.print("Que daño tendra su nuevo hechizo(Debe ser un numero entero: )");
		int Daño = Integer.valueOf(scanner.nextLine());
		
		if(Tipo.equals("Fuego")) {
			System.out.print("Cuanto durara su quemadura de su hechizo fuego(Debe ser un numero enter): ");
			int Quemadura = Integer.valueOf(scanner.nextLine());
			Fuego nuevo = new NuevoHechizo();
			nuevo = Nombre+";"+Tipo+";"+Daño+";"+Quemadura;
			// Arreglar agregar hechizo
		}
		
		
	}

	
	public void ModificarHechizo(String Hechizo, String Archivo,ArrayList<Hechizos>Hechizos) {
		try {
			BufferedWriter Magos2 = new BufferedWriter(new FileWriter(Archivo,false));
			System.out.print("Cual hechizo quieres modificar: ");
			String Decision = scanner.nextLine();
			for(int i = 0; i < Hechizos.size();i++) {
				
				if(Hechizos.get(i).getNombreHechizo().equals(Decision)) {
					Fuego hechizoFuego = (Fuego) Hechizos.get(i);
					if(Hechizos.get(i).getTipo().equals("Fuego")) {
						System.out.println("Que deseas modificar?");
						System.out.println("1) Nombre");
						System.out.println("2) Tipo");
						System.out.println("3) Daño");
						System.out.println("4) Duracion Quemadura");
						
						int opcion = Integer.valueOf(scanner.nextLine());
						if(opcion == 1) {
				            System.out.print("Nuevo nombre: ");
				            hechizoFuego.setNombreHechizo(scanner.nextLine());
				        }
				        if(opcion == 2) {
				            System.out.print("Nuevo tipo: ");
				            hechizoFuego.setTipo(scanner.nextLine());
				        }
				        if(opcion == 3) {
				            System.out.print("Nuevo daño: ");
				            hechizoFuego.setDaño(Integer.valueOf(scanner.nextLine()));
				        }
				        if(opcion == 4) {
				            System.out.print("Nueva duracion quemadura: ");
				            hechizoFuego.setDuracionQuemadura(Integer.valueOf(scanner.nextLine()));
				        }
					}
				}
			}
			
		}catch(IOException e) {}
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

	
	public void MostrarHechizos(ArrayList<Hechizos> Hechizos) {
		for(int i = 0; i < Hechizos.size(); i++) {
			System.out.println((i+1)+") "+Hechizos.get(i).getNombreHechizo()+"|"+Hechizos.get(i).getTipo());
		}
		
	}

	public void MostrarMagos(ArrayList<Mago> Magos) {
		for(int i = 0; i < Magos.size(); i++) {
			String hechizos = "|";
			for(int j = 0; j < Magos.get(j).getHechizos().size();j++) {
				if(j<Magos.get(i).getHechizos().size()-1){
					hechizos += Magos.get(i).getHechizos().get(j)+"|";
				}
				else {
					hechizos += Magos.get(i).getHechizos().get(j);
				}
			}
			System.out.println((i+1)+") "+Magos.get(i).getNombre()+"|"+hechizos);
		}
		
	}

	
	public void MostrarPuntacionHechizos(ArrayList<Hechizos> Hechizos) {
		for(int i = 0; i < Hechizos.size(); i ++) {
			if(Hechizos.get(i).getTipo().equals("Fuego")) {
				Fuego HechizoFuego = (Fuego) Hechizos.get(i);
				int puntuacion =CalculoPuntuacionHechizoFuego(HechizoFuego.getDaño(),HechizoFuego.getDuracionQuemadura());
				System.out.println((i+1)+") "+"Hechizo: " + HechizoFuego.getNombreHechizo()+"|" + " Puntuacion: " + puntuacion);			
				}
			if(Hechizos.get(i).getTipo().equals("Tierra")) {
				Roca HechizoTierra = (Roca) Hechizos.get(i);
				int puntuacion =CalculoPuntuacionHechizoTierra(HechizoTierra.getDaño(),HechizoTierra.getMejoraDefensa());
				System.out.println((i+1)+") "+"Hechizo: " + HechizoTierra.getNombreHechizo()+"|" + " Puntuacion: " + puntuacion);			
				}
			if(Hechizos.get(i).getTipo().equals("Planta")) {
				Planta HechizoPlanta = (Planta) Hechizos.get(i);
				int puntuacion =CalculoPuntuacionHechizoPlanta(HechizoPlanta.getDaño(),HechizoPlanta.getDuracionStun(),HechizoPlanta.getCantPlantas());
				System.out.println((i+1)+") "+"Hechizo: " + HechizoPlanta.getNombreHechizo()+"|" + " Puntuacion: " + puntuacion);			
				}
			if(Hechizos.get(i).getTipo().equals("Agua")) {
				Agua HechizoAgua = (Agua) Hechizos.get(i);
				int puntuacion =CalculoPuntuacionHechizoAgua(HechizoAgua.getDaño(),HechizoAgua.getCantidadHeal(),HechizoAgua.getPresionDelAgua());
				System.out.println((i+1)+") "+"Hechizo: " + HechizoAgua.getNombreHechizo()+"|" + " Puntuacion: " + puntuacion);			
				}
			
			
		}
		
	}

	
	public void MostrarPuntacionMagos(ArrayList<Mago> Magos, ArrayList<Hechizos> Hechizos) {
		int contador = 0;
		for( int i = 0; i < Magos.size();i++) {
			// Completar
		}
		
	}

	@Override
	public int CalculoPuntuacionHechizoFuego( int DañoQuemadura, int DuracionQuemadura) {
		int fuego = 0;
		fuego = DañoQuemadura*DuracionQuemadura;
		return fuego;
	}
	

	@Override
	public int CalculoPuntuacionHechizoTierra( int DañoTierra, int MejoraDefensa) {
		int tierra = 0;
		tierra = (DañoTierra*MejoraDefensa)/2;
		return tierra;
	}

	@Override
	public int CalculoPuntuacionHechizoPlanta( int DañoPlanta, int DuracionStun,
			int CantidadPlantas) {
		int planta = 0;
		planta = DañoPlanta+(DuracionStun*CantidadPlantas);
		return planta;
	}

	@Override
	public int CalculoPuntuacionHechizoAgua( int DañoAgua, int CantidadCurada, int PresionAgua) {
		int agua = 0;
		agua = (DañoAgua+CantidadCurada+PresionAgua)/2;
		return agua;
	}
	public void Menu (int opciones) {
		do {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1) Menu Administrador");
		System.out.println("2) Menu Analista");
		System.out.println("3) Salir.");
		System.out.println("");
		System.out.print("Escoja su opcion: ");
		
		if(opciones == 1) {
			do {
				System.out.println("1. Agregar Mago");
				System.out.println("2. Modificar Mago");
				System.out.println("3. Eliminar Mago");
				System.out.println("4. Agregar Hechizo");
				System.out.println("5. Modificar Hechizo");
				System.out.println("6. Eliminar Hechizo");
				System.out.println("7. Salir");
				
				if(opciones == 1) {
					AgregarMago("Magos.txt");
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
		
		opciones = Integer.valueOf(scanner.nextLine());		
		
	}while(opciones !=3);
		
	}
	
	

}

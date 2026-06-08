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

			System.out.println("Que mago desea modificar");
			String MagoSeleccionado = String.valueOf(scanner.nextLine());
			for (Mago mago : Magos) {
				if(mago != null) {
					if(mago.getNombre().equals(MagoSeleccionado)){
						System.out.println("Que deseas modificar de: "+MagoSeleccionado+".");
						System.out.println("1) Su nombre");
						System.out.println("2) Algunos de sus Hechizos");
						System.out.println("3) Salir");
						int opcion = Integer.valueOf(scanner.nextLine());
						if (opcion == 1) {
						    System.out.print("Coloque el nuevo nombre: ");
						    String NuevoNombre = scanner.nextLine();
						    mago.setNombre(NuevoNombre);

						    try {
						        BufferedWriter Magos2 = new BufferedWriter(new FileWriter(Archivo, false));
						        String CapacidadHechizos = "";
						        for (Mago M : Magos) {
						            if (M != null) {
						                Magos2.write(M.getNombre() + ";");
						                ArrayList<Hechizos> hechizosM = M.getHechizos();
						                for (int j = 0; j < hechizosM.size(); j++) {
						                    if (j < hechizosM.size() - 1) {
						                        Magos2.write(hechizosM.get(j).getNombreHechizo() + "|");
						                    } else {
						                        Magos2.write(hechizosM.get(j).getNombreHechizo());
						                    }
						                }
						               
						                Magos2.newLine();
						            }
						        }
						        Magos2.close();
						    } catch (IOException e) {}

						    System.out.println("Nombre cambiado con exito!!");
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
			
		
		
	}

	public void EliminarMago(ArrayList<Mago> Magos, String Archivo) {
	    System.out.print("Que mago desea eliminar: ");
	    String MagoSeleccionado = scanner.nextLine();
	    Mago magoAEliminar = null;
	    for (Mago mago : Magos) {
	        if (mago != null && mago.getNombre().equals(MagoSeleccionado)) {
	            magoAEliminar = mago;
	            break;
	        }
	    }
	    if (magoAEliminar == null) {
	        System.out.println("No se encontro el mago: " + MagoSeleccionado);
	        return;
	    }

	    Magos.remove(magoAEliminar);

	    try {
	        BufferedWriter escritor = new BufferedWriter(new FileWriter(Archivo, false));
	        for (Mago M : Magos) {
	            if (M != null) {
	                escritor.write(M.getNombre() + ";");
	                ArrayList<Hechizos> hechizosM = M.getHechizos();
	                for (int j = 0; j < hechizosM.size(); j++) {
	                    if (hechizosM.get(j) != null) {
	                        if (j < hechizosM.size() - 1) {
	                            escritor.write(hechizosM.get(j).getNombreHechizo() + "|");
	                        } else {
	                            escritor.write(hechizosM.get(j).getNombreHechizo());
	                        }
	                    } else {
	                        if (j < hechizosM.size() - 1) {
	                            escritor.write("vacio|");
	                        } else {
	                            escritor.write("vacio");
	                        }
	                    }
	                }
	                escritor.newLine();
	            }
	        }
	        escritor.close();
	        System.out.println("Mago eliminado con exito!!");
	    } catch (IOException e) {}
	}
	
	public void AgregarHechizo(String Archivo,ArrayList<Hechizos>Hechizos) {
		System.out.print("Cual Sera el nomrbe de su nuevo hechizo: ");
		String Nombre = scanner.nextLine();
		System.out.print("De que tipo sera su hechizo(Fuego/Tierra/Planta/Agua): ");
		String Tipo = scanner.nextLine();
		System.out.print("Que daño tendra su nuevo hechizo(Debe ser un numero entero: )");
		int Daño = Integer.valueOf(scanner.nextLine());
		
		if(Tipo.equals("Fuego")) {
			System.out.print("Cuanto durara su quemadura de su hechizo fuego(Debe ser un numero entero): ");
			int Quemadura = Integer.valueOf(scanner.nextLine());
			Fuego nuevo = new Fuego(Nombre,Tipo,Daño,Quemadura);
			Hechizos.add(nuevo);
			String DatoArchivo = Nombre+";"+Tipo+";"+Daño+";"+Quemadura;
			AgregarEnArchivo(DatoArchivo, "Hechizos.txt");
		}
		if(Tipo.equals("Tierra")) {
			System.out.print("Cuanto mejorara su defensa de su hechizo tierra(Debe ser un numero entero): ");
			int DefensaTierra = Integer.valueOf(scanner.nextLine());
			Roca nuevo = new Roca(Nombre,Tipo,Daño,DefensaTierra);
			Hechizos.add(nuevo);
			String DatoArchivo = Nombre+";"+Tipo+";"+Daño+";"+DefensaTierra;
			AgregarEnArchivo(DatoArchivo, "Hechizos.txt");
		}
		if(Tipo.equals("Planta")) {
			System.out.print("Cuanto su stun de su hechizo planta(Debe ser un numero entero): ");
			int StunPlanta = Integer.valueOf(scanner.nextLine());
			System.out.print("Cuanta cantidad de plantas tendra su hechizo planta(Debe ser un numero entero): ");
			int CantidadPlantas =  Integer.valueOf(scanner.nextLine());
			Planta nuevo = new Planta(Nombre,Tipo,Daño,StunPlanta,CantidadPlantas);
			Hechizos.add(nuevo);
			String DatoArchivo = Nombre+";"+Tipo+";"+Daño+";"+StunPlanta+";"+CantidadPlantas;
			AgregarEnArchivo(DatoArchivo, "Hechizos.txt");
		}
		if(Tipo.equals("Agua")) {
			System.out.print("Cuanto curara su hechizo planta(Debe ser un numero entero): ");
			int CantidadHeal = Integer.valueOf(scanner.nextLine());
			System.out.print("Cuanta presion tendra su hechizo planta(Debe ser un numero entero): ");
			int PresionDelAgua =  Integer.valueOf(scanner.nextLine());
			Agua nuevo = new Agua(Nombre,Tipo,Daño,CantidadHeal,PresionDelAgua);
			Hechizos.add(nuevo);
			String DatoArchivo = Nombre+";"+Tipo+";"+Daño+";"+CantidadHeal+";"+PresionDelAgua;
			AgregarEnArchivo(DatoArchivo, "Hechizos.txt");
		}
		
	}

	
	public void ModificarHechizo(String Archivo, ArrayList<Hechizos> Hechizos) {
	    System.out.print("Cual hechizo quieres modificar: ");
	    String Decision = scanner.nextLine();

	    boolean encontrado = false;

	    for (int i = 0; i < Hechizos.size(); i++) {
	        if (Hechizos.get(i).getNombreHechizo().equals(Decision)) {
	            encontrado = true;

	            if (Hechizos.get(i).getTipo().equals("Fuego")) {
	                Fuego h = (Fuego) Hechizos.get(i);
	                System.out.println("Que deseas modificar?");
	                System.out.println("1) Nombre");
	                System.out.println("2) Daño");
	                System.out.println("3) Duracion Quemadura");
	                int opcion = Integer.valueOf(scanner.nextLine());
	                if (opcion == 1) { 
	                	System.out.print("Nuevo nombre: "); 
	                	h.setNombreHechizo(scanner.nextLine()); 
	                	}
	                
	                if (opcion == 2) { 
	                	System.out.print("Nuevo daño: ");
	                	h.setDaño(Integer.valueOf(scanner.nextLine())); 
	                	}
	                
	                if (opcion == 3) { 
	                	System.out.print("Nueva duracion quemadura: "); 
	                	h.setDuracionQuemadura(Integer.valueOf(scanner.nextLine())); 
	                	}
	                
	            }

	            if (Hechizos.get(i).getTipo().equals("Tierra")) {
	                Roca h = (Roca) Hechizos.get(i);
	                System.out.println("Que deseas modificar?");
	                System.out.println("1) Nombre");
	                System.out.println("2) Daño");
	                System.out.println("3) Mejora Defensa");
	                int opcion = Integer.valueOf(scanner.nextLine());
	                if (opcion == 1) { 
	                	System.out.print("Nuevo nombre: "); 
	                	h.setNombreHechizo(scanner.nextLine()); 
	                	}
	                
	                if (opcion == 2) { 
	                	System.out.print("Nuevo daño: "); 
	                	h.setDaño(Integer.valueOf(scanner.nextLine())); 
	                	}
	                
	                if (opcion == 3) { 
	                	System.out.print("Nueva mejora defensa: "); 
	                	h.setMejoraDefensa(Integer.valueOf(scanner.nextLine())); 
	                	}
	                
	            }

	            if (Hechizos.get(i).getTipo().equals("Planta")) {
	                Planta h = (Planta) Hechizos.get(i);
	                System.out.println("Que deseas modificar?");
	                System.out.println("1) Nombre");
	                System.out.println("2) Daño");
	                System.out.println("3) Duracion Stun");
	                System.out.println("4) Cantidad Plantas");
	                int opcion = Integer.valueOf(scanner.nextLine());
	                if (opcion == 1) { System.out.print("Nuevo nombre: "); 
	                h.setNombreHechizo(scanner.nextLine()); 
	                }
	                
	                if (opcion == 2) { System.out.print("Nuevo daño: "); 
	                h.setDaño(Integer.valueOf(scanner.nextLine())); 
	                }
	                
	                if (opcion == 3) { System.out.print("Nueva duracion stun: "); 
	                h.setDuracionStun(Integer.valueOf(scanner.nextLine())); 
	                }
	                
	                if (opcion == 4) { System.out.print("Nueva cantidad plantas: "); 
	                h.setCantPlantas(Integer.valueOf(scanner.nextLine())); 
	                }
	                
	            }

	            if (Hechizos.get(i).getTipo().equals("Agua")) {
	                Agua h = (Agua) Hechizos.get(i);
	                System.out.println("Que deseas modificar?");
	                System.out.println("1) Nombre");
	                System.out.println("2) Daño");
	                System.out.println("3) Cantidad Heal");
	                System.out.println("4) Presion del Agua");
	                int opcion = Integer.valueOf(scanner.nextLine());
	                if (opcion == 1) { System.out.print("Nuevo nombre: "); 
	                h.setNombreHechizo(scanner.nextLine()); 
	                }
	                
	                if (opcion == 2) { System.out.print("Nuevo daño: "); 
	                h.setDaño(Integer.valueOf(scanner.nextLine())); 
	                }
	                
	                if (opcion == 3) { System.out.print("Nueva cantidad heal: "); 
	                h.setCantidadHeal(Integer.valueOf(scanner.nextLine())); 
	                }
	                
	                if (opcion == 4) { System.out.print("Nueva presion del agua: "); 
	                h.setPresionDelAgua(Integer.valueOf(scanner.nextLine())); 
	                }
	                
	            }

	            
	            try {
	                BufferedWriter escritor = new BufferedWriter(new FileWriter(Archivo, false));
	                for (int j = 0; j < Hechizos.size(); j++) {
	                    Hechizos h = Hechizos.get(j);
	                    String linea = "";
	                    if (h.getTipo().equals("Fuego")) {
	                        Fuego hf = (Fuego) h;
	                        linea = hf.getNombreHechizo()+";"+hf.getTipo()+";"+hf.getDaño()+";"+hf.getDuracionQuemadura();
	                    }
	                    
	                    if (h.getTipo().equals("Tierra")) {
	                        Roca ht = (Roca) h;
	                        linea = ht.getNombreHechizo()+";"+ht.getTipo()+";"+ht.getDaño()+";"+ht.getMejoraDefensa();
	                    }
	                    
	                    if (h.getTipo().equals("Planta")) {
	                        Planta hp = (Planta) h;
	                        linea = hp.getNombreHechizo()+";"+hp.getTipo()+";"+hp.getDaño()+";"+hp.getDuracionStun()+","+hp.getCantPlantas();
	                    }
	                    
	                    if (h.getTipo().equals("Agua")) {
	                        Agua ha = (Agua) h;
	                        linea = ha.getNombreHechizo()+";"+ha.getTipo()+";"+ha.getDaño()+";"+ha.getCantidadHeal()+","+ha.getPresionDelAgua();
	                    }
	                    
	                    escritor.write(linea);
	                    escritor.newLine();
	                }
	                
	                escritor.close();
	                System.out.println("Hechizo modificado con exito!!");
	            } catch (IOException e) {}
	            return;
	        }
	    }

	    if (!encontrado) {
	        System.out.println("No se encontro el hechizo: " + Decision);
	    }
	}


	public void EliminarHechizo(ArrayList<Hechizos> Hechizos, String Archivo) {
	    System.out.print("Cual hechizo deseas eliminar: ");
	    String Decision = scanner.nextLine();

	    
	    Hechizos hechizoAEliminar = null;
	    for (Hechizos h : Hechizos) {
	        if (h != null && h.getNombreHechizo().equals(Decision)) {
	            hechizoAEliminar = h;
	            break;
	        }
	    }

	    if (hechizoAEliminar == null) {
	        System.out.println("No se encontro el hechizo: " + Decision);
	        return;
	    }

	    Hechizos.remove(hechizoAEliminar);

	    
	    try {
	        BufferedWriter escritor = new BufferedWriter(new FileWriter(Archivo, false));
	        for (Hechizos h : Hechizos) {
	            if (h != null) {
	                String linea = "";
	                if (h.getTipo().equals("Fuego")) {
	                    Fuego hf = (Fuego) h;
	                    linea = hf.getNombreHechizo()+";"+hf.getTipo()+";"+hf.getDaño()+";"+hf.getDuracionQuemadura();
	                }
	                if (h.getTipo().equals("Tierra")) {
	                    Roca ht = (Roca) h;
	                    linea = ht.getNombreHechizo()+";"+ht.getTipo()+";"+ht.getDaño()+";"+ht.getMejoraDefensa();
	                }
	                if (h.getTipo().equals("Planta")) {
	                    Planta hp = (Planta) h;
	                    linea = hp.getNombreHechizo()+";"+hp.getTipo()+";"+hp.getDaño()+";"+hp.getDuracionStun()+","+hp.getCantPlantas();
	                }
	                if (h.getTipo().equals("Agua")) {
	                    Agua ha = (Agua) h;
	                    linea = ha.getNombreHechizo()+";"+ha.getTipo()+";"+ha.getDaño()+";"+ha.getCantidadHeal()+","+ha.getPresionDelAgua();
	                }
	                escritor.write(linea);
	                escritor.newLine();
	            }
	        }
	        escritor.close();
	        System.out.println("Hechizo eliminado con exito!!");
	    } catch (IOException e) {}
	    
	}


	public void Mejores10Hechizos(ArrayList<Hechizos> Hechizos) {
	    int[] puntuaciones = new int[Hechizos.size()];

	    
	    for (int i = 0; i < Hechizos.size(); i++) {
	        Hechizos h = Hechizos.get(i);
	        if (h != null) {
	            if (h.getTipo().equals("Fuego")) {
	                Fuego hf = (Fuego) h;
	                puntuaciones[i] = CalculoPuntuacionHechizoFuego(hf.getDaño(), hf.getDuracionQuemadura());
	            }
	            if (h.getTipo().equals("Tierra")) {
	                Roca ht = (Roca) h;
	                puntuaciones[i] = CalculoPuntuacionHechizoTierra(ht.getDaño(), ht.getMejoraDefensa());
	            }
	            if (h.getTipo().equals("Planta")) {
	                Planta hp = (Planta) h;
	                puntuaciones[i] = CalculoPuntuacionHechizoPlanta(hp.getDaño(), hp.getDuracionStun(), hp.getCantPlantas());
	            }
	            if (h.getTipo().equals("Agua")) {
	                Agua ha = (Agua) h;
	                puntuaciones[i] = CalculoPuntuacionHechizoAgua(ha.getDaño(), ha.getCantidadHeal(), ha.getPresionDelAgua());
	            }
	        }
	    }

	    
	    System.out.println("=== TOP 10 HECHIZOS ===");
	    boolean[] yaContado = new boolean[Hechizos.size()];

	    for (int top = 0; top < 10 && top < Hechizos.size(); top++) {
	        int maxPuntuacion = -1;
	        int maxIndex = -1;

	        for (int i = 0; i < Hechizos.size(); i++) {
	            if (!yaContado[i] && puntuaciones[i] > maxPuntuacion) {
	                maxPuntuacion = puntuaciones[i];
	                maxIndex = i;
	            }
	        }

	        if (maxIndex != -1) {
	            yaContado[maxIndex] = true;
	            System.out.println((top + 1) + ") Hechizo: " + Hechizos.get(maxIndex).getNombreHechizo() + " | Tipo: " + Hechizos.get(maxIndex).getTipo() + " | Puntuacion: " + maxPuntuacion);
	        }
	    }
	}

	public void Top3Magos(ArrayList<Mago> Magos, ArrayList<Hechizos> Hechizos) {
	
	    int[] puntuaciones = new int[Magos.size()];

	    for (int i = 0; i < Magos.size(); i++) {
	        if (Magos.get(i) != null) {
	            int puntuacionTotal = 0;
	            ArrayList<Hechizos> hechizosM = Magos.get(i).getHechizos();

	            for (int j = 0; j < hechizosM.size(); j++) {
	                Hechizos h = hechizosM.get(j);
	                if (h != null) {
	                    if (h.getTipo().equals("Fuego")) {
	                        Fuego hf = (Fuego) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoFuego(hf.getDaño(), hf.getDuracionQuemadura());
	                    }
	                    if (h.getTipo().equals("Tierra")) {
	                        Roca ht = (Roca) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoTierra(ht.getDaño(), ht.getMejoraDefensa());
	                    }
	                    if (h.getTipo().equals("Planta")) {
	                        Planta hp = (Planta) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoPlanta(hp.getDaño(), hp.getDuracionStun(), hp.getCantPlantas());
	                    }
	                    if (h.getTipo().equals("Agua")) {
	                        Agua ha = (Agua) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoAgua(ha.getDaño(), ha.getCantidadHeal(), ha.getPresionDelAgua());
	                    }
	                }
	            }
	            puntuaciones[i] = puntuacionTotal;
	        }
	    }

	    System.out.println("=== TOP 3 MAGOS ===");
	    boolean[] yaContado = new boolean[Magos.size()];

	    for (int top = 0; top < 3 && top < Magos.size(); top++) {
	        int maxPuntuacion = -1;
	        int max = -1;

	        for (int i = 0; i < Magos.size(); i++) {
	            if (!yaContado[i] && puntuaciones[i] > maxPuntuacion) {
	                maxPuntuacion = puntuaciones[i];
	                max = i;
	            }
	        }

	        if (max != -1) {
	            yaContado[max] = true;
	            System.out.println((top + 1) + ") Mago: " + Magos.get(max).getNombre() + " | Puntuacion: " + maxPuntuacion);
	        }
	    }
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
			System.out.println((i+1)+") "+Magos.get(i).getNombre());
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
	    for (int i = 0; i < Magos.size(); i++) {
	        if (Magos.get(i) != null) {
	            int puntuacionTotal = 0;
	            ArrayList<Hechizos> hechizosM = Magos.get(i).getHechizos();

	            for (int j = 0; j < hechizosM.size(); j++) {
	                Hechizos h = hechizosM.get(j);
	                if (h != null) {
	                    if (h.getTipo().equals("Fuego")) {
	                        Fuego hf = (Fuego) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoFuego(hf.getDaño(), hf.getDuracionQuemadura());
	                    }
	                    if (h.getTipo().equals("Tierra")) {
	                        Roca ht = (Roca) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoTierra(ht.getDaño(), ht.getMejoraDefensa());
	                    }
	                    if (h.getTipo().equals("Planta")) {
	                        Planta hp = (Planta) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoPlanta(hp.getDaño(), hp.getDuracionStun(), hp.getCantPlantas());
	                    }
	                    if (h.getTipo().equals("Agua")) {
	                        Agua ha = (Agua) h;
	                        puntuacionTotal += CalculoPuntuacionHechizoAgua(ha.getDaño(), ha.getCantidadHeal(), ha.getPresionDelAgua());
	                    }
	                }
	            }

	            System.out.println((i + 1) + ") Mago: " + Magos.get(i).getNombre() + " | Puntuacion Total: " + puntuacionTotal);
	        }
	    }
	}

	
	public int CalculoPuntuacionHechizoFuego( int DañoQuemadura, int DuracionQuemadura) {
		int fuego = 0;
		fuego = DañoQuemadura*DuracionQuemadura;
		return fuego;
	}
	

	
	public int CalculoPuntuacionHechizoTierra( int DañoTierra, int MejoraDefensa) {
		int tierra = 0;
		tierra = (DañoTierra*MejoraDefensa)/2;
		return tierra;
	}

	
	public int CalculoPuntuacionHechizoPlanta( int DañoPlanta, int DuracionStun,int CantidadPlantas) {
		int planta = 0;
		planta = DañoPlanta+(DuracionStun*CantidadPlantas);
		return planta;
	}

	
	public int CalculoPuntuacionHechizoAgua( int DañoAgua, int CantidadCurada, int PresionAgua) {
		int agua = 0;
		agua = (DañoAgua+CantidadCurada+PresionAgua)/2;
		return agua;
	}
	public void AgregarEnArchivo(String dato, String Archivo) {
		try {
			BufferedWriter Dato = new BufferedWriter(new FileWriter(Archivo,true));
			Dato.newLine();
			Dato.write(dato);
			Dato.close();
		}catch(IOException e) {}
	}
	
	
	

}

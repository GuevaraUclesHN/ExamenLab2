package programadelaliganacional.ExamenLab2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
    Equipos e = new Equipos();
    Jugadores j = new Jugadores();
    Scanner lea= new Scanner(System.in);
        int Menu;
        
        do {
        System.out.println("---------------------------------------------");
        System.out.println("1) Agregar Equipo");
        System.out.println("2) Agregar Jugador ");
        System.out.println("3) Reportes");
        System.out.println("4) Salir");
        System.out.println("--------------------------------------------");
        Menu=lea.nextInt();
        switch(Menu){ 
        case 1:
        System.out.println("------------Agregar Equipo-----------------");
        System.out.print    ("-----Nombre Equipo:");String name =lea.next();
        System.out.print    ("-----Cuidad: "); String cuidad = lea.next();
        System.out.print    ("-----Capacidad: ");double dia = lea.nextDouble();
        
        
            try {
               e.addTeam(name, cuidad, dia);
            } catch (IOException ex) {
            
            }
        
break;    
        
        case 2:
        System.out.println("------------Agregar Jugador-----------------");
        e.imprimirTeams();
        
        System.out.print  ("------Codigo del equipo: "); int codeE= lea.nextInt();
            System.out.println(e.nombreEquipo(codeE));
        if (e.findEquipo(codeE)) {
        System.out.print  ("------Nombre del jugador: "); String namesito = lea.next(); 
        System.out.print  ("------Dorsal: ");int dorsal=lea.nextInt();
        System.out.print  ("------Posicion: (P,D,M,S)"); String xd = lea.next().toUpperCase(); char SO = xd.charAt(0);
        System.out.print  ("------Edad: "); int edad = lea.nextInt();
        System.out.print  ("------Nacionalidad: ");String nacio = lea.next();
         
        try {
                j.addPlayer(codeE, namesito, dorsal, SO, edad, nacio);
                } catch (IOException ex) {
                }            
            }
           break;
                   
                case 3:
                    System.out.println("HOla");
                    break;
                case 4: 
        System.out.println("SALIENDO DEL SISTEMA");           
        }}while (Menu!=4); //CIERRE DO WHILE
      

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programadelaliganacional.ExamenLab2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Equipos {
 private RandomAccessFile equiposCode,equipos;
    public Equipos(){
    try{
        new File("equipos/").mkdirs();
        equiposCode= new RandomAccessFile("equipos/equiposCode.LN","rw");
        equipos = new RandomAccessFile("equipos/Equipos.LN","rw");
        initCodes();
        
        }catch(Exception e){
        
        
        }
    }
    private void initCodes() throws IOException{
        if (equiposCode.length()==0) {
            equiposCode.writeInt(1);
            equiposCode.writeInt(1);
        }
    }

    private int getCode(long offset)throws IOException{
equiposCode.seek(offset);
int code=equiposCode.readInt();
equiposCode.seek(offset);
equiposCode.writeInt(code+1);

return code;
}
    
    
    public void addTeam(String nombre,String cuidad,double capacidad) throws IOException{
equipos.seek(equipos.length());
//codigo
int code=getCode(0);
equipos.writeInt(code);
//Nombre del equipo 
equipos.writeUTF(nombre);
//Cuidad
equipos.writeUTF(cuidad);
//Capacidad
equipos.writeDouble(capacidad);
//Cantidad de jugadores
equipos.writeInt(0);
    }
    
public boolean borrarEquipo(int code) throws IOException{
equipos.seek(0);
int codinho;
while(equipos.getFilePointer()<equipos.length()){
codinho=equipos.readInt();
if (codinho==code) {
equipos.seek(equipos.getFilePointer()-4);
equipos.writeInt(0);
//Nombre del equipo 
equipos.writeUTF(null);
//Cuidad
equipos.writeUTF(null);
//Capacidad
equipos.writeDouble(0);
//Cantidad de jugadores
equipos.writeInt(0);
//equipos


return true; 
}else{
equipos.readUTF();
equipos.readUTF();
equipos.readDouble();
equipos.readInt();

}

 }
 return false;
    }
    
public boolean findEquipo(int code) throws IOException{
    equipos.seek(0);  
    int codigo;
    while(equipos.getFilePointer()<equipos.length()){
    codigo=equipos.readInt();
    if (codigo==code) {     
       return true;
        }else{
equipos.readUTF();
equipos.readUTF();
equipos.readDouble();
equipos.readInt();  
     }
    }
    return false;
   }

public long findEquipoPointerNombre(int code) throws IOException{
   equipos.seek(0);
    while(equipos.getFilePointer()<equipos.length()){
    int codigo=equipos.readInt();
     if (codigo==code){
         return equipos.getFilePointer()-4;
    }else{
    equipos.readUTF();
equipos.readUTF();
equipos.readDouble();
equipos.readInt();  
    }
    }
    return 0;
}
public String nombreEquipo(int code) throws IOException{
    String nombre;
    if (findEquipo(code)) {
        equipos.seek(findEquipoPointerNombre(code));
        equipos.readInt();
        nombre = equipos.readUTF();
        return nombre;
   }
return null;
}

public void addJugador(int Code) throws IOException{
equipos.seek(0);
int aux;
while(equipos.getFilePointer()<equipos.length()){
int codigo=equipos.readInt();
     if (codigo==Code){
     equipos.readUTF();
equipos.readUTF();
equipos.readDouble();
aux = equipos.readInt();
equipos.seek(equipos.getFilePointer()-4);
equipos.writeInt(aux+1);    
    }
     else{
equipos.readUTF();
equipos.readUTF();
equipos.readDouble();
equipos.readInt();  
    }
}
}

public void imprimirTeams() throws IOException{
equipos.seek(0);
while(equipos.getFilePointer()<equipos.length()){
int codigo = equipos.readInt();
String name = equipos.readUTF();
String cuidad = equipos.readUTF();
double capacidad =equipos.readDouble();
int players = equipos.readInt();  
System.out.println("[Codigo equipo: "+codigo+"] [Nombre Equipo: "+name+"] [Cuidad: "+cuidad+"]  [Capacidad del estadio: "+capacidad+"]  [Cantidad de jugadores: "+players+"]");
}        
}

public void imprimirTeamsOrden() throws IOException{
equipos.seek(0);
while(equipos.getFilePointer()<equipos.length()){
int codigo = equipos.readInt();
String name = equipos.readUTF();
String cuidad = equipos.readUTF();
double capacidad =equipos.readDouble();
int players = equipos.readInt();


System.out.println("[Codigo equipo: "+codigo+"] [Nombre Equipo: "+name+"] [Cantidad de jugadores: "+players+"]");
}        
}

}


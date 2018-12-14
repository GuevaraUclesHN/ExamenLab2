
package programadelaliganacional.ExamenLab2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Jugadores {
  private RandomAccessFile jugadores,jugadoresXEquipo;
  
public Jugadores(){
try{
        jugadores = new RandomAccessFile("jugadores.LN","rw");        
        }catch(Exception e){
        }
    }

public void addPlayer(int codeTeam,String nombreJugador, int dorsal, char posicion,int edad, String nacionalidad) throws IOException{
Equipos e = new Equipos();    
    jugadores.seek(jugadores.length());
    jugadoresXEquipo = new RandomAccessFile(e.nombreEquipo(codeTeam)+".LN","rw");
  
    if (dorsalExistente(dorsal)==false) {
        
    
    jugadoresXEquipo.seek(jugadoresXEquipo.length());
    jugadoresXEquipo.writeUTF(nombreJugador);
    jugadoresXEquipo.writeInt(dorsal);
    jugadoresXEquipo.writeChar(posicion);
    jugadoresXEquipo.writeInt(edad);
    jugadoresXEquipo.writeUTF(nacionalidad);
    
    jugadores.writeUTF(nombreJugador);
    jugadores.writeInt(dorsal);
    jugadores.writeChar(posicion);
    jugadores.writeInt(edad);
    jugadores.writeUTF(nacionalidad);
    e.addJugador(codeTeam);
    }else{
        System.out.println("Dorsal en uso");}
}
 
    
public boolean dorsalExistente(int dorsal) throws IOException{
jugadoresXEquipo.seek(0);
int dorso;
while(jugadoresXEquipo.getFilePointer()<jugadoresXEquipo.length()){
jugadoresXEquipo.readUTF();
dorso=jugadoresXEquipo.readInt();
    if (dorso==dorsal) {
        return true;
    }
    else{
    jugadoresXEquipo.readChar();
    jugadoresXEquipo.readInt();
    jugadoresXEquipo.readUTF();
    }
    
}
return false;
}



}




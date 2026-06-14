import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Representa un usuario registrado
 * Hereda de Usuario
 * Implementa Archivable
 * @author Rocio Garzon 
 * @version 0.1
 */

public class Lector extends Usuario implements Archivable{

    /**
     * Constructor de objetos del tipo lector
     * @param dni del lector
     * @param nombre del lector 
     * @param edad del lector
     */
    public Lector(Integer dni, String nombre, Integer edad){
        super(dni, nombre, edad);
    }
     
    /**
     * Crea y agrega la informacion del lector a un archivo
     */
    @Override
    public void Archivar() throws IOException{
        FileWriter a = new FileWriter("Lectores", true);
        BufferedWriter b = new BufferedWriter(a);
        b.write(ToString());
        b.newLine();
        b.close();
    }
}
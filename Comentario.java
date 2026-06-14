import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Representa un comentario
 * Implementa Archivable
 * Implementa Encadenable
 * @author Rocio Garzon
 * @version 0.1 
 */

public class Comentario implements Archivable, Encadenable{
    private Integer numero;
    private String texto;
    private Lector lector;

    /**
     * Constructor de objetos del tipo comentario
     * @param numero de comentario
     * @param texto que contenga el comentario
     * @param lector que publico el comentario
     */
    Comentario(Integer numero, String texto, Lector lector){
        this.numero = numero;
        this.texto = texto;
        this.lector = lector;
    }

    /**
     * Retorna el objeto lector que publico el comentario
     * @return lector
     */
    public Lector getLector() {
        return lector;
    }

    /**
     * Retorna el numero de comentario
     * @return numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Retorna el texto que se comenta
     * @return texto
     */
    public String getTexto() {
        return texto;
    }
    
    /**
     * Crea y agrega la informacion del comentario a un archivo de texto
     */
    @Override
    public void Archivar() throws IOException{
        FileWriter a = new FileWriter("Comentarios", true);
        BufferedWriter b = new BufferedWriter(a);
        b.write(ToString());
        b.newLine();
        b.close();
    }

    /**
     * Retorna una cadena con la informacion del comentario
     * @return cadena
     */
    @Override
    public String ToString(){
        return lector.getNombre() + ", " + numero + ", " + texto;
    }
    
}

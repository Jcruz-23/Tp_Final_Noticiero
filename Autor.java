import java.io.*;
/**
 * Representa un autor
 * Hereda de Usuario
 * Implementa Archivable
 * @author Juan Cruz Sanchez Solano
 * @version 0.1
 */
public class Autor extends Usuario implements Archivable{
    private String medio;

    /**
     * Constructor de objetos de tipo autor
     * @param dni del autor
     * @param nombre del autor
     * @param edad del autor
     * @param medio por donde publican los articulos
     */
    public Autor(Integer dni, String nombre, Integer edad, String medio){
        super(dni, nombre, edad);
        if(medio == null || medio.isEmpty()) throw new NullPointerException("medio no puede estar vacio");
        this.medio = medio;
    }

    /**
     * Retorna el medio que utiliza el autor para publicar los articulos
     * @return medio
     */
    public String getMedio() {
        return medio;
    }

    /**
     * Crea y agrega la informacion del autor a un archivo de texto
     */
    @Override
    public void Archivar() throws IOException{
        FileWriter a = new FileWriter("Autores", true);
        BufferedWriter b = new BufferedWriter(a);
        b.write(ToString());
        b.newLine();
        b.close();
    }

    /**
     * Crea una cadena con la informacion del autor
     * @return cadena 
     */
    public String ToStringAutor(){
        return ToString() + ", " + medio;
    }
}

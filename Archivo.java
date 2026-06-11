import java.io.FileWriter;
import java.io.IOException;

public interface Archivo {
    /**
     * Retorna el nombre del archivo donde se va a guardar el objeto.
     * @return nombre del archivo
     */
    String getNombreArchivo();

    /**
     * Retorna el contenido que se va a guardar en el archivo.
     * @return contenido en formato String
     */
    String getContenido();
    
    /**
     * Guarda el contenido del objeto en un archivo de texto
     * @exception IoException si el archivo no abre correctamente
     */
    public default void archivar(){
        try {
            FileWriter fw = new FileWriter(getNombreArchivo() + ".txt", true);
            fw.write(getContenido() + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al archivar: " + e.getMessage());
        }
    }
}
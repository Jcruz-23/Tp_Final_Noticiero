
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Representa una noticia
 * Implementa Archivable
 * Implementa Encadenable
 * @author Juan Cruz Sanchez Solano
 * @version 0.1
 */

public class Noticia implements Archivable, Encadenable{
    private String titulo;
    private String detalle;
    private Autor autor;
    private ArrayList<Comentario> comentarios;
    private Fecha fecha;

    /**
     * Constructor de objetos del tipo noticia
     * @param titulo de la noticia
     * @param detalle es el texto que contiene el articulo escrito por el autor
     * @param autor que escribio la noticia
     * @param fecha en la que se publico
     */
    public Noticia(String titulo, String detalle, Autor autor, Fecha fecha){
        if(titulo == null || titulo.isEmpty()) throw new NullPointerException("titulo no puede estar vacio");
        if(detalle == null || detalle.isEmpty()) throw new NullPointerException("detalle no puede estar vacio");
        if(fecha == null) throw new NullPointerException("fecha no puede estar vacia");
        this.titulo = titulo;
        this.detalle = detalle;
        this.autor = autor;
        this.fecha = fecha;
        comentarios = new ArrayList<Comentario>();
    }

    /**
     * Retorna el objeto autor que escribio la noticia
     * @return autor
     */
    public Autor getAutor() {
        return autor;
    }
    
    /**
     * Retorna el texto que contiene el articulo
     * @return detalle
     */
    public String getDetalle() {
        return detalle;
    }
    
    /**
     * Retorna el titulo de la noticia
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }
    
    /**
     * Retorna la lista de comentarios que se le hicieron a la noticia
     * @return comentarios
     */
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Crea y agrega la informacion de la noticia a un archivo de texto
     */
    @Override
    public void Archivar() throws IOException{
        FileWriter a = new FileWriter("Noticias", true);
        BufferedWriter b = new BufferedWriter(a);
        b.write(ToString());
        b.newLine();
        b.close();
    }

    /**
     * Retorna una cadena con la informacion de la noticia
     * @return cadena
     */
    @Override
    public String ToString(){
        return fecha.ToString() + ", " + titulo + ", "+ autor.getNombre() + ", " + detalle;
    }

    /**
     * Retorna el objeto fecha en el que fue publicada la noticia
     * @return fecha
     */
    public Fecha getFecha() {
        return fecha;
    }
    
    /**
     * Agrega a la lista de comentarios un nuevo objeto comentario
     * @param texto que se comenta
     * @param lector que publica el comentario
     */
    public void registrarComentario(String texto, Lector lector){
        Comentario c = new Comentario(comentarios.size()+1, texto, lector);
        comentarios.add(c);
    }
}

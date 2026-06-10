
import java.util.ArrayList;

public class Noticia {
    private String titulo;
    private String detalle;
    private Autor autor;
    private ArrayList<Comentario> comentarios;
    private Fecha fecha;

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

    public Autor getAutor() {
        return autor;
    }

    
    public String getDetalle() {
        return detalle;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public String ToString(){
        return fecha.toString() + ", " + titulo + ", "+ autor.getNombre() + ", " + detalle;
    }
    
    public void registrarComentario(String texto, Lector lector){
        Comentario c = new Comentario(comentarios.size()+1, texto, lector);
        comentarios.add(c);
    }
}


import java.util.ArrayList;

public class Noticia {
    private String titulo;
    private String detalle;
    private Autor autor;
    private ArrayList<Comentario> comentarios;

    Noticia(String titulo, String detalle, Autor autor){
        this.titulo = titulo;
        this.detalle = detalle;
        this.autor = autor;
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
        return titulo + ", "+ autor.getNombre() + ", " + detalle ;
    }
    
    public void registrarComentario(String texto, Lector lector){
        if (texto == null || texto.isEmpty()) throw new IllegalArgumentException("El comentario no puede estar vacío");
        Comentario c = new Comentario(comentarios.size()+1, texto, lector);
        comentarios.add(c);
    }
}

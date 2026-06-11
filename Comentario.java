public class Comentario {
    private Integer numero;
    private String texto;
    private Lector lector;

    Comentario(Integer numero, String texto, Lector lector){
        this.numero = numero;
        this.texto = texto;
        this.lector = lector;
    }

    public Lector getLector() {
        return lector;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getTexto() {
        return texto;
    }

    public String getNombreArchivo(){
        return "comentarios";
    }

    public String getContenido(){
        return ToString();
    }

    public String ToString(){
        return lector.getNombre() + ", " + numero + ", " + texto;
    }
    
}

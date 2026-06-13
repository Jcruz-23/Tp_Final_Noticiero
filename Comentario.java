
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Comentario implements Archivable, Encadenable{
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

    public void Archivar() throws IOException{
        FileWriter a = new FileWriter("Comentarios", true);
        BufferedWriter b = new BufferedWriter(a);
        b.write(ToString());
        b.newLine();
        b.close();
    }

    public String ToString(){
        return lector.getNombre() + ", " + numero + ", " + texto;
    }
    
}

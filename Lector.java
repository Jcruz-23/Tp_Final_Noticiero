import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Lector extends Usuario implements Archivable{
    public Lector(Integer dni, String nombre, Integer edad){
        super(dni, nombre, edad);
    }

    @Override
    public void Archivar() throws IOException{
        FileWriter a = new FileWriter("Lectores", true);
        BufferedWriter b = new BufferedWriter(a);
        b.write(ToString());
        b.newLine();
        b.close();
    }
}
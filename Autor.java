import java.io.*;

public class Autor extends Usuario implements Archivable{
    private String medio;

    public Autor(Integer dni, String nombre, Integer edad, String medio){
        super(dni, nombre, edad);
        if(medio == null || medio.isEmpty()) throw new NullPointerException("medio no puede estar vacio");
        this.medio = medio;
    }

    public String getMedio() {
        return medio;
    }

    public void Archivar() throws IOException{
        FileWriter a = new FileWriter("Autores", true);
        BufferedWriter b = new BufferedWriter(a);
        b.write(ToString());
        b.newLine();
        b.close();
    }

    public String ToString(){
        return ToString() + ", " + medio;
    }
}

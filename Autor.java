public class Autor extends Usuario{
    private String medio;

    Autor(Integer dni, String nombre, Integer edad, String medio){
        super(dni, nombre, edad);
        this.medio = medio;
    }

    public String getMedio() {
        return medio;
    }

    public String ToString(){
        return getDni() + ", " + getNombre() + ", " + getEdad() + ", " + medio;
    }
}

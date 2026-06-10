public class Autor extends Usuario{
    private String medio;

    public Autor(Integer dni, String nombre, Integer edad, String medio){
        super(dni, nombre, edad);
        if(medio == null || medio.isEmpty()) throw new NullPointerException("medio no puede estar vacio");
        this.medio = medio;
    }

    public String getMedio() {
        return medio;
    }

    public String ToString(){
        return getDni() + ", " + getNombre() + ", " + getEdad() + ", " + medio;
    }
}

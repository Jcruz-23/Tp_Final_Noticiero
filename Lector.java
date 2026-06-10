public class Lector extends Usuario{
    public Lector(Integer dni, String nombre, Integer edad){
        super(dni, nombre, edad);
    }

    @Override
    public Integer getDni() {
        return super.getDni();
    }

    @Override
    public Integer getEdad() {
        return super.getEdad();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }
}
public class Usuario {
    private Integer dni;
    private String nombre;
    private Integer edad;

    Usuario(Integer dni, String nombre, Integer edad){
        if(dni == null) throw new NullPointerException("dni no puede estar vacio");
        if(dni < 1000000 || dni > 99999999) throw new IllegalArgumentException("dni debe estar en el dominio [1000000, 99999999]");
        if(nombre == null || nombre.isEmpty()) throw new NullPointerException("nombre no puede estar vacio");
        if(edad == null) throw new NullPointerException("edad no puede estar vacio");
        if(edad > 100) throw new IllegalArgumentException("Edad no puede ser mayor de 100");
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getDni() {
        return dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }
}

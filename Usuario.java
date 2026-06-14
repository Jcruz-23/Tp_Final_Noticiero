/**
 * Representa un usuario no registrado
 * Implementa Encadenable
 * @author Rocio Garzon
 * @version 0.1
 */
public class Usuario implements Encadenable{
    private  Integer dni;
    private  String nombre;
    private  Integer edad;

    /**
     * COnstructor de objetos del tipo Usuario
     * @param dni del usuario
     * @param nombre del usuario
     * @param edad del usuario
     */
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

    /**
     * Retorna el dni del usuario
     * @return dni
     */
    public Integer getDni() {
        return dni;
    }

    /**
     * Retorna la edad del usuario
     * @return edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Retorna el nombre del usuario
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna una cadena con la informacion del usuario
     * @return cadena
     */
    @Override
    public String ToString(){
        return dni + ", " + nombre + ", " + edad;
    }
}

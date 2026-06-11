public class Lector extends Usuario{
    public Lector(Integer dni, String nombre, Integer edad){
        super(dni, nombre, edad);
    }

   public String getNombreArchivo(){
    return "lectores";
   }

   public String getContenido(){
    return toString();
   }
}
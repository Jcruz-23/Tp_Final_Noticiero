
import java.util.ArrayList;
import java.util.Random;

public class Noticiero {

    private ArrayList<Autor> autores;
    private ArrayList<Lector> lectores;
    private ArrayList<Noticia> noticias;

    public Noticiero(){
        autores = new ArrayList<Autor>();
        lectores = new ArrayList<Lector>();
        noticias = new ArrayList<Noticia>();
    }

    public void registrarLector(String nombre, Integer dni, Integer edad){
        Lector lector = new Lector(dni, nombre, edad);
        lectores.add(lector);
    }

    public void generarNoticia(String titulo, String detalle, Autor autor){
        Fecha fecha = generarFechaRandom();
        Noticia noticia = new Noticia(titulo, detalle, autor, fecha);
        noticias.add(noticia);
    }

    public Autor buscarAutor(Integer dni) throws ParametroNoEncontradoException{
        for(Autor a : autores){
            if(a.getDni().equals(dni)){
                return a;
            }
        }
        throw new ParametroNoEncontradoException("El autor no ha sido encontrado");
    }

    public void listarNoticiasUltimoMes(){
      Fecha fecha = buscarUltimoMes();
      for(Noticia n : noticias){
        if(n.getFecha().getAnio().equals(n.getFecha().getAnio())){
            if(n.getFecha().getMes().equals(n.getFecha().getMes())){
                System.out.println(n.ToString());
                for(Comentario c : n.getComentarios()){
                    System.out.println(c.ToString());
                }
            }
        }
      }
    }

    private Fecha buscarUltimoMes(){
        Integer min_mes = 1;
        Integer max_mes = min_mes;
        Integer min_anio = 2026;
        Integer max_anio = min_anio;
    
        for(Noticia n : noticias){
            if(n.getFecha().getAnio() > max_anio){
                max_anio = n.getFecha().getAnio();
            }
        }
        for(Noticia n : noticias){
            if(n.getFecha().getMes() > max_mes){
                max_mes = n.getFecha().getMes();
            }
        }

        Fecha fecha = new Fecha(1, max_mes, max_anio);
        return fecha;
    }

    public Noticia buscarNoticiaPorAutor(String nombre, Integer dni) throws ParametroNoEncontradoException{
        for(Noticia n : noticias){
            if(n.getAutor().getNombre().equals(nombre)){
                if(n.getAutor().getDni().equals(dni)){
                    return n;
                }
            }
        }
        throw new ParametroNoEncontradoException("No se han encontrado noticias del autor");
    }

    private  Fecha generarFechaRandom(){
        Random ran = new Random();
        Integer mes = ran.nextInt(12-1+1)+1;
        Integer dia = ran.nextInt(31-1+1)+1;
        Integer anio = ran.nextInt(2050-2026+1)+2026;
        Fecha fecha = new Fecha(dia, mes, anio);
        return fecha;
    }

    public void registrarAutor(Integer dni, String nombre, Integer edad, String medio){
        Autor a = new Autor(dni, nombre, edad, medio);
        autores.add(a);
    }

    public void listarNoticiasAnio(Integer anio){
        for (Noticia a : noticias){
            if(anio.equals(a.getFecha().getAnio())) System.out.println(a.ToString());
        }
    }

    public void mostrarNoticia(String titulo) throws ParametroNoEncontradoException{
        Noticia noticia = buscarNoticia(titulo);
        System.out.println(noticia.ToString());
    }

    public Noticia buscarNoticia(String titulo) throws ParametroNoEncontradoException{
        for(Noticia n : noticias){
            if(n.getTitulo().equals(titulo)) return n; 
        }
        throw new ParametroNoEncontradoException("No se ha encontrado la noticia");
    }

}

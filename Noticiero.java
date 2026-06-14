
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Representa el sistema que integra las funcionalidades de cada clase.
 * @author Juan Cruz Sanchez Solano, Rocio Garzon
 * @version 0.1
 */
public class Noticiero {
    
    private ArrayList<Autor> autores;
    private ArrayList<Lector> lectores;
    private ArrayList<Noticia> noticias;

    /**
     * Constructor de objetos del tipo noticiero
     */
    public Noticiero(){
        autores = new ArrayList<Autor>();
        lectores = new ArrayList<Lector>();
        noticias = new ArrayList<Noticia>();
    }

    /**
     * Agrega un usuario a la lista de lectores 
     * @param nombre del usuario
     * @param dni del usuario
     * @param edad del usuario
     * @throws IOException si no se agrega el lector al archivo registro de lectores
     */
    public void registrarLector(String nombre, Integer dni, Integer edad) throws IOException{
        Lector lector = new Lector(dni, nombre, edad);
        lector.Archivar();
        lectores.add(lector);
    }

    /**
     * Crea la noticia a publicar 
     * @param titulo de la noticia
     * @param detalle que contiene la noticia
     * @param autor que escribio la noticia
     * @throws IOException si no se agrega la noticia al archivo registro de noticias
     */
    public void generarNoticia(String titulo, String detalle, Autor autor) throws IOException{
        Fecha fecha = generarFechaRandom();
        Noticia noticia = new Noticia(titulo, detalle, autor, fecha);
        noticia.Archivar();
        noticias.add(noticia);
    }

    /**
     * Busca un autor por su dni
     * @param dni del autor
     * @return el autor encontrado
     * @throws ParametroNoEncontradoException si no encuentra el autor
     */
    public Autor buscarAutor(Integer dni) throws ParametroNoEncontradoException{
        for(Autor a : autores){
            if(a.getDni().equals(dni)){
                return a;
            }
        }
        throw new ParametroNoEncontradoException("El autor no ha sido encontrado");
    }

    /**
     * Lista las noticias que se publicaron por ultima vez
     */
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

    /**
     * Busca las noticias de un autor especifico
     * @param nombre del autor
     * @param dni del autor
     * @return lista de noticias encontradas
     * @throws ParametroNoEncontradoException si no se encuentran noticias del autor
     */
    public ArrayList<Noticia> buscarNoticiaPorAutor(String nombre, Integer dni) throws ParametroNoEncontradoException{
        ArrayList<Noticia> noticias_encontradas = new ArrayList<>();
        for(Noticia n : noticias){
            if(n.getAutor().getNombre().equals(nombre)){
                if(n.getAutor().getDni().equals(dni)){
                    noticias_encontradas.add(n);
                    return noticias_encontradas;
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

    /**
     * Agrega un autor a la lista de autores
     * @param dni del autor
     * @param nombre del autor
     * @param edad del autor
     * @param medio en el que se publican las noticias del autor
     * @throws IOException si no se agrea el autor al archivo registro de autores
     */
    public void registrarAutor(Integer dni, String nombre, Integer edad, String medio) throws IOException{
        Autor a = new Autor(dni, nombre, edad, medio);
        a.Archivar();
        autores.add(a);
    }

    /**
     * Lista las noticias que se publicaron en un año especifico
     * @param anio a buscar
     */
    public void listarNoticiasAnio(Integer anio){
        for (Noticia a : noticias){
            if(anio.equals(a.getFecha().getAnio())) System.out.println(a.ToString());
        }
    }

    /**
     * Muestra una noticia 
     * @param titulo de la noticia que desee verse
     */
    public void mostrarNoticia(String titulo) throws ParametroNoEncontradoException{
        Noticia noticia = buscarNoticia(titulo);
        System.out.println(noticia.ToString());
        for(Comentario c : buscarNoticia("Empieza el mundial").getComentarios()){
            System.out.println(c.ToString());
        }

    }

    /**
     * Busca una noticia por su titulo
     * @param titulo de la noticia
     * @return noticia encontrada
     * @throws ParametroNoEncontradoException si no se encuentra ninguna noticia
     */
    public Noticia buscarNoticia(String titulo) throws ParametroNoEncontradoException{
        for(Noticia n : noticias){
            if(n.getTitulo().equals(titulo)) return n; 
        }
        throw new ParametroNoEncontradoException("No se ha encontrado la noticia");
    }

    /**
     * Busca un lector 
     * @param dni del lector a buscar
     * @return lector encontrado
     * @throws ParametroNoEncontradoException si no se encuentra el lector
     */ 
    public Lector buscarLector(Integer dni) throws ParametroNoEncontradoException{
        for(Lector l : lectores){
            if(l.getDni().equals(dni)){
                return l;
            }
        }
        throw new ParametroNoEncontradoException("El lector no ha sido encontrado");
    }

}

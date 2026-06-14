import java.io.IOException;
import java.util.ArrayList;


public class MainPruebaIntegral {
    public static void main(String[] args) {

        Noticiero noticiero = new Noticiero();
        try {

        noticiero.registrarAutor(12345678, "Farid Darrull", 20, "La Nacion");
        noticiero.registrarAutor(87654321, "Martin Suarez", 78, "Infobae");

        noticiero.registrarLector("Guada Bravo", 11111111, 19);
        noticiero.registrarLector("Rocio Garzon", 22222222, 20);

            Autor autor1 = noticiero.buscarAutor(12345678);
            Autor autor2 = noticiero.buscarAutor(87654321);

            noticiero.generarNoticia("Se acabo el cafe", "Los empleados reportaron niveles historicos de mal humor antes del mediodia", autor1);
            noticiero.generarNoticia("Empieza el mundial", "Mexico le gano 2-0 a Sudafrica en el partido inaugural del mundial 2026", autor2);

            Noticia n1 = noticiero.buscarNoticia("Se acabo el cafe");
            Noticia n2 = noticiero.buscarNoticia("Empieza el mundial");

            Lector lector1 = noticiero.buscarLector(11111111);
            Lector lector2 = noticiero.buscarLector(22222222);

            n1.registrarComentario("jajajaja", lector1);
            n1.registrarComentario("Aguante el mate", lector2);
            n2.registrarComentario("Lo mejor del partido fue cuando terminó", lector2);
            n2.registrarComentario("Cierren la pagina", lector1);

            System.out.println("=== Noticia 1 ===");
            System.out.println(n1.ToString());
            for (Comentario c : n1.getComentarios()) {
                System.out.println("  Comentario: " + c.ToString());
            }

            System.out.println("\n=== Buscar noticia por autor ===");
            ArrayList<Noticia> autorEncontrado = noticiero.buscarNoticiaPorAutor("Farid Darrull", 12345678);
            for (Noticia n: autorEncontrado) {
                System.out.println(n.ToString());
            }

            System.out.println("\n=== Noticias generadas en 2026 ===");
            noticiero.listarNoticiasAnio(2026);

            System.out.println("\n=== Noticias del ultimo mes ===");
            noticiero.listarNoticiasUltimoMes();

            System.out.println("\n=== Mostrar noticia ===");
            noticiero.mostrarNoticia("Empieza el mundial");
            
            System.out.println("\n=== Excepcion: autor no encontrado ===");
            noticiero.buscarAutor(99999999);

        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IllegalArgumentException exc) {
            System.out.println("Error: " + exc.getMessage());
        } catch (ParametroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException exce){
            System.out.println("Error: " + exce.getMessage());
        }
    }
}
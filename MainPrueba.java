public class MainPrueba {
    public static void main(String[] args) {

        Noticiero noticiero = new Noticiero();

        noticiero.registrarAutor(12345678, "Farid Darrull", 20, "La Nacion");
        noticiero.registrarAutor(87654321, "Martin Suarez", 78, "Infobae");

        noticiero.registrarLector("Guada Bravo", 11111111, 19);
        noticiero.registrarLector("Rocio Garzon", 22222222, 20);

        try {
            Autor autor1 = noticiero.buscarAutor(12345678);
            Autor autor2 = noticiero.buscarAutor(87654321);

            noticiero.generarNoticia("Se acabo el cafe", "Los empleados reportaron niveles historicos de mal humor antes del mediodia", autor1);
            noticiero.generarNoticia("Empieza el mundial", "Mexico le gano 2-0 a Sudafrica en el partido inaugural del mundial 2010", autor2);

            Noticia n1 = noticiero.buscarNoticia("Se acabo el cafe");
            Noticia n2 = noticiero.buscarNoticia("Empieza el mundial");

            Lector lector1 = noticiero.buscarLector(11111111);
            Lector lector2 = noticiero.buscarLector(22222222);

            n1.registrarComentario("jajajaja", lector1);
            n1.registrarComentario("Lo mejor del partido fue cuando terminó", lector2);
            n2.registrarComentario("Aguante el mate", lector1);
            n2.registrarComentario("Cierren la pagina", lector2);

            System.out.println("=== Noticia 1 ===");
            System.out.println(n1.ToString());
            for (Comentario c : n1.getComentarios()) {
                System.out.println("  Comentario: " + c.ToString());
            }

            System.out.println("\n=== Buscar por titulo ===");
            Noticia noticiaEncontrada = noticiero.buscarNoticia("Se acabo el cafe");
            System.out.println(noticiaEncontrada.ToString());

            System.out.println("\n=== Buscar noticia por autor ===");
            Noticia autorEncontrado = noticiero.buscarNoticiaPorAutor("Farid Darrull", 12345678);
            System.out.println(autorEncontrado.ToString());

            System.out.println("\n=== Noticias generadas en 2026 ===");
            noticiero.listarNoticiasAnio(2026);

            System.out.println("\n=== Noticias del ultimo mes ===");
            noticiero.listarNoticiasUltimoMes();

            System.out.println("\n=== Mostrar noticia ===");
            noticiero.mostrarNoticia("Empieza el mundial");

            System.out.println("\n=== Excepcion: autor no encontrado ===");
            noticiero.buscarAutor(99999999);

        } catch (ParametroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NullPointerException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IllegalArgumentException exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }
}
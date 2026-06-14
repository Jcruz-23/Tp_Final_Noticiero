/**
 * Excepcion si no se encuentra un parametro
 * Hereda de Exception
 * @author Rocio Garzon 
 * @version 0.1
 */
public class ParametroNoEncontradoException extends Exception {

    /**
     * Constructor de objetos del tipo ParametroNoEncontradoException
     * @param mensaje de la causa de la excepcion
     */
    public ParametroNoEncontradoException(String mensaje){
        super(mensaje);
    }
}

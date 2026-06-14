/**
 * Representa una fecha.
 * @author Juan Cruz Sanchez Solano
 * @version 0.1
 */ 
public class Fecha{
    private Integer dia;
    private Integer mes;
    private Integer anio;

    /**
     * Constructor de objetos del tipo Fecha
     * @param dia
     * @param mes
     * @param anio
     */
    public Fecha(Integer dia, Integer mes, Integer anio){
        if(dia == null) throw new NullPointerException("dia no puede estar vacio");
        if(mes == null) throw new NullPointerException("mes no puede estar vacio");
        if(anio == null) throw new NullPointerException("anio no puede estar vacio");
        if(dia < 1 || dia > 31) throw new IllegalArgumentException("dia debe estar en el dominio [1,31]");
        if(mes < 1 || mes > 12) throw new IllegalArgumentException("mes debe estar en el dominio [1,12]");
        if(anio < 2026 || anio > 2050) throw new IllegalArgumentException("año debe estar en el dominio [2026,2050]");
        this.dia = dia;
        this.mes = mes;
        this. anio = anio;
    }

    /**
     * Retorna el año de la fecha
     * @return año
     */
    public Integer getAnio() {
        return anio;
    }

    /**
     * Retorna el dia de la fecha 
     * @return dia
     */
    public Integer getDia() {
        return dia;
    }

    /**
     * Retorna el mes de la fecha
     * @return mes
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * Retorna los datos de la fecha en una cadena
     * @return cadena con datos 
     */
    public String ToString(){
        return dia + "," + mes + "," + anio;
    }
}
public class Fecha{
    private Integer dia;
    private Integer mes;
    private Integer anio;

    public Fecha(Integer dia, Integer mes, Integer anio){
        this.dia = dia;
        this.mes = mes;
        this. anio = anio;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    public String ToString(){
        return dia + "," + mes + "," + anio;
    }
}
public class Fecha{
    private Integer dia;
    private Integer mes;
    private Integer anio;

    public Fecha(Integer dia, Integer mes, Integer anio){
        if(dia == null) throw new NullPointerException("dia no puede estar vacio");
        if(mes == null) throw new NullPointerException("mes no puede estar vacio");
        if(anio == null) throw new NullPointerException("anio no puede estar vacio");
        if(dia < 1 || dia > 31) throw new IllegalArgumentException("dia debe estar en el dominio [1,31]");
        if(mes < 1 || dia > 12) throw new IllegalArgumentException("mes debe estar en el dominio [1,12]");
        if(dia < 2010 || dia > 2030) throw new IllegalArgumentException("año debe estar en el dominio [2026,2050]");
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
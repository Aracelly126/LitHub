package Clases;

public class Prestamo {

    private int codigo;
    private String codLib;
    private String nomUsu;
    private String fecIni;
    private String fecDev;
    private String estado;

    public Prestamo() {
    }

    public Prestamo(int codigo, String codLib, String nomUsu, String fecIni, String fecDev, String estado) {
        this.codigo = codigo;
        this.codLib = codLib;
        this.nomUsu = nomUsu;
        this.fecIni = fecIni;
        this.fecDev = fecDev;
        this.estado = estado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodLib(String codLib) {
        this.codLib = codLib;
    }

    public String getCodLib() {
        return this.codLib;
    }

    public void setNomUsu(String nomUsu) {
        this.nomUsu = nomUsu;
    }

    public String getNomUsu() {
        return this.nomUsu;
    }

    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getFecIni() {
        return this.fecIni;
    }

    public void setFecDev(String fecDev) {
        this.fecDev = fecDev;
    }

    public String getFecDev() {
        return this.fecDev;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

}

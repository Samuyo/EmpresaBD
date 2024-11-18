package Modelo;

public class Empleado_Proyecto {
    private String nss_empregado;
    private int num_proyecto;
    private int horas_semanales;

    public Empleado_Proyecto(String nss_empregado, int num_proyecto, int horas_semanales) {
        this.nss_empregado = nss_empregado;
        this.num_proyecto = num_proyecto;
        this.horas_semanales = horas_semanales;
    }

    public String getNss_empregado() {
        return nss_empregado;
    }

    public void setNss_empregado(String nss_empregado) {
        this.nss_empregado = nss_empregado;
    }

    public int getNum_proyecto() {
        return num_proyecto;
    }

    public void setNum_proyecto(int num_proyecto) {
        this.num_proyecto = num_proyecto;
    }

    public int getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(int horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    @Override
    public String toString() {
        return "Empleado_Proyecto{" +
                "nss_empregado='" + nss_empregado + '\'' +
                ", num_proyecto=" + num_proyecto +
                ", horas_semanales=" + horas_semanales +
                '}';
    }
}

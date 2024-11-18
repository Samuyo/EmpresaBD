package Modelo;

import java.util.Date;

public class Departamento {
    private int num_departamento;
    private String nombre_departamento;
    private String NSS_dirige;
    private Date fecha_departamento;

    public Departamento(int num_departamento, String nombre_departamento, String NSS_dirige, Date fecha_departamento) {
        this.num_departamento = num_departamento;
        this.nombre_departamento = nombre_departamento;
        this.NSS_dirige = NSS_dirige;
        this.fecha_departamento = fecha_departamento;
    }

    public int getNum_departamento() {
        return num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        this.num_departamento = num_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public String getNSS_dirige() {
        return NSS_dirige;
    }

    public void setNSS_dirige(String NSS_dirige) {
        this.NSS_dirige = NSS_dirige;
    }

    public Date getFecha_departamento() {
        return fecha_departamento;
    }

    public void setFecha_departamento(Date fecha_departamento) {
        this.fecha_departamento = fecha_departamento;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "num_departamento=" + num_departamento +
                ", nombre_departamento='" + nombre_departamento + '\'' +
                ", NSS_dirige='" + NSS_dirige + '\'' +
                ", fecha_departamento=" + fecha_departamento +
                '}';
    }
}
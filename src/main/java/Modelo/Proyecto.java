package Modelo;

public class Proyecto {
    private int numProyecto;
    private String nombre_proyecto;
    private String lugar;
    private int num_departamento;

    public Proyecto(int numProyecto, String nombre_proyecto, String lugar, int num_departamento) {
        this.numProyecto = numProyecto;
        this.nombre_proyecto = nombre_proyecto;
        this.lugar = lugar;
        this.num_departamento = num_departamento;
    }

    public int getNumProyecto() {
        return numProyecto;
    }

    public void setNumProyecto(int numProyecto) {
        this.numProyecto = numProyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public int getNum_departamento() {
        return num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        this.num_departamento = num_departamento;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "numProyecto=" + numProyecto +
                ", nombre_proyecto='" + nombre_proyecto + '\'' +
                ", lugar='" + lugar + '\'' +
                ", num_departamento=" + num_departamento +
                '}';
    }
}

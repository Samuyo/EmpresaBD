package Modelo;

import java.util.Date;

public class Empleado {
    private String nss;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String calle;
    private int numero_calle;
    private String piso;
    private String cp;
    private String Localidad;
    private Date fecha_nacimiento;
    private float salario;
    private char sexo;
    private String nss_supervisa;
    private int num_departamento_preferente;

    public Empleado(String nss, String nombre,String apellido1, String apellido2, String calle, int numero_calle, String piso, String cp,String Localidad, Date fecha_nacimiento, float salario, char sexo, String nss_supervisa, int num_departamento_preferente) {
        this.nss = nss;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.calle = calle;
        this.piso = piso;
        this.numero_calle = numero_calle;
        this.cp = cp;
        this.Localidad = Localidad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
        this.sexo = sexo;
        this.nss_supervisa = nss_supervisa;
        this.num_departamento_preferente = num_departamento_preferente;
    }
    public String getNss() {
        return nss;
    }
    public void setNss(String nss) {
        this.nss = nss;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero_calle() {
        return numero_calle;
    }

    public void setNumero_calle(int numero_calle) {
        this.numero_calle = numero_calle;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getNss_supervisa() {
        return nss_supervisa;
    }

    public void setNss_supervisa(String nss_supervisa) {
        this.nss_supervisa = nss_supervisa;
    }

    public int getNum_departamento_preferente() {
        return num_departamento_preferente;
    }

    public void setNum_departamento_preferente(int num_departamento_preferente) {
        this.num_departamento_preferente = num_departamento_preferente;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nss='" + nss + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", calle='" + calle + '\'' +
                ", numero_calle=" + numero_calle +
                ", piso='" + piso + '\'' +
                ", cp='" + cp + '\'' +
                ", Localidad='" + Localidad + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", salario=" + salario +
                ", sexo=" + sexo +
                ", nss_supervisa='" + nss_supervisa + '\'' +
                ", num_departamento_preferente=" + num_departamento_preferente +
                '}';
    }
}

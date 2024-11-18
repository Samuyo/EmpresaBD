package Modelo;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/BD_EMPRESA";
    private static final String USER = "tu_usuario"; // Cambia por tu usuario
    private static final String PASSWORD = "tu_contraseña"; // Cambia por tu contraseña

    //2.1: Actualización de datos utilizando a interface Statement
    // Método para aumentar el salario de los empleados de un departamento
    public void aumentarSalarioPorDepartamento(float aumento, String nombreDepartamento) {
        String sql = "UPDATE EMPREGADO e " +
                "JOIN DEPARTAMENTO d ON e.NUM_DEPARTAMENTO_PREFERENTE = d.NUM_DEPARTAMENTO " +
                "SET e.SALARIO = e.SALARIO + ? " +
                "WHERE d.NOME_DEPARTAMENTO = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setFloat(1, aumento);
            pstmt.setString(2, nombreDepartamento);
            pstmt.executeUpdate();
            System.out.println("Salario aumentado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para insertar un nuevo departamento
    public void insertarNovoDepartamento(int numDepartamento, String nomeDepartamento, String nssDirige) {
        String sql = "INSERT INTO DEPARTAMENTO (NUM_DEPARTAMENTO, NOME_DEPARTAMENTO, NSS_DIRIGE, DATA_DIRECCION) " +
                "VALUES (?, ?, ?, CURDATE())";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numDepartamento);
            pstmt.setString(2, nomeDepartamento);
            pstmt.setString(3, nssDirige);
            pstmt.executeUpdate();
            System.out.println("Departamento insertado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para borrar un empleado de un proyecto
    public void borrarEmpregadoDeProxecto(String nssEmpregado, int numProxecto) {
        String sql = "DELETE FROM EMPREGADO_PROXECTO WHERE NSS_EMPREGADO = ? AND NUM_PROXECTO = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nssEmpregado);
            pstmt.setInt(2, numProxecto);
            pstmt.executeUpdate();
            System.out.println("Empleado borrado del proyecto con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //2.2. Consulta de datos utilizando a interface Statement.
    // Método para visualizar información de empleados en una localidad específica
    public void visualizarEmpregadosPorLocalidade(String localidade) {
        String sql = "SELECT e.NOME, e.APELIDO_1, e.APELIDO_2, e.LOCALIDADE, e.SALARIO, e.DATA_NACEMENTO, " +
                "s.NOME AS NOME_XEFE, d.NOME_DEPARTAMENTO " +
                "FROM EMPREGADO e " +
                "LEFT JOIN EMPREGADO s ON e.NSS_SUPERVISA = s.NSS " +
                "JOIN DEPARTAMENTO d ON e.NUM_DEPARTAMENTO_PREFERENTE = d.NUM_DEPARTAMENTO " +
                "WHERE e.LOCALIDADE = '" + localidade + "'";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("NOME");
                String apelido1 = rs.getString("APELIDO_1");
                String apelido2 = rs.getString("APELIDO_2");
                String localidadeEmpregado = rs.getString("LOCALIDADE");
                float salario = rs.getFloat("SALARIO");
                String dataNacemento = rs.getString("DATA_NACEMENTO");
                String nomeXefe = rs.getString("NOME_XEFE");
                String nomeDepartamento = rs.getString("NOME_DEPARTAMENTO");

                System.out.printf("Nome: %s %s %s, Localidade: %s, Salario: %.2f, Data Nacimento: %s, Xefe: %s, Departamento: %s%n",
                        nome, apelido1, apelido2, localidadeEmpregado, salario, dataNacemento, nomeXefe, nomeDepartamento);
            }
        } catch (SQLException e) {
            System.err.println("Error al visualizar empleados: " + e.getMessage());
        }
    }


    //2.3. Actualización de datos utilizando a interface PreparedStatement.
    // Método para cambiar el departamento que controla un proyecto
    public void cambiarDepartamentoProyecto(String nombreDepartamento, String nombreProyecto) {
        String sql = "UPDATE PROXECTO SET NUM_DEPARTAMENTO = (SELECT NUM_DEPARTAMENTO FROM DEPARTAMENTO WHERE NOME_DEPARTAMENTO = ?) WHERE NOME_PROXECTO = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombreDepartamento);
            pstmt.setString(2, nombreProyecto);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Departamento cambiado con éxito para el proyecto: " + nombreProyecto);
            } else {
                System.out.println("No se encontró el proyecto o el departamento.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cambiar el departamento del proyecto: " + e.getMessage());
        }
    }

    // Método para insertar un nuevo proyecto
    public void insertarNovoProxecto(Proyecto proyecto) {
        String sql = "INSERT INTO PROXECTO (NUM_PROXECTO, NOME_PROXECTO, LUGAR, NUM_DEPARTAMENTO) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, proyecto.getNumProyecto());
            pstmt.setString(2, proyecto.getNombre_proyecto());
            pstmt.setString(3, proyecto.getLugar());
            pstmt.setInt(4, proyecto.getNum_departamento());
            pstmt.executeUpdate();
            System.out.println("Proyecto insertado con éxito: " + proyecto.getNombre_proyecto());
        } catch (SQLException e) {
            System.err.println("Error al insertar el proyecto: " + e.getMessage());
        }
    }

    // Método para borrar un proyecto
    public void borrarProxecto(int projectNumber) {
        String sqlDeleteProject = "DELETE FROM PROXECTO WHERE NUM_PROXECTO = ?";
        String sqlDeleteAssignments = "DELETE FROM EMPREGADO_PROXECTO WHERE NUM_PROXECTO = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmtDeleteAssignments = conn.prepareStatement(sqlDeleteAssignments);
             PreparedStatement pstmtDeleteProject = conn.prepareStatement(sqlDeleteProject)) {

            // Primero, borrar las asignaciones de empleados al proyecto
            pstmtDeleteAssignments.setInt(1, projectNumber);
            pstmtDeleteAssignments.executeUpdate();

            // Luego, borrar el proyecto
            pstmtDeleteProject.setInt(1, projectNumber);
            int rowsAffected = pstmtDeleteProject.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Proyecto borrado con éxito: " + projectNumber);
            } else {
                System.out.println("No se encontró el proyecto para borrar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al borrar el proyecto: " + e.getMessage());
        }
    }


    // 2.4. Consulta de datos utilizando a interface PreparedStatement.
}

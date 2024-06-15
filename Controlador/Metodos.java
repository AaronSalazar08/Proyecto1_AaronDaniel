package Controlador;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


import javax.swing.JOptionPane;

import Vista.AcercaNosotros;
import Vista.LoginAdmin;
import Vista.MenuPrimeraVista;
import Vista.VentanaInformacionPaciente;
import Vista.VentanaOpcionesAdministrativo;


public class Metodos {

    private LoginAdmin ventanaLogin;
    private AcercaNosotros ventanaAcercaNosotros;
    private MenuPrimeraVista ventanaPrincipal;
    private VentanaInformacionPaciente ventanaRegistroPaciente;
    private VentanaOpcionesAdministrativo ventanaAdministrador;

    public Metodos(LoginAdmin ventanaLogin, AcercaNosotros ventanaAcercaNosotros, MenuPrimeraVista ventanaPrincipal,
            VentanaInformacionPaciente ventanaRegistroPaciente, VentanaOpcionesAdministrativo ventanaAdministrador) {
        this.ventanaLogin = ventanaLogin;
        this.ventanaAcercaNosotros = ventanaAcercaNosotros;
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaRegistroPaciente = ventanaRegistroPaciente;
        this.ventanaAdministrador = ventanaAdministrador;
    }

    public void Login_Principal() {

        String entradaUsuario = ventanaLogin.usuario_txt.getText().trim();
        char[] contrasena = ventanaLogin.clave_psw.getPassword();
        String contrasenaString = new String(contrasena);

        Map<String, String> credencialesValidas = new HashMap<>();
        credencialesValidas.put("a", "1");

        if (entradaUsuario.isEmpty() || contrasenaString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos a llenar no estén vacíos");
            return;
        }

        if (credencialesValidas.containsKey(entradaUsuario)
                && credencialesValidas.get(entradaUsuario).equals(contrasenaString)) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + entradaUsuario);
            ventanaLogin.setVisible(false);
            ventanaPrincipal.setVisible(true);

            // Else en caso de que las credenciales sean incorrectas

        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }

    }

    public void Principal_Registro() {

        ventanaPrincipal.setVisible(false);
        ventanaRegistroPaciente.setVisible(true);
    }

    public void Registro_Principal() {

        ventanaRegistroPaciente.setVisible(false);
        ventanaPrincipal.setVisible(true);
    }

    public void Principal_Administrador() {

        ventanaPrincipal.setVisible(false);
        ventanaAdministrador.setVisible(true);
    }

    public void Administrador_Principal() {

        ventanaAdministrador.setVisible(false);
        ventanaPrincipal.setVisible(true);
    }

    public void Principal_AcercaNosotros() {

        ventanaPrincipal.setVisible(false);
        ventanaAcercaNosotros.setVisible(true);
    }

    public void AcercaNosotros_Principal() {

        ventanaAcercaNosotros.setVisible(false);
        ventanaPrincipal.setVisible(true);
    }

    public void SalirAplicacion() {

        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de que quieres salir del programa? ",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {

            System.exit(0);
        }

    }

    public void EliminarElementos() {

        String cedula = ventanaAdministrador.cedula_txt.getText().trim();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true", "root",
                    "Proverbios18.22");
            con.setAutoCommit(true);

            String sqlEliminar = "DELETE FROM pacientes where Cedula= cedula;";
            String sqlMostrar = "SELECT * FROM pacientes;";

            stmt = con.createStatement();
            int exito = stmt.executeUpdate(sqlEliminar);
            System.out.println("valor: " + exito);
            if (exito > 0) {
                rs = stmt.executeQuery(sqlMostrar);
                // displayRow("estudiantes", rs);
            } else
                System.out.print("No se encontr  el carnet a eliminar");

        } catch (Exception e) {
            System.out.print("Se ejecut  la excepci n....");
            e.printStackTrace();
        }

        finally {
            if (rs != null)
                try {
                    rs.close();
                } catch (Exception e) {
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            if (con != null)
                try {
                    con.close();
                } catch (Exception e) {
                }
        }
    }

    private static void displayRow(String title, ResultSet rs) {
        try {
           System.out.println(title);
           while (rs.next()) {
              System.out.println("Carnet--> "+rs.getString("carnet") + " Nombre--> " + rs.getString("nombre1"));
              System.out.println();
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
     }

}

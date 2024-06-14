package Controlador;

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

    public void Principal_Registro (){

        ventanaPrincipal.setVisible(false);
        ventanaRegistroPaciente.setVisible(true);
    }

    public void Registro_Principal (){

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

            ventanaPrincipal.dispose();
        }

    }

}

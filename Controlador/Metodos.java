package Controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import Vista.AcercaNosotros;
import Vista.EditarPaciente;
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
    private EditarPaciente ventanaEditar;

    public Metodos(LoginAdmin ventanaLogin, AcercaNosotros ventanaAcercaNosotros, MenuPrimeraVista ventanaPrincipal,
            VentanaInformacionPaciente ventanaRegistroPaciente, VentanaOpcionesAdministrativo ventanaAdministrador, EditarPaciente ventanaEditar) {
        this.ventanaLogin = ventanaLogin;
        this.ventanaAcercaNosotros = ventanaAcercaNosotros;
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaRegistroPaciente = ventanaRegistroPaciente;
        this.ventanaAdministrador = ventanaAdministrador;
        this.ventanaEditar = ventanaEditar;
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

    public void Administrador_Editar (){

        ventanaAdministrador.setVisible(false);
        ventanaEditar.setVisible(true);
        
    }

    public void Editar_Administrador (){

        ventanaEditar.setVisible(false);
        ventanaAdministrador.setVisible(true);
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

    public void InsertarElementos (){

        //Creacion de instancia para volver al menú principal 
        String entradaNombrePaciente = ventanaRegistroPaciente.nombrePacienteTxt.getText().trim();
        String entradaApellido = ventanaRegistroPaciente.apellidoPacienteTxt.getText().trim();
        String entradaCedulaPaciente = ventanaRegistroPaciente.cedulaPacienteTxt.getText().trim();
        String entradaEdadPaciente = ventanaRegistroPaciente.EdadPacienteTxt.getText().trim();
        String transtornoSeleccionado = String.valueOf(ventanaRegistroPaciente.comboTranstorno.getSelectedItem());
        boolean masculinoSeleccionado = ventanaRegistroPaciente.botonMasculino.isSelected();
        boolean femeninoSeleccionado = ventanaRegistroPaciente.botonFemenino.isSelected();
        Connection con = null;
        ResultSet rs = null;
        int exito = 0;

        // Validate input fields
        if (entradaNombrePaciente.isEmpty() ||entradaApellido.isEmpty()|| entradaEdadPaciente.isEmpty() || entradaCedulaPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos a rellenar no estén vacíos");
            return;
        }

        // Convert age to integer
        int edadPaciente;
        try {
            edadPaciente = Integer.parseInt(entradaEdadPaciente);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor válido para la edad");
            ventanaRegistroPaciente.EdadPacienteTxt.setText("");
            return;
        }

        // Validate gender selection
        if (!masculinoSeleccionado && !femeninoSeleccionado) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione el sexo del paciente.");
            return;
        }

        // Determine patient's sex
        String sexoPaciente = masculinoSeleccionado ? "Masculino" : "Femenino";

        // Prepare SQL statement for inserting record
        String SQL = "INSERT INTO paciente (nombre, apellido, cedula, edad, transtorno, sexo) VALUES ('" + entradaNombrePaciente + "', '" + entradaApellido + "', " + entradaCedulaPaciente + ", " + edadPaciente + ", '" + transtornoSeleccionado + "', '" + sexoPaciente + "');";

        // Establish connection with database
        try {

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrosolissalazar?verifyServerCertificate=false&useSSL=true", "root", "091623");
                Statement stmt = con.createStatement();
            // Execute SQL statement
             exito = stmt.executeUpdate(SQL);

            // Process the result of the query
            if (exito != 0) {
                JOptionPane.showMessageDialog(null, "Registrado exitosamente");

                // Clear input fields
                ventanaRegistroPaciente.nombrePacienteTxt.setText("");
                ventanaRegistroPaciente.apellidoPacienteTxt.setText("");
                ventanaRegistroPaciente.cedulaPacienteTxt.setText("");
                ventanaRegistroPaciente.EdadPacienteTxt.setText("");
                ventanaRegistroPaciente.comboTranstorno.setSelectedIndex(0);
                ventanaRegistroPaciente.botonMasculino.setSelected(false);
                ventanaRegistroPaciente.botonFemenino.setSelected(false);

                // (Optional) Display newly created record
                // displayRow("paciente", stmt.executeQuery("SELECT * FROM paciente"));

            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el paciente");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        }

    }

    public void actualizarElementos() {
        // Crear instancia para volver al menú principal
        String entradaNombrePaciente = ventanaRegistroPaciente.nombrePacienteTxt.getText().trim();
        String entradaApellido = ventanaRegistroPaciente.apellidoPacienteTxt.getText().trim();
        String entradaCedulaPaciente = ventanaRegistroPaciente.cedulaPacienteTxt.getText().trim();
        String entradaEdadPaciente = ventanaRegistroPaciente.EdadPacienteTxt.getText().trim();
        String transtornoSeleccionado = String.valueOf(ventanaRegistroPaciente.comboTranstorno.getSelectedItem());
        boolean masculinoSeleccionado = ventanaRegistroPaciente.botonMasculino.isSelected();
        boolean femeninoSeleccionado = ventanaRegistroPaciente.botonFemenino.isSelected();
        Connection con = null;
        int exito = 0;
    
        // Validar campos de entrada
        if (entradaNombrePaciente.isEmpty() || entradaApellido.isEmpty() || entradaEdadPaciente.isEmpty() || entradaCedulaPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos a rellenar no estén vacíos");
            return;
        }
    
        // Convertir edad a entero
        int edadPaciente;
        try {
            edadPaciente = Integer.parseInt(entradaEdadPaciente);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor válido para la edad");
            ventanaRegistroPaciente.EdadPacienteTxt.setText("");
            return;
        }
    
        // Validar selección de género
        if (!masculinoSeleccionado && !femeninoSeleccionado) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione el sexo del paciente.");
            return;
        }
    
        // Determinar el sexo del paciente
        String sexoPaciente = masculinoSeleccionado ? "Masculino" : "Femenino";
    
        // Preparar la consulta SQL para actualizar el registro
        String SQL = "UPDATE pacientes SET nombre = ?, apellido = ?, edad = ?, transtorno = ?, sexo = ? WHERE cedula = ?";
    
        // Establecer la conexión con la base de datos
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root", "Proverbios18.22");
            PreparedStatement pstmt = con.prepareStatement(SQL);
            
            // Asignar valores a los parámetros de la consulta
            pstmt.setString(1, entradaNombrePaciente);
            pstmt.setString(2, entradaApellido);
            pstmt.setInt(3, edadPaciente);
            pstmt.setString(4, transtornoSeleccionado);
            pstmt.setString(5, sexoPaciente);
            pstmt.setString(6, entradaCedulaPaciente);
    
            // Ejecutar la consulta SQL
            exito = pstmt.executeUpdate();
    
            // Procesar el resultado de la consulta
            if (exito != 0) {
                JOptionPane.showMessageDialog(null, "Actualizado exitosamente");
    
                // Limpiar campos de entrada
                ventanaRegistroPaciente.nombrePacienteTxt.setText("");
                ventanaRegistroPaciente.apellidoPacienteTxt.setText("");
                ventanaRegistroPaciente.cedulaPacienteTxt.setText("");
                ventanaRegistroPaciente.EdadPacienteTxt.setText("");
                ventanaRegistroPaciente.comboTranstorno.setSelectedIndex(0);
                ventanaRegistroPaciente.botonMasculino.setSelected(false);
                ventanaRegistroPaciente.botonFemenino.setSelected(false);
    
                ventanaRegistroPaciente.setVisible(false);
                ventanaPrincipal.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el paciente");
            }
    
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        } finally {
            // Cerrar ResultSet y Connection
            try {
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void mostrarDatosEnTabla() {
        Connection con = null;
        ResultSet rs = null;

        String SQL = "SELECT * FROM pacientes";

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root", "Proverbios18.22");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Obtener metadata de la consulta
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Obtener nombres de las columnas
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }


            ventanaAdministrador.model.setColumnIdentifiers(columnNames);
            ventanaAdministrador.model.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                ventanaAdministrador.model.addRow(rowData);
            }

            ventanaAdministrador.tablaPacientes.revalidate();
            ventanaAdministrador.tablaPacientes.repaint();



        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        } finally {
            // Cerrar ResultSet y Connection
            try {
                if (rs != null)
                    rs.close();
                if (con != null)
                    con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
                    "jdbc:mysql://localhost:3306/registrosolissalazar?verifyServerCertificate=false&useSSL=true",
                    "root",
                    "091623");
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
                System.out.print("No se encontró el carnet a eliminar");

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
                System.out.println("Carnet--> " + rs.getString("carnet") + " Nombre--> " + rs.getString("nombre1"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }


    
    }




package Controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
            VentanaInformacionPaciente ventanaRegistroPaciente, VentanaOpcionesAdministrativo ventanaAdministrador,
            EditarPaciente ventanaEditar) {
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
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String SQL = "SELECT * FROM administrador WHERE Usuario = ? AND Clave = ?";

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root", "Proverbios18.22");
            pst = con.prepareStatement(SQL);
            pst.setString(1, entradaUsuario);
            pst.setString(2, contrasenaString);
            rs = pst.executeQuery();

            if (rs.next()) {
                // Si las credenciales son correctas
                JOptionPane.showMessageDialog(null, "Bienvenido " + entradaUsuario);
                ventanaLogin.setVisible(false);
                ventanaPrincipal.setVisible(true);
            } else {
                // Si las credenciales son incorrectas
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public void Administrador_Editar() {

        ventanaAdministrador.setVisible(false);
        ventanaEditar.setVisible(true);

    }

    public void Editar_Administrador() {

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

    public void InsertarElementos() {

        // Creacion de instancia para volver al menú principal
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
        if (entradaNombrePaciente.isEmpty() || entradaApellido.isEmpty() || entradaEdadPaciente.isEmpty()
                || entradaCedulaPaciente.isEmpty()) {
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
        String SQL = "INSERT INTO pacientes (nombre, apellido, cedula, edad, transtorno, sexo) VALUES ('"
                + entradaNombrePaciente + "', '" + entradaApellido + "', " + entradaCedulaPaciente + ", " + edadPaciente
                + ", '" + transtornoSeleccionado + "', '" + sexoPaciente + "');";

        // Establish connection with database
        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root", "Proverbios18.22");
            Statement stmt = con.createStatement();
            // Execute SQL statement
            exito = stmt.executeUpdate(SQL);

            // Process the result of the query
            if (exito != 0) {
                JOptionPane.showMessageDialog(null, "Registrado exitosamente");

                ventanaRegistroPaciente.setVisible(false);
                ventanaPrincipal.setVisible(true);

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

    public void buscarPorCedulaParaMostrar() {
        String cedulaBusqueda = ventanaAdministrador.cedula_txt.getText().trim(); // Asume que hay un campo de texto
                                                                                  // para ingresar la cédula a buscar
        Connection con = null;
        ResultSet rs = null;

        if (cedulaBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula para buscar.");
            return;
        }

        String SQL = "SELECT * FROM pacientes WHERE cedula = ?";

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root", "Proverbios18.22");
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cedulaBusqueda);
            rs = pstmt.executeQuery();

            ventanaAdministrador.model.setRowCount(0); // Limpiar la tabla antes de agregar el resultado

            if (rs.next()) {
                // Crear un array para almacenar los datos de la fila
                Object[] rowData = new Object[] {
                        rs.getString("Cedula"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Sexo"),
                        rs.getString("Edad"),
                        rs.getString("Transtorno")
                };

                // Agregar la fila al modelo de la tabla
                ventanaAdministrador.model.addRow(rowData);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Paciente encontrado y datos desplegados.");

            } else {
                // Mostrar mensaje de error si no se encuentra el paciente
                JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con la cédula proporcionada.");
            }

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

    public void buscarPorCedulaParaEditar() {
        String cedulaBusqueda = ventanaAdministrador.cedula_txt.getText().trim(); // Asume que hay un campo de texto
                                                                                  // para ingresar la cédula a buscar
        Connection con = null;
        ResultSet rs = null;

        if (cedulaBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cédula para buscar.");
            return;
        }

        String SQL = "SELECT * FROM pacientes WHERE cedula = ?";

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root", "Proverbios18.22");
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cedulaBusqueda);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // Poblar los campos del formulario con los datos recuperados
                ventanaEditar.nombrePacienteTxt.setText(rs.getString("nombre"));
                ventanaEditar.apellidoPacienteTxt.setText(rs.getString("apellido"));
                ventanaEditar.cedulaPacienteTxt.setText(rs.getString("cedula"));
                ventanaEditar.EdadPacienteTxt.setText(rs.getString("edad"));
                ventanaEditar.comboTranstorno.setSelectedItem(rs.getString("transtorno"));

                String sexo = rs.getString("sexo");
                if (sexo.equals("Masculino")) {
                    ventanaEditar.botonMasculino.setSelected(true);
                } else if (sexo.equals("Femenino")) {
                    ventanaEditar.botonFemenino.setSelected(true);
                }

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(null, "Paciente encontrado y datos desplegados.");
                ventanaEditar.setVisible(true);
                ventanaAdministrador.setVisible(false);

            } else {
                // Mostrar mensaje de error si no se encuentra el paciente
                JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con la cédula proporcionada.");
            }

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

    public void actualizarElementos() throws SQLException {
        // Obtener valores actuales de los campos de la ventanaEditar
        String entradaNombrePaciente = ventanaEditar.nombrePacienteTxt.getText().trim();
        String entradaApellido = ventanaEditar.apellidoPacienteTxt.getText().trim();
        String entradaCedulaPaciente = ventanaEditar.cedulaPacienteTxt.getText().trim();
        String entradaEdadPaciente = ventanaEditar.EdadPacienteTxt.getText().trim();
        String transtornoSeleccionado = String.valueOf(ventanaEditar.comboTranstorno.getSelectedItem());
        boolean masculinoSeleccionado = ventanaEditar.botonMasculino.isSelected();
        boolean femeninoSeleccionado = ventanaEditar.botonFemenino.isSelected();
        String entradaCedulaAdministrador = ventanaAdministrador.cedula_txt.getText().trim();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int exito = 0;

        // Validar campos de entrada
        if (entradaNombrePaciente.isEmpty() || entradaApellido.isEmpty() || entradaEdadPaciente.isEmpty()
                || entradaCedulaPaciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos a rellenar no estén vacíos");
            return;
        }

        // Convertir edad a entero
        int edadPaciente;
        try {
            edadPaciente = Integer.parseInt(entradaEdadPaciente);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor válido para la edad");
            ventanaEditar.EdadPacienteTxt.setText("");
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
        String SQL = "UPDATE pacientes SET Nombre='" + entradaNombrePaciente + "', Apellido='" + entradaApellido
                + "', Sexo='" + sexoPaciente + "', Edad=" + entradaEdadPaciente + ", Transtorno='"
                + transtornoSeleccionado + "' WHERE Cedula='" + entradaCedulaAdministrador + "'";

        // Establecer la conexión con la base de datos
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root", "Proverbios18.22");
            stmt = con.createStatement();
            exito = stmt.executeUpdate(SQL);

            // Asignar valores a los parámetros de la consulta

            // Procesar el resultado de la consulta
            if (exito != 0) {
                JOptionPane.showMessageDialog(null, "Actualizado exitosamente");

                ventanaEditar.setVisible(false);
                ventanaAdministrador.setVisible(true);
                // Limpiar campos de entrada
                ventanaEditar.nombrePacienteTxt.setText("");
                ventanaEditar.apellidoPacienteTxt.setText("");
                ventanaEditar.cedulaPacienteTxt.setText("");
                ventanaEditar.EdadPacienteTxt.setText("");
                ventanaEditar.comboTranstorno.setSelectedIndex(0);
                ventanaEditar.botonMasculino.setSelected(false);
                ventanaEditar.botonFemenino.setSelected(false);

            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el paciente");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
        } finally {
            // Cerrar conexión y liberar recursos
            try {
                if (con != null)
                    con.close();
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
                ventanaAdministrador.cedula_txt.setText(" ");
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

        String sqlEliminar = "DELETE FROM pacientes where Cedula= '" + cedula + "';";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/centro_apoyo_solissalazar?verifyServerCertificate=false&useSSL=true",
                    "root",
                    "Proverbios18.22");
            con.setAutoCommit(true);

            stmt = con.createStatement();
            int exito = stmt.executeUpdate(sqlEliminar);
            // System.out.println("valor: " + exito);
            if (exito > 0) {

                JOptionPane.showMessageDialog(null, "El paciente se eliminó correctamente");
            } else
                JOptionPane.showMessageDialog(null, "No se encontró la cedula a eliminar");

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

}

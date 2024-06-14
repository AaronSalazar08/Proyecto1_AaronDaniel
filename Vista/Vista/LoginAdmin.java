package Vista;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class LoginAdmin extends JFrame implements ActionListener {

    JPanel panelRegistro = new JPanel();
    JLabel tituloLabel, cedulaLabel, nombreCompletoLabel, apellidoCompletoLabel, usuarioLabel, claveLabel;
    JButton botonRegistrar, botonVolver;
    JTextField usuario_txt, cedula_txt, nombre_txt, apellido_txt;
    JPasswordField clave_psw;
    Font fuente = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 14);
    Font fuenteBoton = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 16);
    Font fuenteTitulo = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 20);

    public LoginAdmin() {

        // Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Inicio Sesión");
        this.setLocationRelativeTo(null);
        this.setSize(350, 550);
        this.setContentPane(panelRegistro);
        panelRegistro.setBackground(new Color(255, 255, 255));
        // panelRegistro.setBorder(BorderFactory.createLineBorder(new Color(53, 89, 252), 4));
        setLocationRelativeTo(null);
        panelRegistro.setLayout(null);
        Elementos();

    }

    public void Elementos() {

        // JLabel

        tituloLabel = new JLabel("Inicio Sesión ");
        tituloLabel.setBounds(100, 0, 200, 60);
        tituloLabel.setFont(fuenteTitulo);

        cedulaLabel = new JLabel("Cédula: ");
        cedulaLabel.setBounds(40, 50, 200, 60);
        cedulaLabel.setFont(fuente);

        nombreCompletoLabel = new JLabel("Nombre Completo: ");
        nombreCompletoLabel.setBounds(40, 120, 200, 60);
        nombreCompletoLabel.setFont(fuente);

        apellidoCompletoLabel = new JLabel("Apellido Completo: ");
        apellidoCompletoLabel.setBounds(40, 190, 200, 60);
        apellidoCompletoLabel.setFont(fuente);

        usuarioLabel = new JLabel("Usuario: ");
        usuarioLabel.setBounds(40, 260, 200, 60);
        usuarioLabel.setFont(fuente);

        claveLabel = new JLabel("Contraseña: ");
        claveLabel.setBounds(40, 330, 200, 60);
        claveLabel.setFont(fuente);

        // JTexField

        cedula_txt = new JTextField();
        cedula_txt.setBounds(40, 100, 250, 30);
        cedula_txt.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        cedula_txt.setFont(fuente);
        cedula_txt.setToolTipText("Ingrese su número de identificación");

        nombre_txt = new JTextField();
        nombre_txt.setBounds(40, 170, 250, 30);
        nombre_txt.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        nombre_txt.setFont(fuente);
        nombre_txt.setToolTipText("Ingrese su nombre completo");

        apellido_txt = new JTextField();
        apellido_txt.setBounds(40, 240, 250, 30);
        apellido_txt.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        apellido_txt.setFont(fuente);
        apellido_txt.setToolTipText("Ingrese sus apellidos paternos y maternos");

        usuario_txt = new JTextField();
        usuario_txt.setBounds(40, 310, 250, 30);
        usuario_txt.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        usuario_txt.setFont(fuente);
        usuario_txt.setToolTipText("Ingrese su nombre de usuario");

        clave_psw = new JPasswordField();
        clave_psw.setBounds(40, 380, 250, 30);
        clave_psw.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        clave_psw.setFont(fuente);
        clave_psw.setToolTipText("Ingrese su contraseña");

        // JButton

        botonRegistrar = new JButton("Ingresar");
        botonRegistrar.setForeground(new Color(255, 255, 255));
        botonRegistrar.setBounds(40, 450, 250, 30);
        botonRegistrar.addActionListener(this);
        botonRegistrar.setBackground(new Color(53, 89, 252));
        botonRegistrar.setFont(fuenteBoton);

        botonVolver = new JButton();
        botonVolver.setBounds(10, 220, 65, 30);
        botonVolver.setBackground(new Color(209, 242, 235));
        botonVolver.addActionListener(this);
        botonVolver.setOpaque(false);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBorderPainted(false);
        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver4.png");
        if (iconoVolver != null && iconoVolver.getImage() != null) {
            Image imagenVolverAjustada = iconoVolver.getImage().getScaledInstance(55, 40, Image.SCALE_SMOOTH);
            botonVolver.setIcon(new ImageIcon(imagenVolverAjustada));
        }

        // Añadir constantes al panel

        panelRegistro.add(tituloLabel);
        panelRegistro.add(cedulaLabel);
        panelRegistro.add(nombreCompletoLabel);
        panelRegistro.add(apellidoCompletoLabel);
        panelRegistro.add(usuarioLabel);
        panelRegistro.add(claveLabel);

        panelRegistro.add(cedula_txt);
        panelRegistro.add(nombre_txt);
        panelRegistro.add(apellido_txt);
        panelRegistro.add(usuario_txt);
        panelRegistro.add(clave_psw);

        panelRegistro.add(botonRegistrar);
        panelRegistro.add(botonVolver);

    }

    // Metodo para la accion de los botones

    public void actionPerformed(ActionEvent e) {
        // Obtener los valores de los JTexfield por medio de variables locales

        String entrada_texto1 = usuario_txt.getText();
        char[] contrasena = clave_psw.getPassword();
        String contrasenaString = new String(contrasena);

        // Asignando credenciales para los cuentas administrarivas del programa
        Map<String, String> credencialesValidas = new HashMap<>();
        credencialesValidas.put("Aaron", "123");
        credencialesValidas.put("Daniel", "456");
        credencialesValidas.put("Douglas", "789");

        // Creando instancia para volver al menu principal

        if (e.getSource() == botonVolver) {

            MenuPrimeraVista menuPrimeraVista = new MenuPrimeraVista();
            menuPrimeraVista.setVisible(true);
            this.dispose();

        }
        // metodo para para comprobar las credenciales del usuario administrativo

        // Ciclo if en caso de que se dejen los espacios vacíos
        if (e.getSource() == botonRegistrar) {

            if (entrada_texto1.isEmpty() || contrasenaString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Verifique que los campos a llenar no estén vacíos");
                return;
            }

            // ciclo if en caso de que las credenciales sean correctas
            if (credencialesValidas.containsKey(entrada_texto1)
                    && credencialesValidas.get(entrada_texto1).equals(contrasenaString)) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + entrada_texto1);

                VentanaOpcionesAdministrativo ventanaOpcionesAdministrativo = new VentanaOpcionesAdministrativo();
                ventanaOpcionesAdministrativo.setVisible(true);
                this.dispose();

                // Else en caso de que las credenciales sean incorrectas

            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }

        }

    }

}
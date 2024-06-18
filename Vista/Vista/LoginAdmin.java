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

import Controlador.Metodos;

import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class LoginAdmin extends JFrame implements ActionListener {

     // Metodo para la llamada de los metodos de las constantes mediante una instacia
    // de la clase Metodos
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

     // Instancia para la clase
    public static Metodos metodos;

    // Declarando constantes
    public JPanel panelRegistro = new JPanel();
    public JLabel tituloLabel, usuarioLabel, claveLabel, logoPerfil, logoUsuario, logoClave;
    public JButton botonRegistrar, botonVolver;
    public JTextField usuario_txt;
    public JPasswordField clave_psw;
    private ImageIcon imagen;
    private ImageIcon icono;
    Font fuente = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 14);
    Font fuenteBoton = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 16);
    Font fuenteTitulo = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 20);

    public LoginAdmin() {

        // Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio Sesión");
        this.setLocationRelativeTo(null);
        this.setSize(350, 400);
        this.setContentPane(panelRegistro);
        panelRegistro.setBackground(new Color(255, 255, 255));
        panelRegistro.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171), 4));
        setLocationRelativeTo(null);
        panelRegistro.setLayout(null);
        Elementos();

    }

    public void Elementos() {

        // JLabel

        logoPerfil = new JLabel();
        logoPerfil.setBounds(100, 40, 140, 140);
        this.Pintar(this.logoPerfil, "Vista\\Imagenes\\perfilLogin.png");

        tituloLabel = new JLabel("Inicio Sesión ");
        tituloLabel.setBounds(110, 0, 200, 60);
        tituloLabel.setFont(fuenteTitulo);

        usuarioLabel = new JLabel("Usuario: ");
        usuarioLabel.setBounds(40, 140, 200, 60);
        usuarioLabel.setFont(fuente);

        claveLabel = new JLabel("Contraseña: ");
        claveLabel.setBounds(40, 210, 200, 60);
        claveLabel.setFont(fuente);

        // JTexField

        usuario_txt = new JTextField();
        usuario_txt.setBounds(40, 190, 250, 30);
        usuario_txt.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        usuario_txt.setFont(fuente);
        usuario_txt.setToolTipText("Ingrese su nombre de usuario");

        logoUsuario = new JLabel();
        logoUsuario.setBounds(255, 193, 30, 25);
        this.Pintar(this.logoUsuario, "Vista\\Imagenes\\usuarioLogo.png");

        clave_psw = new JPasswordField();
        clave_psw.setBounds(40, 260, 250, 30);
        clave_psw.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        clave_psw.setFont(fuente);
        clave_psw.setToolTipText("Ingrese su contraseña");

        logoClave = new JLabel();
        logoClave.setBounds(255, 263, 30, 25);
        this.Pintar(this.logoClave, "Vista\\Imagenes\\claveLogo.png");

        // JButton

        botonRegistrar = new JButton("Ingresar");
        botonRegistrar.setForeground(new Color(255, 255, 255));
        botonRegistrar.setBounds(40, 300, 250, 30);
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
        panelRegistro.add(logoPerfil);
        panelRegistro.add(logoUsuario);
        panelRegistro.add(logoClave);

        panelRegistro.add(usuarioLabel);
        panelRegistro.add(claveLabel);

        panelRegistro.add(usuario_txt);
        panelRegistro.add(clave_psw);

        panelRegistro.add(botonRegistrar);
        panelRegistro.add(botonVolver);

    }

    // Metodo para la accion de los botones

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonRegistrar) {
            if (metodos != null) {
                metodos.Login_Principal();

            } else {

                JOptionPane.showMessageDialog(null, "Metodos is null");
            }

        }
    }

    private void Pintar(JLabel lbl, String ruta) { // Este metodo se utiliza para ponerle imagenes de fondo a los
        // Labels
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
        this.repaint();

    }

}
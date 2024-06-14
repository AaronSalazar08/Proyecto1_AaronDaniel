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

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    public JPanel panelRegistro = new JPanel();
    public JLabel tituloLabel, cedulaLabel, nombreCompletoLabel, apellidoCompletoLabel, usuarioLabel, claveLabel;
    public JButton botonRegistrar, botonVolver;
    public JTextField usuario_txt, cedula_txt, nombre_txt, apellido_txt;
    public JPasswordField clave_psw;
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
       
        if(e.getSource() == botonRegistrar){
            if(metodos != null ){
                metodos.Login_Principal();

            }else {

                JOptionPane.showMessageDialog(null, "Metodos is null");
            }

        }
    }

}
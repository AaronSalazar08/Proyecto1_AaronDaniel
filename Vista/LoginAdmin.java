package Vista;

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

    //Declarando constantes 

    JPanel panelRegistro = new JPanel();

    JLabel RegistroLabel;
    JLabel labelAdmin;
    JLabel labelContraseña;

    JButton botonRegistrar;
    JButton botonVolver;
    JTextField nombreAdmin;
    JPasswordField areaContraseña;
    Font fuente = new Font("Century Schoolbook", Font.PLAIN, 16);
    Font fuenteBoton = new Font("Century Schoolbook", Font.PLAIN, 12);

    public LoginAdmin() {

        //Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Inicio Sesión");
        this.setLocationRelativeTo(null);
        this.setSize(300, 300);
        this.setContentPane(panelRegistro);
        panelRegistro.setBackground(new Color(209, 242, 235));
        setLocationRelativeTo(null);
        panelRegistro.setLayout(null);

        Elementos();

    }

    public void Elementos() {

        // Añadir constantes

        // JLabel

        labelAdmin = new JLabel("Usuario");
        labelAdmin.setBounds(110, 10, 200, 60);
        labelAdmin.setFont(fuente);

        labelContraseña = new JLabel("Contraseña ");
        labelContraseña.setBounds(100, 90, 200, 60);
        labelContraseña.setFont(fuente);

        // JTexField

        nombreAdmin = new JTextField();
        nombreAdmin.setBounds(70, 60, 150, 20);
        nombreAdmin.setFont(fuente);
        nombreAdmin.setToolTipText("Ingrese su usuario");

        areaContraseña = new JPasswordField();
        areaContraseña.setBounds(70, 140, 150, 20);
        areaContraseña.setFont(fuente);
        areaContraseña.setToolTipText("Ingrese su contraseña");

        // JButton

        botonRegistrar = new JButton("Continuar");
        botonRegistrar.setBounds(95, 180, 100, 30);
        botonRegistrar.addActionListener(this);
        botonRegistrar.setBackground(new Color(255, 255, 255));
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

        //Añadir constantes al panel

        panelRegistro.add(labelAdmin);
        panelRegistro.add(labelContraseña);
        panelRegistro.add(nombreAdmin);
        panelRegistro.add(areaContraseña);
        panelRegistro.add(botonRegistrar);
        panelRegistro.add(botonVolver);

    }

    //Metodo para la accion de los botones 

    public void actionPerformed(ActionEvent e) {
        //Obtener los valores de los JTexfield por medio de variables locales 

        String entrada_texto1 = nombreAdmin.getText();
        char[] contrasena = areaContraseña.getPassword();
        String contrasenaString = new String(contrasena);

        //Asignando credenciales para los cuentas administrarivas del programa 
        Map<String, String> credencialesValidas = new HashMap<>();
        credencialesValidas.put("Aaron", "123");
        credencialesValidas.put("Daniel", "456");
        credencialesValidas.put("Douglas", "789");

        //Creando instancia para volver al menu principal 

        if (e.getSource() == botonVolver) {

            MenuPrimeraVista menuPrimeraVista = new MenuPrimeraVista();
            menuPrimeraVista.setVisible(true);
            this.dispose();

        }
        //metodo para para comprobar las credenciales del usuario administrativo 

        //Ciclo if en caso de que se dejen los espacios vacíos
        if (e.getSource() == botonRegistrar) {

            if (entrada_texto1.isEmpty() || contrasenaString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete los campos en blanco");
                return;
            }

            //ciclo if en caso de que las credenciales sean correctas 
            if (credencialesValidas.containsKey(entrada_texto1)
                    && credencialesValidas.get(entrada_texto1).equals(contrasenaString)) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + entrada_texto1);

             VentanaOpcionesAdministrativo ventanaOpcionesAdministrativo = new VentanaOpcionesAdministrativo();
             ventanaOpcionesAdministrativo.setVisible(true);
             this.dispose();

             //Else en caso de que las credenciales sean incorrectas 
                
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }

        }

    }

}
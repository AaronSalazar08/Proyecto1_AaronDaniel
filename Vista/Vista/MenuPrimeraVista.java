package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class MenuPrimeraVista extends JFrame implements ActionListener {

    // Declarando costantes

    public JPanel panelPrimeraVista = new JPanel();
    public JButton botonAdministrativo, botonPaciente, botonSalir, botonExpendiente, botonCredito, botonUsuario;
    public JLabel fraseLabel, tituloLabel, labelDescripcion;
    Font fuenteFrase = new Font("", Font.PLAIN, 16);
    Font fuenteBoton = new Font("Century Schoolbook", Font.PLAIN, 16);
    private ImageIcon imagen;
    private ImageIcon icono;
    private JLabel logo;
    ImageIcon iconoRegistro;

    public MenuPrimeraVista() {
        // Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Menú Principal");
        this.setLocationRelativeTo(null);
        this.setSize(600, 600);
        this.setContentPane(panelPrimeraVista);
        panelPrimeraVista.setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);
        panelPrimeraVista.setLayout(null);
        panelPrimeraVista.setBorder(BorderFactory.createLineBorder(new Color(53, 89, 252), 4));

        Elementos();
    }

    public void Elementos() {
        // Inicializando constantes

        // JLabel

        logo = new JLabel();
        logo.setBounds(210, 10, 180, 180);
        this.Pintar(this.logo, "Vista\\Imagenes\\logoRegistro.png");

        tituloLabel = new JLabel("Sistema de Registro de Centro de Apoyo ");
        tituloLabel.setBounds(115, 155, 500, 70);
        Font fuente1 = new Font("Times new Roman", Font.PLAIN, 22); //
        tituloLabel.setFont(fuente1);
        tituloLabel.setForeground(new Color(0, 23, 141));

        JLabel titulo2 = new JLabel(" Solís Salazar");
        titulo2.setBounds(240, 200, 500, 70);
        Font fuente9 = new Font("Times new Roman", Font.PLAIN, 22); //
        titulo2.setFont(fuente9);
        titulo2.setForeground(new Color(0, 23, 141));

        labelDescripcion = new JLabel("Centro de apoyo para niños con transtornos mentales en Costa Rica");
        labelDescripcion.setBounds(70, 70, 590, 70);
        Font fuente4 = new Font("Century Schoolbook", Font.PLAIN, 14); //
        labelDescripcion.setFont(fuente4);
        labelDescripcion.setForeground(new Color(23, 32, 42));

        fraseLabel = new JLabel("El ayudar es don que todos tenemos");
        fraseLabel.setBounds(155, 480, 450, 70);
        Font fuente2 = new Font("Century Schoolbook", Font.ITALIC, 16); //
        fraseLabel.setFont(fuente2);
        fraseLabel.setForeground(new Color(23, 32, 42));

        // JButton

        botonPaciente = new JButton(" Insertar Registro");
        botonPaciente.setBounds(200, 280, 200, 30);
        botonPaciente.setForeground(Color.WHITE);
        botonPaciente.addActionListener(this);
        botonPaciente.setBackground(new Color(53, 89, 252));
        botonPaciente.setFont(fuenteBoton);
        ImageIcon iconoRegistro = new ImageIcon("Vista/Imagenes/registro.png");
        Image imagenRegistro = iconoRegistro.getImage();
        Image imagenEmpleadoAjustada = imagenRegistro.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
        ImageIcon iconoEmpleadoAjustada = new ImageIcon(imagenEmpleadoAjustada);
        botonPaciente.setIcon(iconoEmpleadoAjustada);

        botonAdministrativo = new JButton("Administrativo");
        botonAdministrativo.setBounds(200, 330, 200, 30);
        botonAdministrativo.setForeground(Color.WHITE);
        botonAdministrativo.addActionListener(this);
        botonAdministrativo.setBackground(new Color(53, 89, 252));
        botonAdministrativo.setToolTipText("Apartado para acciones adminstrativas");
        botonAdministrativo.setFont(fuenteBoton);

        botonCredito = new JButton("Acerca de nosotros");
        botonCredito.setBounds(200, 380, 200, 30);
        botonCredito.setForeground(Color.WHITE);
        botonCredito.addActionListener(this);
        botonCredito.setBackground(new Color(53, 89, 252));
        botonCredito.setToolTipText("Apartado para acciones adminstrativas");
        botonCredito.setFont(fuenteBoton);

        botonSalir = new JButton("");
        botonSalir.setBounds(510, 500, 40, 40);
        botonSalir.setForeground(Color.BLACK);
        botonSalir.addActionListener(this);
        botonSalir.setBackground(new Color(53, 89, 252));
        botonSalir.setToolTipText("Si presiona este boton sale del programa");
        botonSalir.setFont(fuenteBoton);
        this.PintarB(this.botonSalir, "Vista\\Imagenes\\apagado.png");
        botonSalir.setBorderPainted(false);
        botonSalir.setOpaque(false);


        botonUsuario = new JButton("");
        botonUsuario.setBounds(10, 10, 30, 30);
        botonUsuario.setForeground(Color.BLACK);
        botonUsuario.addActionListener(this);
        botonUsuario.setBackground(new Color(53, 89, 252));
        botonUsuario.setToolTipText("Si presiona este boton sale del programa");
        botonUsuario.setFont(fuenteBoton);
        this.PintarB(this.botonUsuario, "Vista\\Imagenes\\Usuario.png");
        botonUsuario.setBorderPainted(false);
        botonUsuario.setOpaque(false);

        // Agregar constantes al panel
        panelPrimeraVista.add(tituloLabel);
        panelPrimeraVista.add(fraseLabel);
        panelPrimeraVista.add(botonAdministrativo);
        panelPrimeraVista.add(botonPaciente);
        // panelPrimeraVista.add(labelDescripcion);
        panelPrimeraVista.add(botonSalir);
        panelPrimeraVista.add(logo);
        panelPrimeraVista.add(titulo2);
        panelPrimeraVista.add(botonCredito);
        panelPrimeraVista.add(botonUsuario);

    }

    public void actionPerformed(ActionEvent e) {
        String opcion;

        // Ciclo if en caso de que se seleccione la opcion "Administrativo"
        if (e.getSource() == botonAdministrativo) {

            LoginAdmin loginAdmin = new LoginAdmin();
            loginAdmin.setVisible(true);
            this.dispose();

            // Ciclo if en caso de que se seleccione la opcion "Paciente"

        } else if (e.getSource() == botonPaciente) {

            VentanaInformacionPaciente instanciaPaciente = new VentanaInformacionPaciente();
            instanciaPaciente.setVisible(true);
            this.dispose();

            // Ciclo if en caso de que el usuario quisiera salir del programa
        } else if (e.getSource() == botonSalir) {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro de que quieres salir del programa? ",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                this.dispose();
            }

        }

        // Creacion de istancia para poder entrar a la busqueda de un expendiente medico
        if (e.getSource() == botonExpendiente) {

            ResultadosPaciente resultadosPaciente = new ResultadosPaciente();
            resultadosPaciente.setVisible(true);
            this.dispose();
        }

    }

    private void PintarB(JButton lbl, String ruta) {
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(),
                        lbl.getHeight(),
                        Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);
        this.repaint();
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

        // Metodo para poner imagines a JButton
    }

}

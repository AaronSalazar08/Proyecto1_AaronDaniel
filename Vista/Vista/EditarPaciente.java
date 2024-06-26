package Vista;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controlador.Metodos;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Image;

public class EditarPaciente extends JFrame implements ActionListener {

    // Metodo para la llamada de los metodos de las constantes mediante una instacia
    // de la clase Metodos
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    // Instancia para la clase
    public static Metodos metodos;

    // Declarando constantes
    public JPanel panelInfoPaciente = new JPanel();
    public JButton botonRegistrar, botonCancelar;
    public JLabel labelNombrePaciente, labelCedula, labelEdad, labelTranstorno, labelSexo, labelTitulo, labelApellido;
    public static JTextField nombrePacienteTxt, apellidoPacienteTxt;
    public static JTextField cedulaPacienteTxt;
    public static JTextField EdadPacienteTxt;
    public static JComboBox comboTranstorno; // JComboBox para poder seleccionar los tipos de transtorno
    public static JRadioButton botonMasculino, botonFemenino; // Botones para seleccionar el tipo de sexo
    Font fuenteBoton = new Font("Century Schoolbook", Font.PLAIN, 20);
    private ImageIcon imagen;
    private ImageIcon icono;

    public EditarPaciente() {
        // Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Actualización de Paciente");
        this.setLocationRelativeTo(null);
        this.setSize(410, 490);
        this.setContentPane(panelInfoPaciente);
        panelInfoPaciente.setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);
        panelInfoPaciente.setBorder(BorderFactory.createLineBorder(new Color(53, 89, 252), 4));
        panelInfoPaciente.setLayout(null);

        Elementos();

    }

    @SuppressWarnings("unchecked")
    public void Elementos() {
        // Inicializando constantes para el JPanel

        // JButton

        botonRegistrar = new JButton("  Guardar");
        botonRegistrar.setBounds(220, 405, 150, 30);
        botonRegistrar.addActionListener(this);
        botonRegistrar.setForeground(new Color(255, 255, 255));
        botonRegistrar.setBackground(new Color(53, 89, 252));
       
        //botonRegistrar.setFont(fuenteBoton);

        botonRegistrar.setBorderPainted(false);

        ImageIcon iconoEditar = new ImageIcon("Vista/Imagenes/guardarBlanco.png");
        botonRegistrar.setToolTipText("Actualizar datos del Paciente");
        if (iconoEditar != null && iconoEditar.getImage() != null) {
            Image imagenEditarAjustada = iconoEditar.getImage().getScaledInstance(40, 30,
                    Image.SCALE_SMOOTH);
                    botonRegistrar.setIcon(new ImageIcon(imagenEditarAjustada));
        }


        botonCancelar = new JButton();
        botonCancelar.setBounds(20, 405, 55, 30);
        botonCancelar.setForeground(Color.BLACK);
        botonCancelar.setBackground(new Color(31, 209, 185));
        botonCancelar.addActionListener(this);
        botonCancelar.setOpaque(false);
        botonCancelar.setContentAreaFilled(false);
        botonCancelar.setBorderPainted(false);
        botonCancelar.setToolTipText("Atrás");
        this.PintarB(this.botonCancelar, "Vista\\Imagenes\\volverA.png");
        botonRegistrar.setBorderPainted(false);
        botonRegistrar.setOpaque(false);

        // JLabel

        labelNombrePaciente = new JLabel("Nombre:");
        labelNombrePaciente.setBounds(240, 20, 350, 50);
        Font fuente1 = new Font("Century Schoolbook", Font.PLAIN, 13);
        labelNombrePaciente.setFont(fuente1);
        labelNombrePaciente.setForeground(new Color(23, 32, 42));

        labelApellido = new JLabel("Apellido:");
        labelApellido.setBounds(240, 85, 350, 50);
        Font fuente12 = new Font("Century Schoolbook", Font.PLAIN, 13);
        labelApellido.setFont(fuente12);
        labelApellido.setForeground(new Color(23, 32, 42));

        labelCedula = new JLabel("Cédula:");
        labelCedula.setBounds(20, 10, 400, 70);
        Font fuente2 = new Font("Century Schoolbook", Font.PLAIN, 13);
        labelCedula.setFont(fuente2);
        labelCedula.setForeground(new Color(23, 32, 42));

        labelEdad = new JLabel("Edad:");
        labelEdad.setBounds(20, 80, 400, 70);
        Font fuente3 = new Font("Century Schoolbook", Font.PLAIN, 13);
        labelEdad.setFont(fuente3);
        labelEdad.setForeground(new Color(23, 32, 42));

        labelTranstorno = new JLabel("Tipo de transtorno:");
        labelTranstorno.setBounds(230, 150, 400, 70);
        Font fuente4 = new Font("Century Schoolbook", Font.PLAIN, 14);
        labelTranstorno.setFont(fuente4);
        labelTranstorno.setForeground(new Color(23, 32, 42));

        labelSexo = new JLabel("Sexo:");
        labelSexo.setBounds(20, 160, 400, 70);
        Font fuente5 = new Font("Century Schoolbook", Font.PLAIN, 14);
        labelSexo.setFont(fuente5);
        labelSexo.setForeground(new Color(23, 32, 42));

        // JTexfield

        nombrePacienteTxt = new JTextField(" ");
        nombrePacienteTxt.setBounds(240, 60, 95, 20);
        nombrePacienteTxt.setToolTipText("Ingrese el nombre del paciente");

        apellidoPacienteTxt = new JTextField(" ");
        apellidoPacienteTxt.setBounds(240, 125, 95, 20);
        apellidoPacienteTxt.setToolTipText("Ingrese el nombre del paciente");

        cedulaPacienteTxt = new JTextField(" ");
        cedulaPacienteTxt.setBounds(20, 60, 120, 20);
        cedulaPacienteTxt.setToolTipText("Ingrese la cedula del paciente");

        EdadPacienteTxt = new JTextField(" ");
        EdadPacienteTxt.setBounds(20, 130, 30, 20);
        EdadPacienteTxt.setToolTipText("Ingrese la edad del paciente");

        // JComboBox

        comboTranstorno = new JComboBox();
        comboTranstorno.setBounds(230, 205, 155, 30);
        comboTranstorno.addItem("Depresión");
        comboTranstorno.addItem("Obsesivo Compulsivo");
        comboTranstorno.addItem("Ansiedad");
        comboTranstorno.addItem("Deficit atencional");
        comboTranstorno.addItem("Estrés");
        comboTranstorno.addItem("Autista");
        comboTranstorno.addItem("Alimentario");
        comboTranstorno.addItem("Esquizofrenia");
        comboTranstorno.setToolTipText("Seleccione el tipo de transtorno para el paciente");

        // JRadioButton

        botonMasculino = new JRadioButton("Masculino");
        botonMasculino.setBounds(10, 210, 95, 35);
        botonMasculino.setBackground(new Color(255, 255, 255));
        botonMasculino.setToolTipText("Seleccione el sexo del paciente");

        botonFemenino = new JRadioButton("Femenino");
        botonFemenino.setBounds(110, 210, 95, 35);
        botonFemenino.setBackground(new Color(255, 255, 255));
        botonFemenino.setToolTipText("Seleccione el sexo del paciente");

        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(botonMasculino);
        grupoBotones.add(botonFemenino);

        // añadir constantes al panel
        panelInfoPaciente.add(EdadPacienteTxt);
        panelInfoPaciente.add(cedulaPacienteTxt);
        panelInfoPaciente.add(nombrePacienteTxt);
        panelInfoPaciente.add(apellidoPacienteTxt);
        panelInfoPaciente.add(labelTranstorno);
        panelInfoPaciente.add(labelSexo);
        panelInfoPaciente.add(labelNombrePaciente);
        panelInfoPaciente.add(labelEdad);
        panelInfoPaciente.add(labelCedula);
        panelInfoPaciente.add(labelApellido);

        panelInfoPaciente.add(botonRegistrar);
        panelInfoPaciente.add(botonCancelar);

        panelInfoPaciente.add(comboTranstorno);

        panelInfoPaciente.add(botonMasculino);
        panelInfoPaciente.add(botonFemenino);

    }

    // Metodo para la accion de botones
    public void actionPerformed(ActionEvent e) {

        // Metodo para insertar un elemento y enviarlo a la base de datos MySQL
        if (e.getSource() == botonRegistrar) {
            try {
                metodos.actualizarElementos();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        if (e.getSource() == botonCancelar) {

            metodos.Editar_Administrador();
        }

    }

    // Fin boton registrar

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

}

// Fin Clase principal

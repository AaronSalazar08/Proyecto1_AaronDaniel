package Vista;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;

public class VentanaInformacionPaciente extends JFrame implements ActionListener {

     // Declarando constantes 
    public JPanel panelInfoPaciente = new JPanel();
    public JButton botonRegistrar, botonCancelar;
    public JLabel labelNombrePaciente, labelCedula, labelEdad, labelTranstorno, labelSexo, labelTitulo;
    public static JTextField nombrePacienteTxt;
    public static JTextField cedulaPacienteTxt;
    public static JTextField EdadPacienteTxt;
    public static JComboBox comboTranstorno; //JComboBox para poder seleccionar los tipos de transtorno 
    public static JRadioButton botonMasculino, botonFemenino; //Botones para seleccionar el tipo de sexo
    Font fuenteBoton = new Font("Century Schoolbook", Font.PLAIN, 20);

    public VentanaInformacionPaciente() {
        //Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Registro de Paciente");
        this.setLocationRelativeTo(null);
        this.setSize(385, 560);
        this.setContentPane(panelInfoPaciente);
        panelInfoPaciente.setBackground(new Color(209, 242, 235));
        setLocationRelativeTo(null);
        panelInfoPaciente.setLayout(null);

        Elementos();

    }


    @SuppressWarnings("unchecked")
    public void Elementos() {
        //Inicializando constantes para el JPanel

        // JButton

        botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBounds(200, 465, 150, 30);
        botonRegistrar.setForeground(Color.BLACK);
        botonRegistrar.setBackground(new Color( 255, 255, 255));
        botonRegistrar.setFont(fuenteBoton);
        botonRegistrar.addActionListener(this);
        botonRegistrar.setToolTipText("Presione el boton para registrar al paciente");

        botonCancelar = new JButton();
        botonCancelar.setBounds(20, 465, 55, 30);
        botonCancelar.setForeground(Color.BLACK);
        botonCancelar.setBackground(new Color(31, 209, 185));
        botonCancelar.addActionListener(this);
        botonCancelar.setOpaque(false);
        botonCancelar.setContentAreaFilled(false);
        botonCancelar.setBorderPainted(false);
        botonCancelar.setToolTipText("Atrás");
        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver4.png");
        if (iconoVolver != null && iconoVolver.getImage() != null) {
            Image imagenVolverAjustada = iconoVolver.getImage().getScaledInstance(55, 40, Image.SCALE_SMOOTH);
            botonCancelar.setIcon(new ImageIcon(imagenVolverAjustada));
        }

        // JLabel

        labelNombrePaciente = new JLabel("Nombre:");
        labelNombrePaciente.setBounds(20, 100, 350, 50);
        Font fuente1 = new Font("Century Schoolbook", Font.PLAIN, 16);
        labelNombrePaciente.setFont(fuente1);
        labelNombrePaciente.setForeground(new Color(23, 32, 42));

        labelCedula = new JLabel("Cédula:");
        labelCedula.setBounds(30, 40, 400, 70);
        Font fuente2 = new Font("Century Schoolbook", Font.PLAIN, 16);
        labelCedula.setFont(fuente2);
        labelCedula.setForeground(new Color(23, 32, 42));

        labelEdad = new JLabel("Edad:");
        labelEdad.setBounds(40, 150, 400, 70);
        Font fuente3 = new Font("Century Schoolbook", Font.PLAIN, 16);
        labelEdad.setFont(fuente3);
        labelEdad.setForeground(new Color(23, 32, 42));

        labelTranstorno = new JLabel("Tipo de transtorno:");
        labelTranstorno.setBounds(20, 250, 400, 70);
        Font fuente4 = new Font("Century Schoolbook", Font.PLAIN, 16);
        labelTranstorno.setFont(fuente4);
        labelTranstorno.setForeground(new Color(23, 32, 42));

        labelSexo = new JLabel("Sexo:");
        labelSexo.setBounds(40, 200, 400, 70);
        Font fuente5 = new Font("Century Schoolbook", Font.PLAIN, 16);
        labelSexo.setFont(fuente5);
        labelSexo.setForeground(new Color(23, 32, 42));

        // JTexfield

        nombrePacienteTxt = new JTextField(" ");
        nombrePacienteTxt.setBounds(120,115, 130, 20);
        nombrePacienteTxt.setToolTipText("Ingrese le nombre del paciente");

        cedulaPacienteTxt = new JTextField(" ");
        cedulaPacienteTxt.setBounds(120, 65, 150, 20);
        cedulaPacienteTxt.setToolTipText("Ingrese la cedula del paciente");

        EdadPacienteTxt = new JTextField(" ");
        EdadPacienteTxt.setBounds(120, 177, 30, 20);
        EdadPacienteTxt.setToolTipText("Ingrese la edad del paciente");

        // JComboBox

        comboTranstorno = new JComboBox();
        comboTranstorno.setBounds(195, 280, 175, 30);
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
        botonMasculino.setBounds(120, 220, 95, 35);
        botonMasculino.setBackground(new Color(209, 242, 235));
        botonMasculino.setToolTipText("Seleccione el sexo del paciente");

        botonFemenino = new JRadioButton("Femenino");
        botonFemenino.setBounds(240, 220, 95, 35);
        botonFemenino.setBackground(new Color(209, 242, 235));
        botonFemenino.setToolTipText("Seleccione el sexo del paciente");

        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(botonMasculino);
        grupoBotones.add(botonFemenino);

        // añadir constantes al panel
        panelInfoPaciente.add(EdadPacienteTxt);
        panelInfoPaciente.add(cedulaPacienteTxt);
        panelInfoPaciente.add(nombrePacienteTxt);

        panelInfoPaciente.add(labelTranstorno);
        panelInfoPaciente.add(labelSexo);
        panelInfoPaciente.add(labelNombrePaciente);
        panelInfoPaciente.add(labelEdad);
        panelInfoPaciente.add(labelCedula);

        panelInfoPaciente.add(botonRegistrar);
        panelInfoPaciente.add(botonCancelar);

        panelInfoPaciente.add(comboTranstorno);

        panelInfoPaciente.add(botonMasculino);
        panelInfoPaciente.add(botonFemenino);

    }

    //Metodo para la accion de botones 
    public void actionPerformed(ActionEvent e) {

        //Creacion de instancia para volver al menú principal 
        if (e.getSource() == botonCancelar) {
            
            MenuPrimeraVista instanciaInicio = new MenuPrimeraVista();
            instanciaInicio.setVisible(true);
            this.dispose();

        }
        //Metodo para obtener los datos de los pacientes en los JTField, JComboBox y JRadioButton por medio de variables locales
        

        if (e.getSource() == botonRegistrar) {

            String entradaNombrePaciente = nombrePacienteTxt.getText().trim();
            String entradaCedulaPaciente = cedulaPacienteTxt.getText().trim();
            String entradaEdadPaciente = EdadPacienteTxt.getText().trim();
            String transtornoSeleccionado = (String) comboTranstorno.getSelectedItem();
            boolean masculinoSeleccionado = botonMasculino.isSelected();
            boolean femeninoSeleccionado = botonFemenino.isSelected();

            if (entradaNombrePaciente.isEmpty() || entradaEdadPaciente.isEmpty() || entradaCedulaPaciente.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Verifique que los campos a rellenar no estén vacíos");

            } else if (!entradaNombrePaciente.isEmpty() && !entradaEdadPaciente.isEmpty()
                    && !entradaCedulaPaciente.isEmpty()) {

                int edadPaciente;
                try {

                    edadPaciente = Integer.parseInt(entradaEdadPaciente);
                    if(edadPaciente > 0){

                        if (botonMasculino.isSelected()) {

                            String sexoMasculino = botonMasculino.isSelected() ? "Masculino" : "Masculino";
    
                            //Llamado del Arraylist para guardar los datos del paciente 
    
                            
    
                            JOptionPane.showMessageDialog(null, "Registrado exitosamente");
    
                            MenuPrimeraVista menuPrimeraVista = new MenuPrimeraVista();
                            menuPrimeraVista.setVisible(true);
                            this.dispose();
    
                        }
    
                        //Ciclo if para que las entradas de texto no estan vacios
    
                        if (!botonMasculino.isSelected() && !botonFemenino.isSelected()) {
    
                            JOptionPane.showMessageDialog(null, "Por favor, seleccione el sexo del paciente.");
                            return;
                        }
    
                        else if (botonFemenino.isSelected()) {
    
                            String sexoFemenino = botonFemenino.isSelected() ? "Masculino" : "Masculino";
    
                          
    
                            JOptionPane.showMessageDialog(null, "Registrado exitosamente");
    
                            MenuPrimeraVista menuPrimeraVista = new MenuPrimeraVista();
                            menuPrimeraVista.setVisible(true);
                            this.dispose();
    
                        }
                        
                    } else {

                        JOptionPane.showMessageDialog(null, "Ingrese una edad mayor que 0");
                    }

                    

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null, "Debe ingresar un valor valido para la edad");

                    EdadPacienteTxt.setText(" ");
                }
            } // fin del else if si todas las entradas de texto no estan vacios

        } // Fin boton registrar

       
        

    }// Fin action listener

}// Fin Clase principal

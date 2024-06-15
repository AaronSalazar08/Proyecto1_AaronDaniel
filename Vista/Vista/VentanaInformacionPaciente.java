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
    public JLabel labelNombrePaciente, labelCedula, labelEdad, labelTranstorno, labelSexo, labelTitulo, labelApellido;
    public static JTextField nombrePacienteTxt, apellidoPacienteTxt;
    public static JTextField cedulaPacienteTxt;
    public static JTextField EdadPacienteTxt;
    public static JComboBox comboTranstorno; //JComboBox para poder seleccionar los tipos de transtorno 
    public static JRadioButton botonMasculino, botonFemenino; //Botones para seleccionar el tipo de sexo
    Font fuenteBoton = new Font("Century Schoolbook", Font.PLAIN, 20);
    private ImageIcon imagen;
    private ImageIcon icono;

    public VentanaInformacionPaciente() {
        //Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Registro de Paciente");
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
        //Inicializando constantes para el JPanel

        // JButton

        botonRegistrar = new JButton("");
        botonRegistrar.setBounds(320, 395, 50, 40);
        botonRegistrar.setForeground(Color.BLACK);
        botonRegistrar.setBackground(new Color( 255, 255, 255));
        botonRegistrar.setFont(fuenteBoton);
        botonRegistrar.addActionListener(this);
        botonRegistrar.setToolTipText("Presione el boton para registrar al paciente");
        this.PintarB(this.botonRegistrar, "Vista\\Imagenes\\guardarA.png");
        botonRegistrar.setBorderPainted(false);
        botonRegistrar.setOpaque(false);


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
        nombrePacienteTxt.setBounds(240,60, 95, 20);
        nombrePacienteTxt.setToolTipText("Ingrese el nombre del paciente");

        apellidoPacienteTxt = new JTextField(" ");
        apellidoPacienteTxt.setBounds(240,125, 95, 20);
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






}// Fin Clase principal

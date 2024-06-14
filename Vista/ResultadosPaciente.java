package Vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlador.Principal;
import Modelo.Paciente;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultadosPaciente extends JFrame implements ActionListener {

    public JPanel panelResultado = new JPanel();


    //Declarando constantes

    public JLabel cedula_lb;
    public JTextField cedula_txt;
    public JButton botonVolver;
    public JButton botonBuscar;
    Font fuenteBoton = new Font("Century Schoolbook", Font.PLAIN, 20);
    Font fuenteLabel = new Font("Century Schoolbook", Font.BOLD, 16);
    private String[] cabecera = { "Nombre", "Cédula", "Edad", "Sexo", "Transtorno" };//Titulos a llevar el JTable

    DefaultTableModel modeloTabla = new DefaultTableModel(cabecera, 1) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JTable tablaPacientes = new JTable(modeloTabla);
    JScrollPane scroll = new JScrollPane(tablaPacientes);

    public ResultadosPaciente() {
        //Definiendo caracteristicas al JPanel
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(800, 400);
        this.setContentPane(panelResultado);
        panelResultado.setBackground(new Color(209, 242, 235));
        setLocationRelativeTo(null);
        panelResultado.setLayout(null);
        Elementos();

    }

    public void Elementos() {

    
        cedula_lb = new JLabel("Cédula: ");
        cedula_lb.setBounds(30, 70, 400, 70);
        cedula_lb.setFont(fuenteLabel);

        // JTextField
        cedula_txt = new JTextField();
        cedula_txt.setBounds(110, 100, 150, 20);
        cedula_txt.setFont(fuenteLabel);
        cedula_txt.setToolTipText("Ingrese el numero de cedula que desea buscar");

        // JButton
        botonVolver = new JButton();
        botonVolver.setBounds(40, 300, 65, 30);
        botonVolver.setBackground(new Color(209, 242, 235));
        botonVolver.addActionListener(this);
        botonVolver.setOpaque(false);
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBorderPainted(false);
        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver4.png");
        botonVolver.setToolTipText("Atrás");
        if (iconoVolver != null && iconoVolver.getImage() != null) {
            Image imagenVolverAjustada = iconoVolver.getImage().getScaledInstance(55, 40, Image.SCALE_SMOOTH);
            botonVolver.setIcon(new ImageIcon(imagenVolverAjustada));
        }

        botonBuscar = new JButton();
        botonBuscar.setBounds(300, 100, 65, 30);
        botonBuscar.setBackground(new Color(209, 242, 235));
        botonBuscar.addActionListener(this);
        botonBuscar.setOpaque(false);
        botonBuscar.setContentAreaFilled(false);
        botonBuscar.setBorderPainted(false);
        ImageIcon iconoBuscar = new ImageIcon("Vista/Imagenes/Buscar.png");
        botonBuscar.setToolTipText("Buscar");
        if (iconoBuscar != null && iconoBuscar.getImage() != null) {
            Image imagenBuscarAjustada = iconoBuscar.getImage().getScaledInstance(55, 40, Image.SCALE_SMOOTH);
            botonBuscar.setIcon(new ImageIcon(imagenBuscarAjustada));
        }

        scroll.setBounds(30, 170, 700, 50);

        panelResultado.add(botonVolver);
        panelResultado.add(botonBuscar);
        panelResultado.add(cedula_txt);
        panelResultado.add(cedula_lb);
        panelResultado.add(scroll);

    }

    //Metodo para las acciones de los botones 

    public void actionPerformed(ActionEvent e) {

       //Creacion de instancia para regresar al menu principal 

        if (e.getSource() == botonVolver) {
           
            MenuPrimeraVista instancPrimeraVista = new MenuPrimeraVista();
            instancPrimeraVista.setVisible(true);
            this.dispose();

        }
        //Ciclo if para buscar el registro de un paciente en el JTable 
        if (e.getSource() == botonBuscar) {

            
            try {
                String busqueda = cedula_txt.getText();

                for (Paciente buscado : Principal.listaPacientes) {

                    
    
                    if (buscado.getCedula().equals(busqueda)) {
    
                        JOptionPane.showMessageDialog(null, "Paciente encontrado");
                        for (int contador = 0; contador < Principal.listaPacientes.size(); contador++) {
    
                            Paciente paciente = Principal.listaPacientes.get(contador);
                            tablaPacientes.setValueAt(paciente.getNombre(), contador, 0);
                            tablaPacientes.setValueAt(paciente.getCedula(), contador, 1);
                            tablaPacientes.setValueAt(paciente.getEdad(), contador, 2);
                            tablaPacientes.setValueAt(paciente.getSexo(), contador, 3);
                            tablaPacientes.setValueAt(paciente.getTranstrorno(), contador, 4);
                        }
    
                    } else {
    
                        JOptionPane.showMessageDialog(null, "Paciente no encontrado");
    
                    }

                  
                }
    

            }catch (Exception ex){

                JOptionPane.showMessageDialog(null, " Error");

            }
           
        }

    }

}
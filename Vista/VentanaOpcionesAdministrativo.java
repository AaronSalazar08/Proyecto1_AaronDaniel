package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controlador.Metodos;
import Controlador.Principal;
import Modelo.Paciente;

public class VentanaOpcionesAdministrativo extends JFrame implements ActionListener {

    // Declarando costantes 
    private JPanel panelVentanaOpcionesAdministrativo = new JPanel();
    private JButton botonEliminar, botonVolver;

    private String[] cabecera = { "Nombre", "Cédula", "Edad", "Sexo", "Transtorno" };


    //Creacion de la tabla para mostrar el registro de pacientes
    DefaultTableModel modeloTabla = new DefaultTableModel(cabecera, 10000) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JTable tablaPacientes = new JTable(modeloTabla);
    JScrollPane scroll = new JScrollPane(tablaPacientes);

    Font fuente = new Font("Century Schoolbook", Font.PLAIN, 20);

    public VentanaOpcionesAdministrativo() {

        //Definiendo caracteristicas al JPanel
        this.setTitle("Menú del Administrador");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(800, 400);
        setLocationRelativeTo(null);
        this.getContentPane().add(panelVentanaOpcionesAdministrativo);
        panelVentanaOpcionesAdministrativo.setBackground(new Color(209, 242, 235));
        panelVentanaOpcionesAdministrativo.setLayout(null);


        Elementos();// llamada al metodo de elementos para agregar los elementos del panel a la
                    // interfaz grafica

    }

    public void Elementos() {

     //Inicializando constantes para el JPanel


        // JButton

        //Boton eliminar para eliminar pacientes
        botonEliminar = new JButton();
        botonEliminar.setBounds(650, 250, 50, 50);
        botonEliminar.setForeground(new Color(209, 242, 235));
        botonEliminar.addActionListener(this);
        botonEliminar.setOpaque(false);
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setBorderPainted(false);
        ImageIcon iconoEliminar = new ImageIcon("Vista/Imagenes/Eliminar2.png");
        botonEliminar.setToolTipText("Seleccione un paciente y presione este boton para eliminarlo");
        if (iconoEliminar != null && iconoEliminar.getImage() != null) {
            Image imagenEliminarAjustada = iconoEliminar.getImage().getScaledInstance(70, 50, Image.SCALE_SMOOTH);
            botonEliminar.setIcon(new ImageIcon(imagenEliminarAjustada));
        }

        //Boton para volver al menu principal 
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

      
        // JSCROLLPANE
        scroll.setBounds(40, 30, 700, 200);

        // AGREGAR CONSTANTES AL PANEL

        panelVentanaOpcionesAdministrativo.add(botonVolver);
        panelVentanaOpcionesAdministrativo.add(botonEliminar);
        panelVentanaOpcionesAdministrativo.add(scroll);

        for (int contador = 0; contador < Principal.listaPacientes.size(); contador++) {

            Paciente paciente = Principal.listaPacientes.get(contador);
            tablaPacientes.setValueAt(paciente.getNombre(), contador, 0);
            tablaPacientes.setValueAt(paciente.getCedula(), contador, 1);
            tablaPacientes.setValueAt(paciente.getEdad(), contador, 2);
            tablaPacientes.setValueAt(paciente.getSexo(), contador, 3);
           
        }

    }


    //Metodo para la accion de los botones 

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonVolver) {

            //Creacion de una instancia para regresar a la clase 
            MenuPrimeraVista menuPrimeraVista = new MenuPrimeraVista();
            menuPrimeraVista.setVisible(true);
            this.dispose();

        }

        if (e.getSource() == botonEliminar) {

            //Ciclo if para poder eliminar los datos del paciente en la tabla
            int filaSeleccionada = tablaPacientes.getSelectedRow();

            if (tablaPacientes.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "La tabla está vacía");
                return;
            }
            

            if (filaSeleccionada != -1) {
                

                boolean filaVacia = true;
                int conteoColumna = tablaPacientes.getColumnCount();

                for (int columna = 0; columna < conteoColumna; columna++) {

                    Object valor = tablaPacientes.getValueAt(filaSeleccionada, columna);
                    if (valor != null && !valor.toString().trim().isEmpty()) {
                        filaVacia = false;
                        break;

                    }

                }
                //Ciclo if 

                if (filaVacia) {
                    //Ciclo if para mostrar el estado de la tabla 
                         //metodo para mostrar si una fila esta vacía 
                             //metodo para eliminar un registro de un paciente 

                    JOptionPane.showMessageDialog(null, "La fila seleccionada está vacía");
                    return;
                }
                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que quieres eliminar al paciente seleccionado? ",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {

                    Principal.listaPacientes.remove(filaSeleccionada);

                    modeloTabla.removeRow(filaSeleccionada);
                }

            }

        }

    }

}

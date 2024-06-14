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

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    // Declarando costantes
    private JPanel panelVentanaOpcionesAdministrativo = new JPanel();
    private JButton botonEliminar, botonVolver, botonEditar, botonBuscar, botonRefrescar;
    private JLabel cedulaLabel;
    private JTextField cedula_txt;

    private String[] cabecera = { "Nombre", "Cédula", "Edad", "Sexo", "Transtorno" };

    // Creacion de la tabla para mostrar el registro de pacientes
    DefaultTableModel modeloTabla = new DefaultTableModel(cabecera, 10000) {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JTable tablaPacientes = new JTable(modeloTabla);
    JScrollPane scroll = new JScrollPane(tablaPacientes);

    Font fuente = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 16);
    Font fuenteLabel = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 14);

    public VentanaOpcionesAdministrativo() {

        // Definiendo caracteristicas al JPanel
        this.setTitle("Menú del Administrador");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.getContentPane().add(panelVentanaOpcionesAdministrativo);
        panelVentanaOpcionesAdministrativo.setBackground(new Color(255, 255, 255));
        panelVentanaOpcionesAdministrativo.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171 ), 4));
        panelVentanaOpcionesAdministrativo.setLayout(null);

        Elementos();// llamada al metodo de elementos para agregar los elementos del panel a la
                    // interfaz grafica

    }

    public void Elementos() {

        // Inicializando constantes para el JPanel

        // JLabel
        cedulaLabel = new JLabel("Cédula: ");
        cedulaLabel.setBounds(40, 30, 200, 60);
        cedulaLabel.setFont(fuenteLabel);

        // JTextField

        cedula_txt = new JTextField();
        cedula_txt.setBounds(100, 50, 150, 20);
        cedula_txt.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171)));
        cedula_txt.setFont(fuente);
        cedula_txt.setToolTipText("Ingrese su número de identificación");

        // JButton

        // Boton eliminar para eliminar pacientes
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(420, 40, 140, 30);
        botonEliminar.setBackground(new Color(53, 89, 252));
        botonEliminar.setForeground(new Color(255, 255, 255));
        botonEliminar.addActionListener(this);
        //botonEliminar.setOpaque(false);
        //botonEliminar.setContentAreaFilled(false);
        botonEliminar.setBorderPainted(false);

        ImageIcon iconoEliminar = new ImageIcon("Vista/Imagenes/eliminar.png");
        botonEliminar.setToolTipText("Eliminar Paciente");
        if (iconoEliminar != null && iconoEliminar.getImage() != null) {
            Image imagenEliminarAjustada = iconoEliminar.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH);
            botonEliminar.setIcon(new ImageIcon(imagenEliminarAjustada));
        }

        botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(270, 40, 140, 30);
        botonBuscar.setForeground(new Color(255, 255, 255));
        botonBuscar.setBackground(new Color(53, 89, 252));
        botonBuscar.addActionListener(this);
        // botonBuscar.setOpaque(false);
        // botonBuscar.setContentAreaFilled(false);
        botonBuscar.setBorderPainted(false);

        ImageIcon iconoBuscar = new ImageIcon("Vista/Imagenes/buscar.png");
        botonBuscar.setToolTipText("Buscar Paciente");
        if (iconoBuscar != null && iconoBuscar.getImage() != null) {
            Image imagenBuscarAjustada = iconoBuscar.getImage().getScaledInstance(40, 30,
                    Image.SCALE_SMOOTH);
            botonBuscar.setIcon(new ImageIcon(imagenBuscarAjustada));
        }

        botonEditar = new JButton("Editar");
        botonEditar.setBounds(570, 40, 150, 30);
        botonEditar.setForeground(new Color(255, 255, 255));
        botonEditar.setBackground(new Color(53, 89, 252));
        botonEditar.addActionListener(this);
        // botonEditar.setOpaque(false);
        // botonEditar.setContentAreaFilled(false);
        botonEditar.setBorderPainted(false);

       
          ImageIcon iconoEditar = new ImageIcon("Vista/Imagenes/editar.png");
          botonEditar.setToolTipText("Editar Paciente");
          if (iconoEditar != null && iconoEditar.getImage() != null) {
          Image imagenEditarAjustada = iconoEditar.getImage().getScaledInstance(40, 30,
          Image.SCALE_SMOOTH);
          botonEditar.setIcon(new ImageIcon(imagenEditarAjustada));
          }
         

        // Boton para volver al menu principal
        botonVolver = new JButton("Volver");
        botonVolver.setBounds(40, 500, 150, 30);
        botonVolver.setForeground(new Color(255, 255, 255));
        botonVolver.setBackground(new Color(53, 89, 252));
        botonVolver.addActionListener(this);
        // botonVolver.setOpaque(false);
        // botonVolver.setContentAreaFilled(false);
       botonVolver.setBorderPainted(false);

        
         ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver (1).png");
         botonVolver.setToolTipText("Atrás");
         if (iconoVolver != null && iconoVolver.getImage() != null) {
         Image imagenVolverAjustada = iconoVolver.getImage().getScaledInstance(55, 40,
         Image.SCALE_SMOOTH);
         botonVolver.setIcon(new ImageIcon(imagenVolverAjustada));
         }

         // Boton para volver al menu principal
         botonRefrescar = new JButton("Refrescar");
         botonRefrescar.setBounds(590, 470, 150, 30);
         botonRefrescar.setForeground(new Color(255, 255, 255));
         botonRefrescar.setBackground(new Color(53, 89, 252));
         botonRefrescar.addActionListener(this);
        // botonRefrescar.setOpaque(false);
        // botonRefrescar.setContentAreaFilled(false);
       botonRefrescar.setBorderPainted(false);

        
         ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/refrescar (1).png");
         botonRefrescar.setToolTipText("Refrescar Tabla");
         if (iconoVolver != null && iconoRefrescar.getImage() != null) {
         Image imagenRefrescarAjustada = iconoRefrescar.getImage().getScaledInstance(40, 30,
         Image.SCALE_SMOOTH);
         botonRefrescar.setIcon(new ImageIcon(imagenRefrescarAjustada));
         }
         

        // JSCROLLPANE
        scroll.setBounds(40, 100, 700, 350);

        // AGREGAR CONSTANTES AL PANEL

        panelVentanaOpcionesAdministrativo.add(cedulaLabel);
        panelVentanaOpcionesAdministrativo.add(botonBuscar);
        panelVentanaOpcionesAdministrativo.add(cedula_txt);
        panelVentanaOpcionesAdministrativo.add(botonVolver);
        panelVentanaOpcionesAdministrativo.add(botonEliminar);
        panelVentanaOpcionesAdministrativo.add(botonEditar);
        panelVentanaOpcionesAdministrativo.add(botonRefrescar);
        panelVentanaOpcionesAdministrativo.add(scroll);

        for (int contador = 0; contador < Principal.listaPacientes.size(); contador++) {

            Paciente paciente = Principal.listaPacientes.get(contador);
            tablaPacientes.setValueAt(paciente.getNombre(), contador, 0);
            tablaPacientes.setValueAt(paciente.getCedula(), contador, 1);
            tablaPacientes.setValueAt(paciente.getEdad(), contador, 2);
            tablaPacientes.setValueAt(paciente.getSexo(), contador, 3);

        }

    }

    // Metodo para la accion de los botones

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonVolver) {

            // Creacion de una instancia para regresar a la clase
            MenuPrimeraVista menuPrimeraVista = new MenuPrimeraVista();
            menuPrimeraVista.setVisible(true);
            this.dispose();

        }

        if (e.getSource() == botonEliminar) {

            // Ciclo if para poder eliminar los datos del paciente en la tabla
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
                // Ciclo if

                if (filaVacia) {
                    // Ciclo if para mostrar el estado de la tabla
                    // metodo para mostrar si una fila esta vacía
                    // metodo para eliminar un registro de un paciente

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

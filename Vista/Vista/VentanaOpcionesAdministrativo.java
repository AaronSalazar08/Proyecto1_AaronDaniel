package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Controlador.Metodos;
import Controlador.Principal;
import Modelo.Paciente;

public class VentanaOpcionesAdministrativo extends JFrame implements ActionListener {

    //Metodo para la llamada de los metodos de las constantes mediante una instacia de la clase Metodos
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    //Instancia para la clase 
    public static Metodos metodos;

    // Declarando costantes
    public JPanel panelVentanaOpcionesAdministrativo = new JPanel();
    public JButton botonEliminar, botonVolver, botonEditar, botonBuscar, botonRefrescar;
    public JLabel cedulaLabel;
    public JTextField cedula_txt;

    public DefaultTableModel model;
    public JTable tablaPacientes;
    public JScrollPane scroll;

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
        panelVentanaOpcionesAdministrativo.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171), 4));
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
        
        botonVolver.setBorderPainted(false);

        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver (1).png");
        botonVolver.setToolTipText("Atrás");
        if (iconoVolver != null && iconoVolver.getImage() != null) {
            Image imagenVolverAjustada = iconoVolver.getImage().getScaledInstance(55, 40,
                    Image.SCALE_SMOOTH);
            botonVolver.setIcon(new ImageIcon(imagenVolverAjustada));
        }

        
        botonRefrescar = new JButton("Refrescar");
        botonRefrescar.setBounds(590, 470, 150, 30);
        botonRefrescar.setForeground(new Color(255, 255, 255));
        botonRefrescar.setBackground(new Color(53, 89, 252));
        botonRefrescar.addActionListener(this);
       
        botonRefrescar.setBorderPainted(false);

        ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/refrescar (1).png");
        botonRefrescar.setToolTipText("Refrescar Tabla");
        if (iconoVolver != null && iconoRefrescar.getImage() != null) {
            Image imagenRefrescarAjustada = iconoRefrescar.getImage().getScaledInstance(40, 30,
                    Image.SCALE_SMOOTH);
            botonRefrescar.setIcon(new ImageIcon(imagenRefrescarAjustada));
        }

        // JSCROLLPANE
        model = new DefaultTableModel();
        tablaPacientes = new JTable(model);
        scroll = new JScrollPane(tablaPacientes);
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

            metodos.Administrador_Principal();

        }
        if (e.getSource() == botonRefrescar) {

            metodos.mostrarDatosEnTabla();
        }
        if (e.getSource() == botonEditar) {

            metodos.Administrador_Editar();
            metodos.buscarPorCedulaParaEditar();

        }
        if (e.getSource() == botonBuscar) {

            metodos.buscarPorCedulaParaMostrar();

        }

        if (e.getSource() == botonEliminar) {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Estás seguro de que quieres eliminar al paciente seleccionado? ",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                metodos.EliminarElementos();

            }

        }

    }

}

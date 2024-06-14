package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;

import Controlador.Metodos;

import java.awt.Font;
import java.awt.Image;



public class AcercaNosotros extends JFrame implements ActionListener {

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    public JPanel panelAcercaNosotros = new JPanel();
    JLabel fotoAaron, fotoDaniel, informacionAaron, informacionDaniel, tituloLabel;
    JButton botonVolver;
    private ImageIcon imagen;
    private ImageIcon icono;
    Font fuenteLabel = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 14);
    Font fuenteTitulo = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 20);

    public AcercaNosotros() {

        this.setTitle("Acerca de Nosotros");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.getContentPane().add(panelAcercaNosotros);
        panelAcercaNosotros.setBackground(new Color(255, 255, 255));
        panelAcercaNosotros.setLayout(null);

        Elementos();// llamada al metodo de elementos para agregar los elementos del panel a la
                    // interfaz grafica

    }

    public void Elementos() {

        fotoAaron = new JLabel();
        fotoAaron.setBounds(210, 100, 180, 180);
        this.Pintar(this.fotoAaron, "Vista\\Imagenes\\henry.jpg");
        fotoAaron.setBorder(BorderFactory.createLineBorder(new Color(53, 89, 252), 4));

        fotoDaniel = new JLabel();
        fotoDaniel.setBounds(210, 350, 180, 180);
        fotoDaniel.setBorder(BorderFactory.createLineBorder(new Color(53, 89, 252), 4));
        this.Pintar(this.fotoDaniel, "Vista\\Imagenes\\michael.jpg");

        informacionAaron = new JLabel("Soy Aaron, el Superman de la Programacion");
        informacionAaron.setBounds(400, 100, 400, 60);
        informacionAaron.setFont(fuenteLabel);

        informacionDaniel = new JLabel("Soy Daniel, el Creed de la Programacion");
        informacionDaniel.setBounds(400, 350, 400, 60);
        informacionDaniel.setFont(fuenteLabel);

        tituloLabel = new JLabel("Conócenos ");
        tituloLabel.setBounds(400, 20, 400, 60);
        tituloLabel.setFont(fuenteTitulo);

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

        panelAcercaNosotros.add(fotoAaron);
        panelAcercaNosotros.add(fotoDaniel);
        panelAcercaNosotros.add(informacionAaron);
        panelAcercaNosotros.add(informacionDaniel);
        panelAcercaNosotros.add(tituloLabel);
        panelAcercaNosotros.add(botonVolver);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botonVolver){

            metodos.AcercaNosotros_Principal();
        }

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

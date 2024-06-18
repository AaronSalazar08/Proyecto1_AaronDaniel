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
    JLabel fotoAaron, fotoDaniel, informacionAaron, informacionDaniel, tituloLabel, acercaNosotros, informacionCentro;
    JButton botonVolver;
    private ImageIcon imagen;
    private ImageIcon icono;
    Font fuenteLabel = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 14);
    Font fuenteTitulo = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 20);
    Font fuenteInformacion = new Font("Century Schoolbook", Font.ROMAN_BASELINE, 14);

    public AcercaNosotros() {

        this.setTitle("Acerca de Nosotros");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
        setLocationRelativeTo(null);
        this.getContentPane().add(panelAcercaNosotros);
        panelAcercaNosotros.setBackground(new Color(255, 255, 255));
        panelAcercaNosotros.setLayout(null);
        panelAcercaNosotros.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171), 4));

        Elementos();// llamada al metodo de elementos para agregar los elementos del panel a la
                    // interfaz grafica

    }

    public void Elementos() {

        fotoAaron = new JLabel();
        fotoAaron.setBounds(50, 80, 140, 140);
        this.Pintar(this.fotoAaron, "Vista\\Imagenes\\henry.jpg");
        fotoAaron.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171), 4));

        fotoDaniel = new JLabel();
        fotoDaniel.setBounds(350, 80, 140, 140);
        fotoDaniel.setBorder(BorderFactory.createLineBorder(new Color(171, 171, 171), 4));
        this.Pintar(this.fotoDaniel, "Vista\\Imagenes\\michael.jpg");

        informacionAaron = new JLabel("Aarón Salazar Mata ");
        informacionAaron.setBounds(200, 80, 400, 60);
        informacionAaron.setFont(fuenteLabel);

        informacionDaniel = new JLabel("José Daniel Solís Cordoncillo");
        informacionDaniel.setBounds(500, 80, 400, 60);
        informacionDaniel.setFont(fuenteLabel);

        tituloLabel = new JLabel("Derechos Reservados a:  ");
        tituloLabel.setBounds(50, 20, 400, 60);
        tituloLabel.setFont(fuenteTitulo);

        acercaNosotros = new JLabel("Acerca de");
        acercaNosotros.setBounds(50, 250, 200, 40);
        acercaNosotros.setFont(fuenteTitulo);

        informacionCentro = new JLabel("<html>Somos un centro de apoyo dedicado al tratamiento de los niños con transtornos mentales.<br>Hemos decidido contribuir a la sociedad con nuestro grano de arena para atender a estas personas, pues han sufrido en los últimos años graves discapacidades en sus alrededores.<br>  <br>Para más información contactenos por medio la mensajeria WhatsApp o vía Teléfono.</html>");
        informacionCentro.setBounds(50, 250, 580, 200);
        informacionCentro.setFont(fuenteInformacion);

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
        panelAcercaNosotros.add(informacionCentro);
        panelAcercaNosotros.add(acercaNosotros);
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

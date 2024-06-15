package Controlador;

import java.util.ArrayList;



import Modelo.Paciente;
import Vista.AcercaNosotros;
<<<<<<< HEAD
import Vista.VentanaInformacionPaciente;
=======
import Vista.LoginAdmin;
import Vista.MenuPrimeraVista;
import Vista.VentanaInformacionPaciente;
import Vista.VentanaOpcionesAdministrativo;
>>>>>>> 46d4766d6c0ea5d6e760822fa76c0aa535ccea2b

public class Principal {

    // Creacion de Arraylist para la clase paciente
    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public static void main(String[] args) {

        MenuPrimeraVista vistaPrincipal = new MenuPrimeraVista();
        LoginAdmin logIn = new LoginAdmin();
        AcercaNosotros acercaNosotros = new AcercaNosotros();
        VentanaInformacionPaciente registroPaciente = new VentanaInformacionPaciente();
        VentanaOpcionesAdministrativo administrativo = new VentanaOpcionesAdministrativo();

        // Se crea una instancia de la Clase Metdos en donde se le pasan como
        // paramatreos las instancias de las clases anteriormente mencionadas
        Metodos metodos = new Metodos(logIn, acercaNosotros, vistaPrincipal, registroPaciente, administrativo);

        // Para cada instancia se le incova el metodo se "setMetodos", el cual es un
        // metodo constructor para poder trabajar con la clase metodos en todas las
        // clases instanciadas anteriormente
        vistaPrincipal.setMetodos(metodos);
        logIn.setMetodos(metodos);
        acercaNosotros.setMetodos(metodos);
        registroPaciente.setMetodos(metodos);
        administrativo.setMetodos(metodos);

<<<<<<< HEAD
        VentanaInformacionPaciente a = new VentanaInformacionPaciente();
        a.setVisible(true);
         
        
=======

        // Se hace visible la clase LogIn que es donde el usuario inicia sesion
        logIn.setVisible(true);
>>>>>>> 46d4766d6c0ea5d6e760822fa76c0aa535ccea2b

    }

}

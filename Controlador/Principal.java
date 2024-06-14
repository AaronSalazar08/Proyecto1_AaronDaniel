package Controlador;




import java.util.ArrayList;


import Modelo.Paciente;
import Vista.MenuPrimeraVista;
import Vista.LoginAdmin;


public class Principal {

    //Creacion de Arraylist para la clase paciente 
    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public static void main(String[] args) {


        //Creacion de instancia para llamar al JFrame del menú principal 
        
        MenuPrimeraVista menuPrimeraVista = new MenuPrimeraVista();
        menuPrimeraVista.setVisible(true);
        

        


    }

}

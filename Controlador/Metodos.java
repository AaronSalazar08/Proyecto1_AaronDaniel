package Controlador;


import Modelo.Paciente;
import Vista.ResultadosPaciente;

public class Metodos {



    

    //Metodo para poder guardar los datos de los pacientes por medio del Arraylist 


    public static void RegistrarPacientes(String nombre, String cedula, String sexo, int edad, String transtorno ) {

        Principal.listaPacientes.add(new Paciente(nombre, cedula, sexo, edad, transtorno));

    }

}

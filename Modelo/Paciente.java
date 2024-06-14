package Modelo;

public class Paciente extends Persona {

  protected String transtorno;

public Paciente(String nombre, String cedula, String sexo, int edad, String transtrorno) {
    super(nombre, cedula, sexo, edad);
    this.transtorno = transtrorno;
}

public String getTranstrorno() {
    return transtorno;
}

public void setTranstrorno(String transtorno) {
    this.transtorno = transtorno;
}




}
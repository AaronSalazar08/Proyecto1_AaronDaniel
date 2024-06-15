package Modelo;

public class Paciente  {

  protected String transtorno;
  protected String nombre;
  protected String apellido;
  protected String cedula;
  protected String sexo;
  protected int edad;




public Paciente(String transtorno, String nombre, String apellido, String cedula, String sexo, int edad) {
    this.transtorno = transtorno;
    this.nombre = nombre;
    this.apellido = apellido;
    this.cedula = cedula;
    this.sexo = sexo;
    this.edad = edad;
}


public String getTranstorno() {
    return transtorno;
}
public void setTranstorno(String transtorno) {
    this.transtorno = transtorno;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getCedula() {
    return cedula;
}
public void setCedula(String cedula) {
    this.cedula = cedula;
}
public String getSexo() {
    return sexo;
}
public void setSexo(String sexo) {
    this.sexo = sexo;
}
public int getEdad() {
    return edad;
}
public void setEdad(int edad) {
    this.edad = edad;
}



}
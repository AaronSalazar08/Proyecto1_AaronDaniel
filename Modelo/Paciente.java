package Modelo;

public class Paciente  {

  protected String transtorno;
  protected String nombre;
  protected String cedula;
  protected String sexo;
  protected int edad;

public Paciente(String nombre, String cedula, String sexo, int edad, String transtrorno) {
  
    this.transtorno = transtrorno;
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
package entidades;

public class Empleado {
  private int dni;
  private String apellido;
  private String nombre;
  private String mail;
  private Double sueldoBase;

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Double getSueldoBase() {
    return sueldoBase;
  }

  public void setSueldoBase(Double sueldoBase) {
    this.sueldoBase = sueldoBase;
  }

  public Double getSueldo() {
    return sueldoBase;
  }

  public Empleado() {
    this(0, "", "", "", 0.0);
  }

  public Empleado(int dni, String apellido, String nombre, String mail, Double sueldoBase) {
    this.setApellido(apellido);
    this.setDni(dni);
    this.setNombre(nombre);
    this.setMail(mail);
    this.setSueldoBase(sueldoBase);
  }

  public void mostrarEmpleado(int i, Double sueldo) {
    int dni;
    String nombre, apellido;
    dni = this.getDni();
    apellido = this.getApellido();
    nombre = this.getNombre();
    System.out.print("Empleado " + (i + 1) +" --> Dni: " + dni + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Sueldo: " + sueldo + "\n");
  }
}

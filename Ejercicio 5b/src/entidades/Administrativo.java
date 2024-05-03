package entidades;

public class Administrativo extends Empleado {
  private int hsExtra;
  private int hsMes;

  public int getHsExtra() {
    return hsExtra;
  }

  public void setHsExtra(int hsExtra) {
    this.hsExtra = hsExtra;
  }

  public int getHsMes() {
    return hsMes;
  }

  public void setHsMes(int hsMes) {
    this.hsMes = hsMes;
  }

  public Administrativo() {
    this(0, "", "", "", 0.0, 0, 0);
  }

  public Administrativo(int dni, String nombre, String apellido, String mail, Double sueldoBase, int hsExtra, int hsMes) {
    super(dni, apellido, nombre, mail, sueldoBase);
    this.setHsExtra(hsExtra);
    this.setHsMes(hsMes);
  }

  public Double getSueldo() {
    Double sueldo;
    sueldo = this.getSueldoBase() * ((this.getHsExtra() * 1.5f) + this.getHsMes()) / this.getHsMes();
    return sueldo;
  }
}
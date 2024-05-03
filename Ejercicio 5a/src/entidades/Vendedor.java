package entidades;

public class Vendedor extends Persona {
  private Double porcenComision;
  private int totalVentas;

  public Double getPorcenComision() {
    return porcenComision;
  }

  public void setPorcenComision(Double porcenComision) {
    this.porcenComision = porcenComision;
  }

  public int getTotalVentas() {
    return totalVentas;
  }

  public void setTotalVentas(int totalVentas) {
    this.totalVentas = totalVentas;
  }

  public Vendedor() {
    this(0, "", "", "", 0.0, 0.0, 0);
  }

  public Vendedor(int dni, String nombre, String apellido, String mail, Double sueldoBase, Double porcentaje,
      int ventasTot) {
    super(dni, apellido, nombre, mail, sueldoBase);
    this.setPorcenComision(porcentaje);
    this.setTotalVentas(ventasTot);
  }

  public Double getSueldo() {
    Double sueldo;
    sueldo = this.getSueldoBase() + (this.getPorcenComision() * this.getTotalVentas()) / 100;
    return sueldo;
  }
}
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Empleado extends Persona {

protected String idEmpleado;
protected double salarioBase;
protected LocalDate fechaContratacion;
protected String departamento;
protected double jornadaHoraria; // horas por día
protected boolean activo;

public Empleado(String dni, String nombre, int edad,
String idEmpleado,
double salarioBase,
LocalDate fechaContratacion,
String departamento,
double jornadaHoraria,
boolean activo) {

super(dni, nombre, edad);
this.idEmpleado = idEmpleado;
this.salarioBase = salarioBase;
this.fechaContratacion = fechaContratacion;
this.departamento = departamento;
this.jornadaHoraria = jornadaHoraria;
this.activo = activo;
}


public int calcularAntiguedad() {
return (int) ChronoUnit.YEARS.between(fechaContratacion, LocalDate.now());
}


public double calcularSalario() {
int antiguedad = calcularAntiguedad();
double plusAntiguedad = salarioBase * 0.03 * antiguedad;
return salarioBase + plusAntiguedad;
}

@Override
public String toString() {
return "Empleado{" +
"ID='" + idEmpleado + '\'' +
", Nombre='" + nombre + '\'' +
", DNI='" + getDni() + '\'' +
", Edad=" + edad +
", Departamento='" + departamento + '\'' +
", Antigüedad=" + calcularAntiguedad() + " años" +
", Jornada=" + jornadaHoraria + "h/día" +
", Activo=" + activo +
", Salario=" + calcularSalario() +
'}';
}
}
public class Empleado extends Persona {
    protected double salarioBase;
    protected int antiguedadAnios;

    
    public Empleado(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios) {
        super(dni, nombre, edad);
        this.salarioBase = salarioBase;
        this.antiguedadAnios = antiguedadAnios;
    }

    
    public double calcularSalario() {
        return salarioBase + (antiguedadAnios * 100);
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", DNI: " + getDni() +
               ", Edad: " + edad + ", Salario: " + calcularSalario();
    }
}
public abstract class Empleado extends Persona {
    protected double salarioBase;
    protected int antiguedadAnios;

    
    public Empleado(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios) {
        super(dni, nombre, edad);
        this.salarioBase = salarioBase;
        this.antiguedadAnios = antiguedadAnios;
    }

    
    public abstract double calcularSalario() {
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", DNI: " + getDni() +
               ", Edad: " + edad + ", Salario: " + calcularSalario();
    }
}
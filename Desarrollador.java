public class Desarrollador extends Empleado {
    private String lenguajePrincipal;

    public Desarrollador(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios, String lenguajePrincipal) {
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguaje) {
        this.lenguajePrincipal = lenguaje;
    }

    @Override
    public double calcularSalario() {
        double bono = lenguajePrincipal.equalsIgnoreCase("Java") ? 500 : 300;
        return salarioBase + (antiguedadAnios * 150) + bono;
    }

    @Override
    public String toString() {
        return "Desarrollador: " + nombre + " (" + lenguajePrincipal + "), DNI: " + getDni() +
               ", Edad: " + edad + ", Salario: " + calcularSalario();
    }
}



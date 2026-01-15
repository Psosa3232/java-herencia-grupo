public class Manager extends Empleado {
    protected int personasACargo;

   
    public Manager(String dni, String nombre, int edad, double salarioBase, int antiguedadAnios, int personasACargo) {
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.personasACargo = personasACargo;
    }

    
    public int getPersonasACargo() {
        return personasACargo;
    }

    public void setPersonasACargo(int personas) {
        this.personasACargo = personas;
    }

    
    @Override
    public double calcularSalario() {
        return salarioBase + (antiguedadAnios * 200) + (personasACargo * 50);
    }

    @Override
    public String toString() {
        return "Manager: " + nombre + ", DNI: " + getDni() +
               ", Edad: " + edad + ", A cargo de: " + personasACargo +
               ", Salario: " + calcularSalario();
    }
}
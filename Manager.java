import java.time.LocalDate;

public class Manager extends Empleado {
    protected int personasACargo;
    protected String titulo; // "Team Lead", "Department Head", "Director"
    protected double presupuestoGestionado;
    protected int reunionesSemanales;

   
    public Manager(String dni, String nombre, LocalDate fecha_Nacimiento, double salarioBase, int antiguedadAnios, 
                   int personasACargo, String titulo, double presupuestoGestionado, int reunionesSemanales) {
        super(dni, nombre, fecha_Nacimiento, salarioBase, antiguedadAnios); 
        this.personasACargo = personasACargo;
        this.titulo = titulo;
        this.presupuestoGestionado = presupuestoGestionado;
        this.reunionesSemanales = reunionesSemanales;
    }

    
    public int getPersonasACargo() {
        return personasACargo;
    }

    public void setPersonasACargo(int personas) {
        this.personasACargo = personas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPresupuestoGestionado() {
        return presupuestoGestionado;
    }

    public void setPresupuestoGestionado(double presupuesto) {
        this.presupuestoGestionado = presupuesto;
    }

    public int getReunionesSemanales() {
        return reunionesSemanales;
    }

    public void setReunionesSemanales(int reuniones) {
        this.reunionesSemanales = reuniones;
    }

    @Override
    public double calcularSalario() {
        double plusPersonas = personasACargo * 250; // 250€ por persona a cargo
        double bonusPresupuesto = presupuestoGestionado * 0.002; // 0.2% del presupuesto gestionado
        return getSalarioBase() + (getAntiguedadAnios() * 200) + plusPersonas + bonusPresupuesto;
    }

    public void aprobarHorasExtra(String idDesarrollador, double horas) {
        System.out.println("El manager " + getNombre() + " ha aprobado " + horas + 
                          " horas extra para el desarrollador con ID: " + idDesarrollador);
    }

    @Override
    public String toString() {
        return titulo + ": " + getNombre() + ", DNI: " + getDni() +
               ", Edad: " + getEdad() + 
               ", Personas a cargo: " + personasACargo +
               ", Presupuesto gestionado: " + presupuestoGestionado + "€" +
               ", Reuniones semanales: " + reunionesSemanales +
               ", Salario: " + calcularSalario() + "€";
    }
}
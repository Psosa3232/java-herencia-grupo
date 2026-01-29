
// Clase Persona

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
    private String dni;
    protected String nombre;
    protected LocalDate fechaNacimiento; // Reemplaza 'edad'
    private String email;
    private String telefono;

    // Constructor completo
    public Persona(String dni, String nombre, LocalDate fechaNacimiento, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método para calcular la edad dinámicamente
    public int calcularEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String presentarse() {
        return "Hola, me llamo " + nombre + " y tengo " + calcularEdad() + " años.";
    }
}

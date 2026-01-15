// Clase Persona
public class Persona {
    private String dni;
    protected String nombre;
    protected int edad;

    // Constructor completo
    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String presentarse() {
        return "Hola, me llamo " + nombre + " y tengo " + edad + " años.";
    }
}

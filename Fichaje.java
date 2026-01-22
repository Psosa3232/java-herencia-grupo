import java.time.LocalDateTime;

public class Fichaje {
    private String idFichaje;
    private String idEmpleado;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private String tipo; // "ENTRADA", "SALIDA", "PAUSA"

    // Tipos válidos
    public static final String TIPO_ENTRADA = "ENTRADA";
    public static final String TIPO_SALIDA = "SALIDA";
    public static final String TIPO_PAUSA = "PAUSA";

    public Fichaje(String idFichaje, String idEmpleado, LocalDateTime fechaHora, String tipo) {
        this.idFichaje = idFichaje;
        this.idEmpleado = idEmpleado;
        this.tipo = tipo;
        if (tipo.equals(TIPO_ENTRADA) || tipo.equals(TIPO_PAUSA)) {
            this.fechaHoraEntrada = fechaHora;
        } else if (tipo.equals(TIPO_SALIDA)) {
            this.fechaHoraSalida = fechaHora;
        }
    }

    // Getters
    public String getIdFichaje() {
        return idFichaje;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public String getTipo() {
        return tipo;
    }

    // setter
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
}
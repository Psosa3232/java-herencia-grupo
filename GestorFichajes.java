import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class GestorFichajes {

    // Mapa: idEmpleado -> lista de fichajes
    private Map<String, List<Fichaje>> fichajes = new HashMap<>();

    // Registra una entrada
    public void registrarEntrada(String idEmpleado) {
        Fichaje fichaje = new Fichaje("ID" + System.currentTimeMillis(), idEmpleado, LocalDateTime.now(), "ENTRADA");
        if (!fichajes.containsKey(idEmpleado)) {
            fichajes.put(idEmpleado, new ArrayList<>());
        }
        fichajes.get(idEmpleado).add(fichaje);
    }

    // Registra una salida
    public void registrarSalida(String idEmpleado) {
        Fichaje fichaje = new Fichaje("ID" + System.currentTimeMillis(), idEmpleado, LocalDateTime.now(), "SALIDA");
        if (!fichajes.containsKey(idEmpleado)) {
            fichajes.put(idEmpleado, new ArrayList<>());
        }
        fichajes.get(idEmpleado).add(fichaje);
    }

    // Devuelve los fichajes de un empleado en una fecha dada
    public List<Fichaje> obtenerFichajesDelDia(String idEmpleado, LocalDate fecha) {
        List<Fichaje> resultado = new ArrayList<>();
        List<Fichaje> lista = fichajes.get(idEmpleado);
        if (lista == null) return resultado;

        for (Fichaje fichaje : lista) {
            LocalDateTime momento = fichaje.getFechaHoraEntrada() != null ? fichaje.getFechaHoraEntrada() : fichaje.getFechaHoraSalida();
            if (momento != null && momento.toLocalDate().equals(fecha)) {
                resultado.add(fichaje);
            }
        }
        return resultado;
    }

    // Calcula horas trabajadas en un mes y año 
    public double calcularHorasMensuales(String idEmpleado, int mes, int año) {
        List<Fichaje> lista = fichajes.get(idEmpleado);
        if (lista == null || lista.isEmpty()) return 0.0;

        // Filtrar fichajes del mes/año
        List<Fichaje> delMes = new ArrayList<>();
        for (Fichaje fichaje : lista) {
            LocalDateTime m = fichaje.getFechaHoraEntrada() != null ? fichaje.getFechaHoraEntrada() : fichaje.getFechaHoraSalida();
            if (m != null && m.getMonthValue() == mes && m.getYear() == año) {
                delMes.add(fichaje);
            }
        }

        // Ordenar por hora
        delMes.sort((a, b) -> {
            LocalDateTime aT = a.getFechaHoraEntrada() != null ? a.getFechaHoraEntrada() : a.getFechaHoraSalida();
            LocalDateTime bT = b.getFechaHoraEntrada() != null ? b.getFechaHoraEntrada() : b.getFechaHoraSalida();
            return aT.compareTo(bT);
        });

        double totalHoras = 0.0;
        for (int i = 0; i < delMes.size() - 1; i++) {
            Fichaje ent = delMes.get(i);
            Fichaje sal = delMes.get(i + 1);
            if (ent.getTipo().equals("ENTRADA") && sal.getTipo().equals("SALIDA")) {
                long minutos = java.time.temporal.ChronoUnit.MINUTES.between(
                    ent.getFechaHoraEntrada(),
                    sal.getFechaHoraSalida()
                );
                totalHoras += minutos / 60.0;
                i++; // saltar la salida ya usada
            }
        }
        return totalHoras;
    }

    // Genera un reporte simple como texto
    public String generarReporteAsistencia(String idEmpleado, int mes, int año) {
        double horas = calcularHorasMensuales(idEmpleado, mes, año);
        String reporte = "";
        reporte += "REPORTE DE ASISTENCIA\n";
        reporte += "Empleado: " + idEmpleado + "\n";
        reporte += "Mes/Año: " + mes + "/" + año + "\n";
        reporte += "Horas trabajadas: " + String.format("%.2f", horas) + " h\n";
        return reporte;
    }
}
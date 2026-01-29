import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Empleado> empleados = new ArrayList<>();
        
        
        Empleado emp1 = new Empleado("12345678A", "Ana García", 35, 2500.0, 5);
        empleados.add(emp1);
        
        
        Desarrollador dev1 = new Desarrollador("87654321B", "Carlos López", 28, 3200.0, 3, "Java");
        empleados.add(dev1);
        
       
        Manager mgr1 = new Manager("11223344C", "María Fernández", 42, 4500.0, 10, 8);
        empleados.add(mgr1);
        
       
        System.out.println("=== GESTIÓN DE EMPLEADOS ===\n");
        
        for (Empleado e : empleados) {
            
            System.out.println("Tipo: " + e.getClass().getSimpleName());
            
            
            System.out.println("Presentación: " + e.presentarse());
            
            System.out.println("Salario: " + e.calcularSalario() + " €");
            System.out.println("------------------------\n");
        }
    }
}

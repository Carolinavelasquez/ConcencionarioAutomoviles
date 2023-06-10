
package interfaces;

import java.util.ArrayList;
import modelo.Empleados;


public interface InterfaceEmpleado {
    public String insertEmpleado(Empleados empleado);
    public String updateEmpleado(Empleados empleado);
    public String deleteEmpleado(Empleados empleado);
    public Empleados selectEmpleado(Empleados id);
    public ArrayList<Empleados>listEmpleado();
    
    
}
